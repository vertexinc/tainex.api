package com.tie.model;

public class TieDocType implements java.io.Serializable{
	private int tieDocTypeId;
	private String name;
	private String code;
	private String description;

	public TieDocType() {
		// super();
	}

	public TieDocType(int tieDocTypeId, String name, String code, String description) {
		super();
		this.tieDocTypeId = tieDocTypeId;
		this.name = name;
		this.code = code;
		this.description = description;
	}

	public int getTieDocTypeId() {
		return tieDocTypeId;
	}

	public void setTieDocTypeId(int tieDocTypeId) {
		this.tieDocTypeId = tieDocTypeId;
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
	
	public String findDocTypeById(int id){
		String OECDDocType = null;
		switch(id){
		case 0: OECDDocType = "OECD0";
				break;
		case 1: OECDDocType = "OECD1";
		break;
		case 2: OECDDocType = "OECD2";
		break;
		case 3: OECDDocType = "OECD3";
		break;
		case 10: OECDDocType = "OECD10";
		break;
		case 11: OECDDocType = "OECD11";
		break;
		case 12: OECDDocType = "OECD12";
		break;
		case 13: OECDDocType = "OECD13";
		break;
		default: OECDDocType = "OECD0";
        break;
		}
		return OECDDocType;
	}

	@Override
	public String toString() {
		return "TieDocType [tieDocTypeId=" + tieDocTypeId + ", name=" + name + ", code=" + code + ", description="
				+ description + "]";
	}

}
