/**
 * 
 */
package com.tie.ui;

/**
 * @author awang
 *
 */
public class TieMainPage {
	private String appName;
	private String username;
	private String language;
	private SelectionCriteria selectionCriteria;
	private static TieMainPage tieMainPage;
	
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
