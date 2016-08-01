package com.tie.model;

public class TieApp {
	private int tieAppId;
	private String name;
	private String code;
	private String description;
	private String ctsId;
	private String ctsPwd;
	private String taxAuthorityCode;
	private String countryCode;
	private int isRunning;

	public TieApp() {
		// super();
	}

	
	public TieApp(int tieAppId, String name, String code, String description, String ctsId, String ctsPwd,
			String taxAuthorityCode, String countryCode, int isRunning) {
		super();
		this.tieAppId = tieAppId;
		this.name = name;
		this.code = code;
		this.description = description;
		this.ctsId = ctsId;
		this.ctsPwd = ctsPwd;
		this.taxAuthorityCode = taxAuthorityCode;
		this.countryCode = countryCode;
		this.isRunning = isRunning;
	}
	/*
	public TieApp(String name,String description){
		this.name = name;
		this.description = description;
	}*/
	public int getTieAppId() {
		return tieAppId;
	}

	public void setTieAppId(int tieAppId) {
		this.tieAppId = tieAppId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getCtsId() {
		return ctsId;
	}

	public void setCtsId(String ctsId) {
		this.ctsId = ctsId;
	}

	public String getCtsPwd() {
		return ctsPwd;
	}

	public void setCtsPwd(String ctsPwd) {
		this.ctsPwd = ctsPwd;
	}

	public String getTaxAuthorityCode() {
		return taxAuthorityCode;
	}

	public void setTaxAuthorityCode(String taxAuthorityCode) {
		this.taxAuthorityCode = taxAuthorityCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public int getIsRunning() {
		return isRunning;
	}

	public void setIsRunning(int isRunning) {
		this.isRunning = isRunning;
	}

	@Override
	public String toString() {
		return "TieApp [tieAppId=" + tieAppId + ", name=" + name + ", code=" + code + ", description=" + description
				+ ", ctsId=" + ctsId + ", ctsPwd=" + ctsPwd + ", taxAuthorityCode=" + taxAuthorityCode
				+ ", countryCode=" + countryCode + ", isRunning=" + isRunning + "]";
	}

}
