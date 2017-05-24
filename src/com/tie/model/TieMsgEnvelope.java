package com.tie.model;

import java.util.Date;

public class TieMsgEnvelope implements java.io.Serializable{
	TieUser sender;
	TieUser receiver;
	Date sendTime;

	public TieMsgEnvelope() {
		super();
	}

	public TieMsgEnvelope(TieUser sender, TieUser receiver, Date sendTime) {
		super();
		this.sender = sender;
		this.receiver = receiver;
		this.sendTime = sendTime;
	}

	public TieUser getSender() {
		return sender;
	}

	public void setSender(TieUser sender) {
		this.sender = sender;
	}

	public TieUser getReceiver() {
		return receiver;
	}

	public void setReceiver(TieUser receiver) {
		this.receiver = receiver;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	@Override
	public String toString() {
		return "TieMsgEnvelope [sender=" + sender + ", receiver=" + receiver + ", sendTime=" + sendTime + "]";
	}

}
