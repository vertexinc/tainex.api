package com.tie.app;

import com.tie.app.cts.TieCtsStub;
import com.tie.model.TieApp;
import com.tie.model.TieMsgPackage;
import com.tie.model.TieUser;

public class UcControllerReceiveTieMsg {
	// Find all the new messages, returns a list of file names, one for each
	// message.
	public String[] checkForNewMessages(String owner) {
		String lookUpCode = owner + "@mx";
		TieCtsStub tieCtsStub = new TieCtsStub();
		String[] newMessages = tieCtsStub.checkForNewMessage(lookUpCode);
		return newMessages;
	}

	// Receive one new message:Processing the new message stored in the given
	// file, decryt, parse xml to java objects, save to database, etc
	public TieMsgPackage receiveNewMessage(String msgFileName) {
		return null; 
	}
}
