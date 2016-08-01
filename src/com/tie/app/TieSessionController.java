
package com.tie.app;

import com.tie.ui.TieMainPage;

/**
 * @author awang Respond to requests from one user session
 */
public class TieSessionController extends TieControllerBase {

	private String userCode;
	// point to ui class
	
	TieMainPage mainPage;
	
	// The key to access session controller
	public static String sesssionControllerName = "theSessionController";
	
	public void init() {
		mainPage = new TieMainPage();
	}
	

	public TieSessionController() {
		init();
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public TieMainPage getMainPage() {
		return mainPage;
	}

	public void setMainPage(TieMainPage mainPage) {
		this.mainPage = mainPage;
	}


	//populate the mainPage's every object
	//get the persister first
	//from the persister get the Dao and invoke method insides it to populate over to mainPage
	public void handleLogin() {
		
	}
}
