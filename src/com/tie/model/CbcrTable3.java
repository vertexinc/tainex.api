package com.tie.model;

public class CbcrTable3 {
	private int tieDocId;
	private String countryCode;
	private String summaryRef;
	private String mneGroupName;
	private String fiscalYearConcerned;
	private String additionalInfo;
	public CbcrTable3() {
		//super();
	}
	public CbcrTable3(int tieDocId, String countryCode, String summaryRef, String mneGroupName,
			String fiscalYearConcerned, String additionalInfo) {
		super();
		this.tieDocId = tieDocId;
		this.countryCode = countryCode;
		this.summaryRef = summaryRef;
		this.mneGroupName = mneGroupName;
		this.fiscalYearConcerned = fiscalYearConcerned;
		this.additionalInfo = additionalInfo;
	}
	public int getTieDocId() {
		return tieDocId;
	}
	public void setTieDocId(int tieDocId) {
		this.tieDocId = tieDocId;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getSummaryRef() {
		return summaryRef;
	}
	public void setSummaryRef(String summaryRef) {
		this.summaryRef = summaryRef;
	}
	public String getMneGroupName() {
		return mneGroupName;
	}
	public void setMneGroupName(String mneGroupName) {
		this.mneGroupName = mneGroupName;
	}
	public String getFiscalYearConcerned() {
		return fiscalYearConcerned;
	}
	public void setFiscalYearConcerned(String fiscalYearConcerned) {
		this.fiscalYearConcerned = fiscalYearConcerned;
	}
	public String getAdditionalInfo() {
		return additionalInfo;
	}
	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	@Override
	public String toString() {
		return "CbcrTable3 [tieDocId=" + tieDocId + ", countryCode=" + countryCode + ", summaryRef=" + summaryRef
				+ ", mneGroupName=" + mneGroupName + ", fiscalYearConcerned=" + fiscalYearConcerned
				+ ", additionalInfo=" + additionalInfo + "]";
	}
	
}
