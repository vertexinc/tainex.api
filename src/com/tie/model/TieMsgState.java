package com.tie.model;

public class TieMsgState {
	private int tieMsgStateId;
	private String name;
	private String code;
	private String description;
	private String countryCodeA2;

	public TieMsgState() {
		//super();
	}

	public TieMsgState(int tieMsgStateId, String name, String code, String description, String countryCodeA2) {
		super();
		this.tieMsgStateId = tieMsgStateId;
		this.name = name;
		this.code = code;
		this.description = description;
		this.countryCodeA2 = countryCodeA2;
	}

	public int getTieMsgStateId() {
		return tieMsgStateId;
	}

	public void setTieMsgStateId(int tieMsgStateId) {
		this.tieMsgStateId = tieMsgStateId;
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

	public String getCountryCodeA2() {
		return countryCodeA2;
	}

	public void setCountryCodeA2(String countryCodeA2) {
		this.countryCodeA2 = countryCodeA2;
	}

	@Override
	public String toString() {
		return "TieMsgState [tieMsgStateId=" + tieMsgStateId + ", name=" + name + ", code=" + code + ", description="
				+ description + ", countryCodeA2=" + countryCodeA2 + "]";
	}

}
