package com.tie.model;

public class TieUser {
	private int tieUserId;
	private String name;
	private String code;
	private String description;
	private String email;
	private String ctsUserId;
	private String ctsUserPwd;
	private String ctsUserCertificate;
	private int tieAppId;
	private int isExternal;
	public TieUser() {
		//super();
	}
	public TieUser(int tieUserId, String name, String code, String description, String email, String ctsUserId,
			String ctsUserPwd, String ctsUserCertificate, int tieAppId, int isExternal) {
		//super();
		this.tieUserId = tieUserId;
		this.name = name;
		this.code = code;
		this.description = description;
		this.email = email;
		this.ctsUserId = ctsUserId;
		this.ctsUserPwd = ctsUserPwd;
		this.ctsUserCertificate = ctsUserCertificate;
		this.tieAppId = tieAppId;
		this.isExternal = isExternal;
	}
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
	public String getCtsUserPwd() {
		return ctsUserPwd;
	}
	public void setCtsUserPwd(String ctsUserPwd) {
		this.ctsUserPwd = ctsUserPwd;
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
	public int getIsExternal() {
		return isExternal;
	}
	public void setIsExternal(int isExternal) {
		this.isExternal = isExternal;
	}
	
	@Override
	public String toString() {
		return "TieUser [tieUserId=" + tieUserId + ", name=" + name + ", code=" + code + ", description=" + description
				+ ", email=" + email + ", ctsUserId=" + ctsUserId + ", ctsUserPwd=" + ctsUserPwd
				+ ", ctsUserCertificate=" + ctsUserCertificate + ", tieAppId=" + tieAppId + ", isExternal=" + isExternal
				+ "]";
	}
	
}