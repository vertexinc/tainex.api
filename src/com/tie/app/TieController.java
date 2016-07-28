package com.tie.app;

import com.tie.dao.TiePersister;

/*
 * Singleton controller for the application
 */
public class TieController extends TieControllerBase {

	/*
	 * Singleton access of the controller
	 */
	private static TieController controller;

	/*
	 * Hold attributes of the controllers
	 */
	private TiePersister persister;

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

	// Initialization function
	// Create all the controllers

	public void init() {
		persister = new TiePersister();
	}

}
