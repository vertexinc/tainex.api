package com.tie.app;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.xml.bind.JAXBException;

import com.tie.app.cts.TieCtsStub;
import com.tie.model.TieApp;
import com.tie.model.TieMsg;
import com.tie.model.TieMsgPackage;
import com.tie.model.TieUser;
import com.tie.xmlprocessor.cbcrxmlprocessor.CbcrXmlProcessor;

public class UcControllerReceiveTieMsg {
	// Find all the new messages, returns a list of file names, one for each
	// message.
	TieCtsStub tieCtsStub = new TieCtsStub();
	
	public String[] checkForNewMessages(String owner) {
		//Hard coded country code:tieUser does not have country attr, tieapp contains country info
		String lookUpCode = owner + "@mx";
		String[] newMessages = tieCtsStub.checkForNewMessage(lookUpCode);
		return newMessages;
	}

	// Receive one new message:Processing the new message stored in the given
	// file, decryt, parse xml to java objects, save to database, etc
	public TieMsgPackage receiveNewMessage(String msgFileName) throws ClassNotFoundException, IOException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, JAXBException {
		// Read file
		byte[] tieMsgPkgData = tieCtsStub.readFromFile(msgFileName);
		TieMsgPackage tieMsgPkg =  tieCtsStub.receiveTieMsgPackage(tieMsgPkgData);
		
		// Decrypt
		TieSecurityManager tieSecurityManager = new TieSecurityManager();
		String tieMsgXMLString = tieSecurityManager.decryptMsgBody(tieMsgPkg);
		// Parse into java obj
		deComposeCbcrMsg(tieMsgXMLString);
		// Save into database
		return null; 
	}
	
	public TieMsg deComposeCbcrMsg(String tieMsgXMLString) throws JAXBException {
		CbcrXmlProcessor cbcrXmlProcessor = new CbcrXmlProcessor();
		cbcrXmlProcessor.deComposeXmlString(tieMsgXMLString);
		return null;
	}// end composeCbcrMsg(.)
}
