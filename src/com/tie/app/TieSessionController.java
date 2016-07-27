/**
 * 
 */
package com.tie.app;

/**
 * @author awang Respond to requests from one user session
 */
public class TieSessionController extends TieControllerBase {
	
	private String userCode;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
}
