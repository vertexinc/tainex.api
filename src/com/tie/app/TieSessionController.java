
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
import com.tie.model.TieUser;
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
	public void handleLogin(String username) {
		TiePersister persister = TieController.getController().getPersister();
		//TODO handle login
		
		//-------- populate for header pane --------------
		String appName = persister.getTieAppDao().findTieAppById(1).getName();
		
		//Warn:see the sequence of invoking persister, it might not be initiated yet
		TieUser user = persister.getTieUserDao().findTieUserByCode(username);
		
		String userNameOnBoard = user.getName();
		
		
		TieMainPage.getTieMainPage().setAppName(appName);
		TieMainPage.getTieMainPage().setUsername(userNameOnBoard);
	
		//TODO language and language list
		
		//------- populate for selection critera --------	
		//TODO Selection Criteria
		
		//------- populate for msg pane --------
		List<TieMsg> msgList = new ArrayList<TieMsg>();
		
		//Warn:see the sequence of invoking persister, it might not be initiated yet
		msgList = persister.getTieMsgDao().findTieMsgByOwnerId(user.getTieUserId());
		TieMainPage.getTieMainPage().setMsgList(msgList);
		//TODO find the id of the user who's login (theOwnerId)
		//find only by the username who owns the msg
		//THis is the owner id of all the msgs to be selected
		
		//ToDo List<TieMsg> TieMsgDao.findMessageBsyOwner( long ownerId )
		//ToDo add findTieMsgById in tieMsgDao
		//msgList = persister.getTieMsgDao().findTieMsgByCode(code);
		//TieMainPage.getTieMainPage().setMsgList(msgList);
		
		/*
		 * this always returns null
		String userName = TieController.getController().getPersister().getLoginDao().getUsername();
		if(userName == null){
			System.out.println("username is null");
		}else{
			System.out.println("username is not null");
		}*/
		
		
		//------ populate current message pane ------------
			//pick the first tiemsg as default 
		
		//------ populate current msg pane, msg tab -------
		//------ populate current msg pane, doc tab -------
		//------ populate current msg pane, entity tab -------
		//------ populate current msg pane, table1 tab -------
		//------ populate current msg pane, table2 tab -------
		//------ populate current msg pane, table3 tab -------
		
		//System.out.println("msgList" + Arrays.toString(TieMainPage.getTieMainPage().getMsgList().toArray()));
	}
}
