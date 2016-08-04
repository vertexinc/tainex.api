
package com.tie.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tie.dao.TiePersister;
import com.tie.model.TieMsg;
import com.tie.ui.TieMainPage;

/**
 * @author awang Respond to requests from one user session
 */
public class TieSessionController extends TieControllerBase {

	private String userCode;
	// point to ui class

	// TieMainPage mainPage;
	// TiePersister persister = null;

	// The key to access session controller
	public static String sesssionControllerName = "theSessionController";

	public void init() {

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
	/*
	 * public TieMainPage getMainPage() { return mainPage; }
	 * 
	 * public void setMainPage(TieMainPage mainPage) { this.mainPage = mainPage;
	 * }
	 */

	// populate the mainPage's every object
	// get the persister first
	// from the persister get the Dao and invoke method insides it to populate
	/* over to mainPage */
	//everything in one time
	public void handleLogin(String username,String code) {
		String appName = TieController.getController().getPersister().getTieAppDao().findTieAppById(1).getName();
		List<TieMsg> msgList = new ArrayList<TieMsg>();
		msgList = TieController.getController().getPersister().getTieMsgDao().findTieMsgByCode(code);
		/*
		 * this always returns null
		String userName = TieController.getController().getPersister().getLoginDao().getUsername();
		if(userName == null){
			System.out.println("username is null");
		}else{
			System.out.println("username is not null");
		}*/
		TieMainPage.getTieMainPage().setAppName(appName);
		TieMainPage.getTieMainPage().setUsername(username);
		TieMainPage.getTieMainPage().setMsgList(msgList);
		System.out.println("msgList" + Arrays.toString(TieMainPage.getTieMainPage().getMsgList().toArray()));
	}
}
