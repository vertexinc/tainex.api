package com.tie.app;

import com.tie.dao.BaseDao;
import com.tie.dao.TiePersister;

/*
 * Singleton controller for the application
 */
public class TieController extends TieControllerBase {

	/*
	 * Singleton access of the controller
	 */
	private static TieController controller = new TieController();

	/*
	 * Hold attributes of the controllers
	 */
	private TiePersister persister;
	private TieSecurityManager securityManager;
	private TieSessionController sessionController;

	public TieController() {
		init();
		// TODO Auto-generated constructor stub
	}

	public static TieController getController() {
		// check to create singlton
		return controller;
	}// end getController()

	public TiePersister getPersister() {
		return persister;
	}

	public void setPersister(TiePersister persister) {
		this.persister = persister;
	}

	public TieSecurityManager getSecurityManager() {
		return securityManager;
	}

	public void setSecurityManager(TieSecurityManager securityManager) {
		this.securityManager = securityManager;
	}

	public TieSessionController getSessionController() {
		return sessionController;
	}

	public void setSessionController(TieSessionController sessionController) {
		this.sessionController = sessionController;
	}

	// Initialization function
	// Create all the controllers

	public void init() {
		persister = new TiePersister();
		securityManager = new TieSecurityManager();
		sessionController = new TieSessionController();
	}

}
