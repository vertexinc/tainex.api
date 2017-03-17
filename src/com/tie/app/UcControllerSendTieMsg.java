package com.tie.app;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tie.dao.TiePersister;
import com.tie.model.TieMsg;
import com.tie.model.TieMsgPackage;
import com.tie.ui.TieMainPage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UcControllerSendTieMsg extends TieControllerBase {
	final Logger logger = LoggerFactory.getLogger(TaxDocParser.class);
	TieSessionController sessionController;
	private Map<Long, TieMsgPackage> msgPackages;

	public UcControllerSendTieMsg() {

	}

	public UcControllerSendTieMsg(TieSessionController sessionController) {
		this.sessionController = sessionController;
	}

	public void sendTieMsg(long msgId) throws JsonProcessingException {
		prepareTieMsg(msgId);
		buildTieMsg(msgId);
	}// sendTieMsg(.)

	// prepare one package for each intended recipient.
	public List<TieMsgPackage> prepareTieMsg(long msgId) {
		logger.debug("Message to be sent with ID {}.", msgId);
		// loop through the recipient list to create the package list

		return null;
	}// prepareTieMsg(.)

	/*
	 * TODO Delegate to the main persister, to read all records, by invoking
	 * individual table persisters and assemble all the resulting objects
	 * together.
	 */
	public TieMsg buildTieMsg(long msgId) throws JsonProcessingException {
		//TieMsg currMsg = TieMainPage.getTieMainPage().getCurrentMsg();
		TiePersister persister = TieController.getController().getPersister();
		persister.buildTieMsg(msgId);
		return null;
	}// end buildTieMsg(.)

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
