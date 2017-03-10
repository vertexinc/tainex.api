package com.tie.model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tie.app.TaxDocParser;

public class TieMsgPackage {
	TieMsg tiemsg;//A backpointer towards the tiemsg class
	byte[] packageBytes;//The whole package to be sent
	String payload;//The message body for the receipient
	byte[] payloadEncrypted;
	final Logger logger = LoggerFactory.getLogger(TaxDocParser.class);
	public TieMsgPackage() {
		
	}

	public TieMsgPackage(TieMsg tiemsg) {
		this.tiemsg = tiemsg;
		logger.debug("Message in the package {}.", tiemsg.toString());
	}
	
}//end class TieMsgPackage
