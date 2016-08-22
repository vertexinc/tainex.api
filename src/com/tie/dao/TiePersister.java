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
	TieMsgDao tieMsgDao;
	TieUserDao tieUserDao;
	TieDocDao tieDocDao;
	
	public TieDocDao getTieDocDao() {
		return tieDocDao;
	}

	public void setTieDocDao(TieDocDao tieDocDao) {
		this.tieDocDao = tieDocDao;
	}

	public TieMsgDao getTieMsgDao() {
		return tieMsgDao;
	}

	public void setTieMsgDao(TieMsgDao tieMsgDao) {
		this.tieMsgDao = tieMsgDao;
	}

	public TieUserDao getTieUserDao() {
		return tieUserDao;
	}

	public void setTieUserDao(TieUserDao tieUserDao) {
		this.tieUserDao = tieUserDao;
	}

	public TiePersister() {
		// super();
		// this.tieAppDao = tieAppDao;
		init();
	}

	public void init() {
		// BaseDao basedao = new BaseDao();
		tieAppDao = new TieAppDao();
		loginDao = new LoginDao();
		tieMsgDao = new TieMsgDao();
		tieUserDao = new TieUserDao();
		tieDocDao = new TieDocDao();
	}

	public TieAppDao getTieAppDao() {
		return new TieAppDao();
	}

	public LoginDao getLoginDao() {
		return new LoginDao();
	}
}
