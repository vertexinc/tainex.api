package com.tie.model;

public class TieMsgTest {
	public TieMsgTest(int tieMsgid, String subject, String notes, int ownerid, int tieMsgStateid, String warning) {
		super();
		this.tieMsgid = tieMsgid;
		this.subject = subject;
		this.notes = notes;
		this.ownerid = ownerid;
		this.tieMsgStateid = tieMsgStateid;
		this.warning = warning;
	}

	private int tieMsgid;
	private String subject;
	private String code;
	private String notes;
	private int ownerid;
	private int tieMsgStateid;
	private String sendingEntityIdNum;
	private String transmittingCountry;
	private String receivingCountries;
	private String mesageType;
	private String language;
	private String warning;
	private String contact;
	private String messageRefId;
	private String messageTypeIndic;
	private String corrMessageRefids;
	private String reportingPeriod;
	private String timestamp;
	private String description;
	private String rawMsg;
	

	public int getTieMsgid() {
		return tieMsgid;

	}

	public void setTieMsgid(int tieMsgid) {
		this.tieMsgid = tieMsgid;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public int getTieMsgStateid() {
		return tieMsgStateid;
	}

	public void setTieMsgStateid(int tieMsgStateid) {
		this.tieMsgStateid = tieMsgStateid;
	}

	public String getSendingEntityIdNum() {
		return sendingEntityIdNum;
	}

	public void setSendingEntityIdNum(String sendingEntityIdNum) {
		this.sendingEntityIdNum = sendingEntityIdNum;
	}

	public String getTransmittingCountry() {
		return transmittingCountry;
	}

	public void setTransmittingCountry(String transmittingCountry) {
		this.transmittingCountry = transmittingCountry;
	}

	public String getReceivingCountries() {
		return receivingCountries;
	}

	public void setReceivingCountries(String receivingCountries) {
		this.receivingCountries = receivingCountries;
	}

	public String getMesageType() {
		return mesageType;
	}

	public void setMesageType(String mesageType) {
		this.mesageType = mesageType;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getWarning() {
		return warning;
	}

	public void setWarning(String warning) {
		this.warning = warning;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getMessageRefId() {
		return messageRefId;
	}

	public void setMessageRefId(String messageRefId) {
		this.messageRefId = messageRefId;
	}

	public String getMessageTypeIndic() {
		return messageTypeIndic;
	}

	public void setMessageTypeIndic(String messageTypeIndic) {
		this.messageTypeIndic = messageTypeIndic;
	}

	public String getCorrMessageRefids() {
		return corrMessageRefids;
	}

	public void setCorrMessageRefids(String corrMessageRefids) {
		this.corrMessageRefids = corrMessageRefids;
	}

	public String getReportingPeriod() {
		return reportingPeriod;
	}

	public void setReportingPeriod(String reportingPeriod) {
		this.reportingPeriod = reportingPeriod;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRawMsg() {
		return rawMsg;
	}

	public void setRawMsg(String rawMsg) {
		this.rawMsg = rawMsg;
	}

}
