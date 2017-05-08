package com.tie.app;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.xml.bind.JAXBException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tie.dao.TiePersister;
import com.tie.model.TieMsg;
import com.tie.model.TieMsgPackage;
import com.tie.ui.TieMainPage;
import com.tie.xmlprocessor.cbcrxmlprocessor.CbcrXmlProcessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UcControllerSendTieMsg extends TieControllerBase {
	final Logger logger = LoggerFactory.getLogger(TaxDocParser.class);
	TieSessionController sessionController;
	private Map<Long, TieMsgPackage> msgPackages;
	String xmlString;

	public UcControllerSendTieMsg() {

	}

	public UcControllerSendTieMsg(TieSessionController sessionController) {
		this.sessionController = sessionController;
	}

	public void sendTieMsg(long msgId) throws JAXBException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, IOException {
		List<TieMsgPackage>packageList = prepareTieMsg(msgId);
		TieMsg tiemsg = buildTieMsg(msgId);
		packageList.get(0).setTiemsg(tiemsg);
		//TODO:get each package
		encryptMsgBody(xmlString,packageList.get(0));
	}// sendTieMsg(.)

	// prepare one package for each intended recipient.
	public List<TieMsgPackage> prepareTieMsg(long msgId) {
		logger.debug("Message to be sent with ID {}.", msgId);
		// loop through the recipient list to create the package list
		//TODO: recipient list unknown for now
		List<TieMsgPackage> packageList = new ArrayList<TieMsgPackage>();
		TieMsgPackage tieMsgPackage = new TieMsgPackage();
		packageList.add(tieMsgPackage);

		return packageList;
	}// prepareTieMsg(.)

	/*
	 * TODO Delegate to the main persister, to read all records, by invoking
	 * individual table persisters and assemble all the resulting objects
	 * together.
	 */
	public TieMsg buildTieMsg(long msgId) throws JsonProcessingException, JAXBException {
		// TieMsg currMsg = TieMainPage.getTieMainPage().getCurrentMsg();
		TiePersister persister = TieController.getController().getPersister();
		TieMsg tieMsg = persister.buildTieMsg(msgId);

		// XML processor
		CbcrXmlProcessor cbcrXmlProcessor = new CbcrXmlProcessor();
		xmlString = cbcrXmlProcessor.composeXmlString(tieMsg);
		logger.info("Message built successfully: {}", xmlString);
		cbcrXmlProcessor.validateXML(tieMsg);
		
		//TODO 
		
		return tieMsg;
	}// end buildTieMsg(.)

	/*
	 * Encrypt and set the encrypted byte[] into the given package The
	 * encryption will delegate to TieSecurityManager class, which will further
	 * use ICts for key management functionality
	 */
	public void encryptMsgBody(String msgBody, TieMsgPackage tieMsgPkg) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, IOException {
		TieSecurityManager tieSecurityManager = new TieSecurityManager();
		tieSecurityManager.encryptMsgBody(msgBody, tieMsgPkg);
	}// ebd encryptMsgBody(..)

	public Byte[] packageMsg(TieMsgPackage tieMsgPkg) {
		return null;
	}// end packageMsg(.)

	public String sendTaxMsgPackage(TieMsgPackage tieMsgPkg) {
		return null;
	}// end sendTaxMsgPackage(.)

	public boolean recordTaxMsgStatus() {
		return false;
	}// end recordTaxMsgStatus()

	/*
	 * check the type of msg, it is CBCR (the initial target), delegate to the
	 * method specific for composing CBCR msg.
	 */
	public String composeTieMsg(TieMsg tieMsg) {
		return null;

	}// end composeTieMsg(.)

	public String composeCbcrMsg(TieMsg tieMsg) {
		return null;
	}// end composeCbcrMsg(.)

}
