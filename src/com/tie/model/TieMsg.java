package com.tie.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TieMsg {
	private int tieMsgId;
	private String subject;
	private String code;
	private String description;
	private String notes;
	private int senderId;
	// TODO: new object here
	private TieUser sender;

	private int ownerid;
	private int tieMsgStateId;
	// TODO: an object for tieMsgStateId
	private TieMsgState tieMsgState;

	private String sendingEntityIdNum;
	private String transmittingCountry;
	private String receivingCountries;
	private String messageType;
	private String language;
	private String warning;
	private String contact;
	private String messageRefId;
	private String messageTypeIndic;
	private String corrMessageRefIds;

	private String reportingPeriod;
	private String timestamp;
	private String rawMsg;
	private String msgReceiverList;
	private List<TieMsgReceiver> TieMsgReceiverList;



	public List<TieMsgReceiver> getTieMsgReceiverList() {
		return TieMsgReceiverList;
	}

	public void setTieMsgReceiverList(List<TieMsgReceiver> tieMsgReceiverList) {
		TieMsgReceiverList = tieMsgReceiverList;
	}

	private String userName;

	private String msgState;
	private HashMap<Long, TieMsgPackage> msgPackages = new HashMap<Long, TieMsgPackage>();
	private int numOfDocs;

	public int getNumOfDocs() {
		int numOfDocs = 0;
		if (getTieDocList() != null) {
			numOfDocs = getTieDocList().size();
		}
		return numOfDocs;
	}

	// TODO tieDocList
	private List<TieDoc> tieDocList = new ArrayList<TieDoc>();

	// OECD Message Type indicator
	public static String[] messageTypeIndi = { "CBC401", "CBC402", "CBC403" };

	public List<TieDoc> getTieDocList() {
		return tieDocList;
	}

	public void setTieDocList(List<TieDoc> tieDocList) {
		this.tieDocList = tieDocList;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMsgState() {
		return msgState;
	}

	public void setMsgState(String msgState) {
		this.msgState = msgState;
	}

	public String getMsgReceiverList() {
		return msgReceiverList;
	}

	public static String[] getMessageTypeIndi() {
		return messageTypeIndi;
	}

	public static void setMessageTypeIndi(String[] messageTypeIndi) {
		TieMsg.messageTypeIndi = messageTypeIndi;
	}

	public void setMsgReceiverList(String msgReceiverList) {
		this.msgReceiverList = msgReceiverList;
	}

	public TieUser getSender() {
		return sender;
	}

	public void setSender(TieUser sender) {
		this.sender = sender;
	}

	public TieMsgState getTieMsgState() {
		return tieMsgState;
	}

	public void setTieMsgState(TieMsgState tieMsgState) {
		this.tieMsgState = tieMsgState;
	}

	// List of docs in the msg to be sent out

	public TieMsg() {

	}

	public TieMsg(int tieMsgId, String subject, String code, String description, String notes, int senderId,
			int ownerid, int tieMsgStateId, String sendingEntityIdNum, String transmittingCountry,
			String receivingCountries, String messageType, String language, String warning, String contact,
			String messageRefId, String messageTypeIndic, String corrMessageRefIds, String reportingPeriod,
			String timestamp, String rawMsg, String msgReceiverList) {

		this.tieMsgId = tieMsgId;
		this.subject = subject;
		this.code = code;
		this.description = description;
		this.notes = notes;
		this.senderId = senderId;
		this.ownerid = ownerid;
		this.tieMsgStateId = tieMsgStateId;
		this.sendingEntityIdNum = sendingEntityIdNum;
		this.transmittingCountry = transmittingCountry;
		this.receivingCountries = receivingCountries;
		this.messageType = messageType;
		this.language = language;
		this.warning = warning;
		this.contact = contact;
		this.messageRefId = messageRefId;
		this.messageTypeIndic = messageTypeIndic;
		this.corrMessageRefIds = corrMessageRefIds;
		this.reportingPeriod = reportingPeriod;
		this.timestamp = timestamp;
		this.rawMsg = rawMsg;
		this.msgReceiverList = msgReceiverList;
	}

	public int getTieMsgId() {
		return tieMsgId;
	}

	public void setTieMsgId(int tieMsgId) {
		this.tieMsgId = tieMsgId;

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

	public int getSenderId() {
		return senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public int getOwnerid() {
		return ownerid;
	}

	public void setOwnerid(int ownerid) {
		this.ownerid = ownerid;
	}

	public int getTieMsgStateId() {
		return tieMsgStateId;
	}

	public void setTieMsgStateId(int tieMsgStateId) {
		this.tieMsgStateId = tieMsgStateId;
		// TODO set the object of tieMsgState
		TieMsgState.findById(tieMsgStateId);
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

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
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

	public String getCorrMessageRefIds() {
		return corrMessageRefIds;
	}

	public void setCorrMessageRefIds(String corrMessageRefIds) {
		this.corrMessageRefIds = corrMessageRefIds;
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

	public String getRawMsg() {
		return rawMsg;
	}

	public void setRawMsg(String rawMsg) {
		this.rawMsg = rawMsg;
	}

	public HashMap<Long, TieMsgPackage> getMsgPackages() {
		return msgPackages;
	}

	public void setMsgPackages(HashMap<Long, TieMsgPackage> msgPackages) {
		this.msgPackages = msgPackages;
	}

	// The UcController uses this method to start a blank packages,
	// which are to be populated with details according CTS specific
	// requirements.
	public void initPackages() {
		//Hard coded recipient ID list 
		//Need to determin how to get recipient Id later
		
		List<Integer> recipientIdList = new ArrayList<Integer>();
		recipientIdList.add(1);
		recipientIdList.add(2);
		
		for (long key : recipientIdList) {			
			TieMsgPackage tieMsgPackage = new TieMsgPackage();
			tieMsgPackage.setPayload("empty payload");
			msgPackages.put(key, tieMsgPackage);
		}
	}

	@Override
	public String toString() {
		return "TieMsg [tieMsgId=" + tieMsgId + ", subject=" + subject + ", code=" + code + ", description="
				+ description + ", notes=" + notes + ", senderId=" + senderId + ", sender=" + sender + ", ownerid="
				+ ownerid + ", tieMsgStateId=" + tieMsgStateId + ", tieMsgState=" + tieMsgState
				+ ", sendingEntityIdNum=" + sendingEntityIdNum + ", transmittingCountry=" + transmittingCountry
				+ ", receivingCountries=" + receivingCountries + ", messageType=" + messageType + ", language="
				+ language + ", warning=" + warning + ", contact=" + contact + ", messageRefId=" + messageRefId
				+ ", messageTypeIndic=" + messageTypeIndic + ", corrMessageRefIds=" + corrMessageRefIds
				+ ", reportingPeriod=" + reportingPeriod + ", timestamp=" + timestamp + ", rawMsg=" + rawMsg
				+ ", msgReceiverList=" + msgReceiverList + ", userName=" + userName + ", msgState=" + msgState
				+ ", msgPackages=" + msgPackages + ", tieDocList=" + tieDocList + "]";
	}

}
