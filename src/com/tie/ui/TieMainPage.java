/**
 * 
 */
package com.tie.ui;

import java.util.ArrayList;
import java.util.List;

import com.tie.model.TieMsg;

/**
 * @author awang
 *
 */
public class TieMainPage {
	private String appName;
	private String username;
	//supported language list each is a String 
	private String language;
	private SelectionCriteria selectionCriteria;
	//Dont make it static, the 2nd user login will see the override values
	private static TieMainPage tieMainPage = new TieMainPage();
	//list of all the msg
	public List<TieMsg> msgList = new ArrayList<TieMsg>();
	//current tieMsg
	
	private TieMsg currentMsg;
	
	public TieMsg getCurrentMsg() {
		return currentMsg;
	}

	public void setCurrentMsg(TieMsg currentMsg) {
		this.currentMsg = currentMsg;
	}

	public List<TieMsg> getMsgList() {
		return msgList;
	}

	public void setMsgList(List<TieMsg> msgList) {
		this.msgList = msgList;
	}

	public TieMainPage() {
		init();
	}

	public void init() {
		language = "EN";
		selectionCriteria = new SelectionCriteria();
	}
	
	public static TieMainPage getTieMainPage(){
		return tieMainPage;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public SelectionCriteria getSelectionCriteria() {
		return selectionCriteria;
	}

	public void setSelectionCriteria(SelectionCriteria selectionCriteria) {
		this.selectionCriteria = selectionCriteria;
	}
}
