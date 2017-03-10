package com.tie.app;

import java.util.List;
import java.util.Map;

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

	public void sendTieMsg(long msgId) {
		prepareTieMsg(msgId);
	}//sendTieMsg(.)

	// prepare one package for each intended recipient.
	public List<TieMsgPackage> prepareTieMsg(long msgId) {
		logger.debug("Message to be sent with ID {}.", msgId);
		return null;
	}//prepareTieMsg(.)

	/*TODO Delegate to the main persister, to read all records,
	 * by invoking individual table persisters and assemble all the
	 * resulting objects together.
	 * */
	public TieMsg buildTieMsg(long msgId) {
		TieMsg currMsg = TieMainPage.getTieMainPage().getCurrentMsg();
		return currMsg;
	}//end buildTieMsg(.)

	Byte[] packageMsg(TieMsgPackage tieMsgPkg) {
		return null;
	}//end packageMsg(.)

	public String sendTaxMsgPackage(TieMsgPackage tieMsgPkg) {
		return null;
	}//end sendTaxMsgPackage(.)
	
	public boolean recordTaxMsgStatus(){
		return false;
	}//end recordTaxMsgStatus()

}
