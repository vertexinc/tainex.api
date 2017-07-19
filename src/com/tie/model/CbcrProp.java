package com.tie.model;

public class CbcrProp implements java.io.Serializable{
	private int tieDocId;
	private String name;
	private String value;

	public CbcrProp() {
		// super();
	}

	public CbcrProp(int tieDocId, String name, String value) {
		super();
		this.tieDocId = tieDocId;
		this.name = name;
		this.value = value;
	}

	public int getTieDocId() {
		return tieDocId;
	}

	public void setTieDocId(int tieDocId) {
		this.tieDocId = tieDocId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "CbcrProp [tieDocId=" + tieDocId + ", name=" + name + ", value=" + value + "]";
	}

}
