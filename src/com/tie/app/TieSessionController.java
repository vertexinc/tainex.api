
package com.tie.app;

import com.tie.ui.TieMainPage;

/**
 * @author awang Respond to requests from one user session
 */
public class TieSessionController extends TieControllerBase {

	private String userCode;

	public TieSessionController() {
		init();
	}

	// The key to access session controller
	public static String sesssionControllerName = "theSessionController";

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	// point to ui class
	TieMainPage mainPage;

	public TieMainPage getMainPage() {
		return mainPage;
	}

	public void setMainPage(TieMainPage mainPage) {
		this.mainPage = mainPage;
	}

	public void init() {
		mainPage = new TieMainPage();
	}

	//populate the mainPage's username and appname
	public void handleLogin() {
		
	}
}
