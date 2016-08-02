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
 * @author awang Base Dao as super class for other Daos
 */
public class BaseDao {
	/*
	 * TiePersister tiePersister;
	 * 
	 * 
	 * public BaseDao(TiePersister tiePersister) { //super(); this.tiePersister
	 * = tiePersister; }
	 * 
	 * public TiePersister getTiePersister() { return tiePersister; }
	 * 
	 * public void setTiePersister(TiePersister tiePersister) {
	 * this.tiePersister = tiePersister; }
	*/

	public  Connection conn = null;
	public  PreparedStatement pst = null;
	public  ResultSet rs = null;

	public  Connection getConnection(){
			String url = "jdbc:mysql://localhost:3306/";
			String dbName = "mx";
			String driver = "com.mysql.jdbc.Driver";
			String userName = "root";
			String password = "0000";
			if(conn != null){
				return conn;
			}else{
				try{
					Class.forName(driver).newInstance();
					conn = DriverManager.getConnection(url + dbName, userName, password);
				} catch (Exception e) {
					System.out.println(e);
				} 
			}
			return conn;
			
		} 
	/*
		private static BaseDao instance = new BaseDao();
		private Connection conn;
		private BaseDao(){
			
		}
		public static BaseDao getInstance(){
			return instance;
		}
		
		public Connection getConnection(){
			return conn;
		}
		
		public void connect() throws Exception{
			String url = "jdbc:mysql://localhost:3306/";
			String dbName = "mx";
			String driver = "com.mysql.jdbc.Driver";
			String userName = "root";
			String password = "000";
			if(conn != null){
				return;
			}else{
				try{
					Class.forName(driver).newInstance();
					conn = DriverManager.getConnection(url + dbName, userName, password);
				} catch (Exception e) {
					System.out.println(e);
				} 
			}
			return;
		}
		
		public void disconnect() {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("Can't close connection");
				}
			}
			
			conn = null;
		}
	*/
}
