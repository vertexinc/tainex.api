package com.tie.ui;

public class Param {
	private String action;
	private int messageId;
	private int docId;
	
	public Param(String action, int messageId, int docId) {
		super();
		this.action = action;
		this.messageId = messageId;
		this.docId = docId;
	}

	public Param(String action) {
		// super();
		this.action = action;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public Param() {
		// super();
		// TODO Auto-generated constructor stub
	}


	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@Override
	public String toString() {
		return "Param [action=" + action + ", messageId=" + messageId + ", docId=" + docId + "]";
	}
}
