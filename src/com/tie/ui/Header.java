package com.tie.ui;

import java.util.ArrayList;
import java.util.List;

public class Header {
	private String appName;
	private String userName;
	private ArrayList<String> language;

	public Header() {
//		super();
	}

	public Header(String appName, String userName, ArrayList<String> language) {
//		super();
		this.appName = appName;
		this.userName = userName;
		this.language = language;
	}



	public ArrayList<String> getLanguage() {
		return language;
	}

	public void setLanguage(ArrayList<String> language) {
		this.language = language;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}