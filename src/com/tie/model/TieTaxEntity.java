package com.tie.model;

public class TieTaxEntity {
	private int tieDocId;
	private String entityCode;
	private String name;
	private String description;
	private String taxIdNum;
	private String incorpCountryCode;
	private String otherEntityInfo;
	private String idNum;
	private String resCountryCode;
	private int isPermExtabliment;
	private String addrLegalType;
	private String addrCountryCode;
	private String addrFreeText;
	private String addrStreet;
	private String addrBuildingIdentifier;
	private String addrSuiteIdentifier;
	private String addrFloorIdentifier;
	private String addrPOB;

	public TieTaxEntity() {
		// super();
	}

	public TieTaxEntity(int tieDocId, String entityCode, String name, String description, String taxIdNum,
			String incorpCountryCode, String otherEntityInfo, String resCountryCode, String idNum,
			int isPermExtabliment, String addrLegalType, String addrCountryCode, String addrFreeText, String addrStreet,
			String addrBuildingIdentifier, String addrSuiteIdentifier, String addrFloorIdentifier, String addrPOB) {
		super();
		this.tieDocId = tieDocId;
		this.entityCode = entityCode;
		this.name = name;
		this.description = description;
		this.taxIdNum = taxIdNum;
		this.incorpCountryCode = incorpCountryCode;
		this.otherEntityInfo = otherEntityInfo;
		this.idNum = idNum;
		this.resCountryCode = resCountryCode;
		this.isPermExtabliment = isPermExtabliment;
		this.addrLegalType = addrLegalType;
		this.addrCountryCode = addrCountryCode;
		this.addrFreeText = addrFreeText;
		this.addrStreet = addrStreet;
		this.addrBuildingIdentifier = addrBuildingIdentifier;
	}

	public int getTieDocId() {
		return tieDocId;
	}

	public void setTieDocId(int tieDocId) {
		this.tieDocId = tieDocId;
	}

	public String getEntityCode() {
		return entityCode;
	}

	public void setEntityCode(String entityCode) {
		this.entityCode = entityCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTaxIdNum() {
		return taxIdNum;
	}

	public void setTaxIdNum(String taxIdNum) {
		this.taxIdNum = taxIdNum;
	}

	public String getIncorpCountryCode() {
		return incorpCountryCode;
	}

	public void setIncorpCountryCode(String incorpCountryCode) {
		this.incorpCountryCode = incorpCountryCode;
	}

	public String getOtherEntityInfo() {
		return otherEntityInfo;
	}

	public void setOtherEntityInfo(String otherEntityInfo) {
		this.otherEntityInfo = otherEntityInfo;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	public String getResCountryCode() {
		return resCountryCode;
	}

	public void setResCountryCode(String resCountryCode) {
		this.resCountryCode = resCountryCode;
	}

	public int getIsPermExtabliment() {
		return isPermExtabliment;
	}

	public void setIsPermExtabliment(int isPermExtabliment) {
		this.isPermExtabliment = isPermExtabliment;
	}

	public String getAddrLegalType() {
		return addrLegalType;
	}

	public void setAddrLegalType(String addrLegalType) {
		this.addrLegalType = addrLegalType;
	}

	public String getAddrCountryCode() {
		return addrCountryCode;
	}

	public void setAddrCountryCode(String addrCountryCode) {
		this.addrCountryCode = addrCountryCode;
	}

	public String getAddrFreeText() {
		return addrFreeText;
	}

	public void setAddrFreeText(String addrFreeText) {
		this.addrFreeText = addrFreeText;
	}

	public String getAddrStreet() {
		return addrStreet;
	}

	public void setAddrStreet(String addrStreet) {
		this.addrStreet = addrStreet;
	}

	public String getAddrBuildingIdentifier() {
		return addrBuildingIdentifier;
	}

	public void setAddrBuildingIdentifier(String addrBuildingIdentifier) {
		this.addrBuildingIdentifier = addrBuildingIdentifier;
	}

	public String getAddrSuiteIdentifier() {
		return addrSuiteIdentifier;
	}

	public void setAddrSuiteIdentifier(String addrSuiteIdentifier) {
		this.addrSuiteIdentifier = addrSuiteIdentifier;
	}

	public String getAddrFloorIdentifier() {
		return addrFloorIdentifier;
	}

	public void setAddrFloorIdentifier(String addrFloorIdentifier) {
		this.addrFloorIdentifier = addrFloorIdentifier;
	}

	public String getAddrPOB() {
		return addrPOB;
	}

	public void setAddrPOB(String addrPOB) {
		this.addrPOB = addrPOB;
	}

	@Override
	public String toString() {
		return "taxEntity [tieDocId=" + tieDocId + ", entityCode=" + entityCode + ", name=" + name + ", description="
				+ description + ", taxIdNum=" + taxIdNum + ", incorpCountryCode=" + incorpCountryCode
				+ ", otherEntityInfo=" + otherEntityInfo + ", idNum=" + idNum + ", resCountryCode=" + resCountryCode
				+ ", isPermExtabliment=" + isPermExtabliment + ", addrLegalType=" + addrLegalType + ", addrCountryCode="
				+ addrCountryCode + ", addrFreeText=" + addrFreeText + ", addrStreet=" + addrStreet
				+ ", addrBuildingIdentifier=" + addrBuildingIdentifier + "]";
	}

}
