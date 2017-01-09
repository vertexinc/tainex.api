package com.tie.ui;

public class TieMsg {
	private String subject;
	

	public TieMsg() {
		super();
	}

	public TieMsg(String subject) {
		super();
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "TieMsg [subject=" + subject + "]";
	}

}
