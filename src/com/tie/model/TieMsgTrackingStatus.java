package com.tie.model;

public class TieMsgTrackingStatus {
	private int tieMsgTrackingStatusId;
	private String name;
	private String code;
	private String description;

	public TieMsgTrackingStatus() {
		// super();
	}

	public TieMsgTrackingStatus(int tieMsgTrackingStatusId, String name, String code, String description) {
		super();
		this.tieMsgTrackingStatusId = tieMsgTrackingStatusId;
		this.name = name;
		this.code = code;
		this.description = description;
	}

	public int getTieMsgTrackingStatusId() {
		return tieMsgTrackingStatusId;
	}

	public void setTieMsgTrackingStatusId(int tieMsgTrackingStatusId) {
		this.tieMsgTrackingStatusId = tieMsgTrackingStatusId;
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
		return "TieMsgTrackingStateus [tieMsgTrackingStatusId=" + tieMsgTrackingStatusId + ", name=" + name + ", code="
				+ code + ", description=" + description + "]";
	}

}
