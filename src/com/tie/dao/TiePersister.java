/**
 * 
 */
package com.tie.dao;

/**
 * @author awang Holding all connection information Control all other daos 15
 *         attributes one for each DAO Attributes for the connection info
 * 15  helpers one for each table
 * COnnections prop
 */
public class TiePersister {
	TieAppDao tieAppDao;
	
	
	public TiePersister() {
		//super();
		//this.tieAppDao = tieAppDao;
		init();
	}


	public void init(){
		tieAppDao = new TieAppDao(this);
	}
}
