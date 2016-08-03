package com.tie.ui;

public class SelectionCriteria {
	// all 20 attributes
	private String fromUser;
	private String fromCountry;
	private String toUser;
	private String toCountry;
	private String fromDate;
	private String toDate;
	private String name;
	private String country;
	private String fromYear;
	private String toYear;
	private String mainBusiness;

	public String getFromCountry() {
		return fromCountry;
	}

	public void setFromCountry(String fromCountry) {
		this.fromCountry = fromCountry;
	}

	public String getToUser() {
		return toUser;
	}

	public void setToUser(String toUser) {
		this.toUser = toUser;
	}

	public String getToCountry() {
		return toCountry;
	}

	public void setToCountry(String toCountry) {
		this.toCountry = toCountry;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFromYear() {
		return fromYear;
	}

	public void setFromYear(String fromYear) {
		this.fromYear = fromYear;
	}

	public String getToYear() {
		return toYear;
	}

	public void setToYear(String toYear) {
		this.toYear = toYear;
	}

	public String getMainBusiness() {
		return mainBusiness;
	}

	public void setMainBusiness(String mainBusiness) {
		this.mainBusiness = mainBusiness;
	}

	public String getFromUser() {
		return fromUser;
	}

	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}

	public SelectionCriteria() {
		init();
	}

	// All the selection criteria be set here
	// set default velues to every sinle attribute
	public void init() {
		setFromUser("Adam");
		setFromCountry("US");
		setToUser("John");
		setToCountry("MX");
		setFromDate("2012-01-01");
		setToDate("2016-01-01");
		setName("MNC Name");
		setCountry("US");
		setFromYear("2012");
		setToYear("2016");
		setMainBusiness("Finance");
		
	}
}
