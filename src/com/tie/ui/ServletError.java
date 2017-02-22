package com.tie.ui;

public class ServletError {
	private String errorName;
	private String errorDescription;

	public ServletError(String errorName, String descr) {
		super();
		this.errorName = errorName;
		this.errorDescription = descr;
	}

	public ServletError() {
		super();
	}

	public String getErrorName() {
		return errorName;
	}

	public void setErrorName(String errorName) {
		this.errorName = errorName;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	@Override
	public String toString() {
		return "ServletError [errorName=" + errorName + ", errorDescription=" + errorDescription + "]";
	}


	
}
