package com.tie.model;

public class TieDocType {
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

	@Override
	public String toString() {
		return "TieDocType [tieDocTypeId=" + tieDocTypeId + ", name=" + name + ", code=" + code + ", description="
				+ description + "]";
	}

}
