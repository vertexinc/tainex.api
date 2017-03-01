package com.tie.ui;

import com.tie.model.TieMsg;

public class Param {
	private String action;
	private int messageId;
	private int docId;
	private TieMsg tieMsg;
	private String docString;
	private String docIdListString;
	private String fileName;

	public Param(String action, int messageId, int docId, TieMsg tieMsg, String docString, String docIdListString,
			String fileName) {
		super();
		this.action = action;
		this.messageId = messageId;
		this.docId = docId;
		this.tieMsg = tieMsg;
		this.docString = docString;
		this.docIdListString = docIdListString;
		this.fileName = fileName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getDocIdListString() {
		return docIdListString;
	}

	public void setDocIdListString(String docIdListString) {
		this.docIdListString = docIdListString;
	}

	public String getDocString() {
		return docString;
	}

	public void setDocString(String docString) {
		this.docString = docString;
	}

	public TieMsg getTieMsg() {
		return tieMsg;
	}

	public void setTieMsg(TieMsg tieMsg) {
		this.tieMsg = tieMsg;
	}

	public Param(String action) {
		// super();
		this.action = action;
	}

	public Param() {
		// super();
		// TODO Auto-generated constructor stub
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

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@Override
	public String toString() {
		return "Param [action=" + action + ", messageId=" + messageId + ", docId=" + docId + ", tieMsg=" + tieMsg
				+ ", docString=" + docString + ", docIdListString=" + docIdListString + "]";
	}
}
