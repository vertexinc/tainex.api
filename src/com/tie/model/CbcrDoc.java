package com.tie.model;

public class CbcrDoc extends TieDoc {
	CbcrTable1 cbcrTable1 = null;
	CbcrTable2 cbcrTable2 = null;
	CbcrTable3 cbcrTable3 = null;
	TieDoc tieDocRecord = null;
	public CbcrDoc() {
	
	}

	public CbcrDoc(TieDoc tieDocRecord) {
		this.tieDocRecord = tieDocRecord;
	}
	
}
