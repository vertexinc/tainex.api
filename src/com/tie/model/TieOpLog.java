package com.tie.model;

public class TieOpLog {
	private int timeStamp;
	private int timeYear;
	private int timeMonth;
	private int timeDay;
	private int timeHour;
	private int timeMinute;
	private int timeSecond;
	private int userId;
	private String userCode;
	private String userName;
	private String userCtsId;
	private int actionTypeId;
	private String actionName;
	private String actionCode;
	private String actionNotes;
	private int msgId;
	private String msgSubject;
	private String msgCode;
	private int docId;
	private String docName;
	private String docCode;
	private String fieldNames;
	private String fieldsBefore;
	private String fieldsAfter;

	public TieOpLog() {
		// super();
	}

	public TieOpLog(int timeStamp, int timeYear, int timeMonth, int timeDay, int timeHour, int timeMinute,
			int timeSecond, int userId, String userCode, String userName, String userCtsId, int actionTypeId,
			String actionName, String actionCode, String actionNotes, int msgId, String msgSubject, String msgCode,
			int docId, String docName, String docCode, String fieldNames, String fieldsBefore, String fieldsAfter) {
		super();
		this.timeStamp = timeStamp;
		this.timeYear = timeYear;
		this.timeMonth = timeMonth;
		this.timeDay = timeDay;
		this.timeHour = timeHour;
		this.timeMinute = timeMinute;
		this.timeSecond = timeSecond;
		this.userId = userId;
		this.userCode = userCode;
		this.userName = userName;
		this.userCtsId = userCtsId;
		this.actionTypeId = actionTypeId;
		this.actionName = actionName;
		this.actionCode = actionCode;
		this.actionNotes = actionNotes;
		this.msgId = msgId;
		this.msgSubject = msgSubject;
		this.msgCode = msgCode;
		this.docId = docId;
		this.docName = docName;
		this.docCode = docCode;
		this.fieldNames = fieldNames;
		this.fieldsBefore = fieldsBefore;
		this.fieldsAfter = fieldsAfter;
	}

	public int getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(int timeStamp) {
		this.timeStamp = timeStamp;
	}

	public int getTimeYear() {
		return timeYear;
	}

	public void setTimeYear(int timeYear) {
		this.timeYear = timeYear;
	}

	public int getTimeMonth() {
		return timeMonth;
	}

	public void setTimeMonth(int timeMonth) {
		this.timeMonth = timeMonth;
	}

	public int getTimeDay() {
		return timeDay;
	}

	public void setTimeDay(int timeDay) {
		this.timeDay = timeDay;
	}

	public int getTimeHour() {
		return timeHour;
	}

	public void setTimeHour(int timeHour) {
		this.timeHour = timeHour;
	}

	public int getTimeMinute() {
		return timeMinute;
	}

	public void setTimeMinute(int timeMinute) {
		this.timeMinute = timeMinute;
	}

	public int getTimeSecond() {
		return timeSecond;
	}

	public void setTimeSecond(int timeSecond) {
		this.timeSecond = timeSecond;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserCtsId() {
		return userCtsId;
	}

	public void setUserCtsId(String userCtsId) {
		this.userCtsId = userCtsId;
	}

	public int getActionTypeId() {
		return actionTypeId;
	}

	public void setActionTypeId(int actionTypeId) {
		this.actionTypeId = actionTypeId;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getActionCode() {
		return actionCode;
	}

	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}

	public String getActionNotes() {
		return actionNotes;
	}

	public void setActionNotes(String actionNotes) {
		this.actionNotes = actionNotes;
	}

	public int getMsgId() {
		return msgId;
	}

	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}

	public String getMsgSubject() {
		return msgSubject;
	}

	public void setMsgSubject(String msgSubject) {
		this.msgSubject = msgSubject;
	}

	public String getMsgCode() {
		return msgCode;
	}

	public void setMsgCode(String msgCode) {
		this.msgCode = msgCode;
	}

	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getDocCode() {
		return docCode;
	}

	public void setDocCode(String docCode) {
		this.docCode = docCode;
	}

	public String getFieldNames() {
		return fieldNames;
	}

	public void setFieldNames(String fieldNames) {
		this.fieldNames = fieldNames;
	}

	public String getFieldsBefore() {
		return fieldsBefore;
	}

	public void setFieldsBefore(String fieldsBefore) {
		this.fieldsBefore = fieldsBefore;
	}

	public String getFieldsAfter() {
		return fieldsAfter;
	}

	public void setFieldsAfter(String fieldsAfter) {
		this.fieldsAfter = fieldsAfter;
	}

	@Override
	public String toString() {
		return "TieOpLog [timeStamp=" + timeStamp + ", timeYear=" + timeYear + ", timeMonth=" + timeMonth + ", timeDay="
				+ timeDay + ", timeHour=" + timeHour + ", timeMinute=" + timeMinute + ", timeSecond=" + timeSecond
				+ ", userId=" + userId + ", userCode=" + userCode + ", userName=" + userName + ", userCtsId="
				+ userCtsId + ", actionTypeId=" + actionTypeId + ", actionName=" + actionName + ", actionCode="
				+ actionCode + ", actionNotes=" + actionNotes + ", msgId=" + msgId + ", msgSubject=" + msgSubject
				+ ", msgCode=" + msgCode + ", docId=" + docId + ", docName=" + docName + ", docCode=" + docCode
				+ ", fieldNames=" + fieldNames + ", fieldsBefore=" + fieldsBefore + ", fieldsAfter=" + fieldsAfter
				+ "]";
	}

}
