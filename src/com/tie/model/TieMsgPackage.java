package com.tie.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tie.app.TaxDocParser;

public class TieMsgPackage {
	TieMsg tiemsg;// A backpointer towards the tiemsg class
	byte[] packageBytes;// The whole package to be sent.i.e.,TieMsgEnvelope
	String payload;// The message body for the receipient
	byte[] payloadEncrypted;
	String singleRecipient;
	public String getSingleRecipient() {
		return singleRecipient;
	}

	public void setSingleRecipient(String singleRecipient) {
		this.singleRecipient = singleRecipient;
	}

	final Logger logger = LoggerFactory.getLogger(TaxDocParser.class);

	public TieMsgPackage() {

	}

	public TieMsgPackage(TieMsg tiemsg) {
		this.tiemsg = tiemsg;
		logger.debug("Message in the package {}.", tiemsg.toString());
	}

	public TieMsg getTiemsg() {
		return tiemsg;
	}

	public void setTiemsg(TieMsg tiemsg) {
		this.tiemsg = tiemsg;
	}

	public byte[] getPackageBytes() {
		return packageBytes;
	}

	public void setPackageBytes(byte[] packageBytes) {
		this.packageBytes = packageBytes;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	public byte[] getPayloadEncrypted() {
		return payloadEncrypted;
	}

	public void setPayloadEncrypted(byte[] payloadEncrypted) {
		this.payloadEncrypted = payloadEncrypted;
	}

	public Logger getLogger() {
		return logger;
	}

}// end class TieMsgPackage
