package com.tie.model;

public class TieMsg {
	private int msgid;
	private String code;
	private String description;
	private String notes;
	private int ownerid;

	public TieMsg(String code, String description, String notes, int ownerid) {
		super();
		this.code = code;
		this.description = description;
		this.notes = notes;
		this.ownerid = ownerid;
	}

	public TieMsg() {

	}

	public int getMsgid() {
		return msgid;
	}

	public void setMsgid(int msgid) {
		this.msgid = msgid;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getOwnerid() {
		return ownerid;
	}

	public void setOwnerid(int ownerid) {
		this.ownerid = ownerid;
	}

	@Override
	public String toString() {
		return "TieMsg [code=" + code + ", description=" + description + ", notes=" + notes + ", ownerid=" + ownerid
				+ "]";
	}
}
