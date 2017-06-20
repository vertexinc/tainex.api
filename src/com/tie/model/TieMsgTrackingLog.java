package com.tie.model;

//Former TieMsgReceiver
public class TieMsgTrackingLog {
	private int tieMsgId;
	private String senderCode;
	private String receiverCode;
	private int tieMsgTrackingStatusId;
	private String trackingNote;
	private String receivingCountry;
	private String ctsTrackingId;
	private String timeStamp;

	public TieMsgTrackingLog() {
		// super();
	}



	
	public TieMsgTrackingLog(int tieMsgId, String senderCode, String receiverCode, int tieMsgTrackingStatusId,
			String trackingNote, String receivingCountry, String ctsTrackingId, String timeStamp) {
		super();
		this.tieMsgId = tieMsgId;
		this.senderCode = senderCode;
		this.receiverCode = receiverCode;
		this.tieMsgTrackingStatusId = tieMsgTrackingStatusId;
		this.trackingNote = trackingNote;
		this.receivingCountry = receivingCountry;
		this.ctsTrackingId = ctsTrackingId;
		this.timeStamp = timeStamp;
	}




	public String getTimeStamp() {
		return timeStamp;
	}




	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}




	public String getCtsTrackingId() {
		return ctsTrackingId;
	}

	public void setCtsTrackingId(String ctsTrackingId) {
		this.ctsTrackingId = ctsTrackingId;
	}

	public int getTieMsgId() {
		return tieMsgId;
	}

	public void setTieMsgId(int tieMsgId) {
		this.tieMsgId = tieMsgId;
	}

	public String getSenderCode() {
		return senderCode;
	}

	public void setSenderCode(String senderCode) {
		this.senderCode = senderCode;
	}

	public String getReceiverCode() {
		return receiverCode;
	}

	public void setReceiverCode(String receiverCode) {
		this.receiverCode = receiverCode;
	}

	public int getTieMsgTrackingStatusId() {
		return tieMsgTrackingStatusId;
	}

	public void setTieMsgTrackingStatusId(int tieMsgTrackingStatusId) {
		this.tieMsgTrackingStatusId = tieMsgTrackingStatusId;
	}

	public String getTrackingNote() {
		return trackingNote;
	}

	public void setTrackingNote(String trackingNote) {
		this.trackingNote = trackingNote;
	}

	public String getReceivingCountry() {
		return receivingCountry;
	}

	public void setReceivingCountry(String receivingCountry) {
		this.receivingCountry = receivingCountry;
	}

	@Override
	public String toString() {
		return "TieMsgReceiver [tieMsgId=" + tieMsgId + ", senderCode=" + senderCode + ", receiverCode=" + receiverCode
				+ ", tieMsgTrackingStatusId=" + tieMsgTrackingStatusId + ", trackingNote=" + trackingNote
				+ ", receivingCountry=" + receivingCountry + "]";
	}

}
