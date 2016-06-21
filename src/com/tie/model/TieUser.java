package com.tie.model;

public class TieUser {
	private int tieUserId;
	private String name;
	private String code;
	private String description;
	private String email;
	private String ctsUserId; // ??
	private String ctsUserPwdl;
	private String ctsUserCertificate;
	private int tieAppId;
	
	public int getTieUserId() {
		return tieUserId;
	}
	public void setTieUserId(int tieUserId) {
		this.tieUserId = tieUserId;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCtsUserId() {
		return ctsUserId;
	}
	public void setCtsUserId(String ctsUserId) {
		this.ctsUserId = ctsUserId;
	}
	public String getCtsUserPwdl() {
		return ctsUserPwdl;
	}
	public void setCtsUserPwdl(String ctsUserPwdl) {
		this.ctsUserPwdl = ctsUserPwdl;
	}
	public String getCtsUserCertificate() {
		return ctsUserCertificate;
	}
	public void setCtsUserCertificate(String ctsUserCertificate) {
		this.ctsUserCertificate = ctsUserCertificate;
	}
	public int getTieAppId() {
		return tieAppId;
	}
	public void setTieAppId(int tieAppId) {
		this.tieAppId = tieAppId;
	}
}