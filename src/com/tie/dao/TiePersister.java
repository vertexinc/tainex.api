/**
 * 
 */
package com.tie.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author awang Holding all connection information Control all other daos 15
 *         attributes one for each DAO Attributes for the connection info 15
 *         helpers one for each table COnnections prop
 */
public class TiePersister {
	
	TieAppDao tieAppDao;
	LoginDao loginDao;
	
	public TiePersister() {
		// super();
		// this.tieAppDao = tieAppDao;
		init();
	}

	public void init() {
		//BaseDao basedao = new BaseDao();
		tieAppDao = new TieAppDao();
		loginDao = new LoginDao();
	}
	
	
	public TieAppDao getTieAppDao(){
		return new TieAppDao();
	}
	
	public LoginDao getLoginDao(){
		return new LoginDao();
	}
}
