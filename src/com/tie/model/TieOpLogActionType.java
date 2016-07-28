package com.tie.model;

public class TieOpLogActionType {
	private int tieOpLogActionTypeId;
	private String name;
	private String code;
	private String description;

	public TieOpLogActionType() {
		// super();
	}

	public TieOpLogActionType(int tieOpLogActionTypeId, String name, String code, String description) {
		super();
		this.tieOpLogActionTypeId = tieOpLogActionTypeId;
		this.name = name;
		this.code = code;
		this.description = description;
	}

	public int getTieOpLogActionTypeId() {
		return tieOpLogActionTypeId;
	}

	public void setTieOpLogActionTypeId(int tieOpLogActionTypeId) {
		this.tieOpLogActionTypeId = tieOpLogActionTypeId;
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
		return "TieOpLogActionType [tieOpLogActionTypeId=" + tieOpLogActionTypeId + ", name=" + name + ", code=" + code
				+ ", description=" + description + "]";
	}

}
