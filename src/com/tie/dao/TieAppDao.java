package com.tie.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tie.util.DbUtil;
import com.tie.model.TieApp;
import com.tie.model.TieUser;
import com.tie.ui.TieMainPage;

public class TieAppDao {
	public TieApp getTieAppById(int id) throws SQLException{
		Connection conn = BaseDao.getInstance().getConnection();
		String sql = "select name from mx.tieapp where tieAppId = ?";
		
		PreparedStatement selectStatement = conn.prepareStatement(sql);
		selectStatement.setInt(1, id);
		ResultSet results = selectStatement.executeQuery();
		TieApp tieApp = null;
		if(results.next()){
			String name = results.getString("name");
			String code = results.getString("code");
			String description = results.getString("description");
			String ctsId = results.getString("ctsId");
			String ctsPwd = results.getString("ctsPwd");
			String taxAuthorityCode = results.getString("taxAuthorityCode");
			String countryCode = results.getString("countryCode");
			int isRunning = results.getInt("isRunning");
			
			tieApp = new TieApp(id,name,code,description,ctsId,ctsPwd,taxAuthorityCode,countryCode,isRunning);
		}
		
		results.close();
		selectStatement.close();
		
		return tieApp;
	}

	/*
	 * public String appname() { // get connection from super class
	 * getConnection(); String appname = "test"; try {
	 * 
	 * pst =
	 * conn.prepareStatement("select name from mx.tieapp where tieAppId = 1");
	 * // pst.setString(1, name); // pst.setString(2, pass);
	 * 
	 * rs = pst.executeQuery(); while (rs.next()) { appname = rs.getString(1); }
	 * 
	 * } catch (Exception e) { System.out.println(e); } finally { if (conn !=
	 * null) { try { conn.close(); } catch (SQLException e) {
	 * e.printStackTrace(); } } if (pst != null) { try { pst.close(); } catch
	 * (SQLException e) { e.printStackTrace(); } } if (rs != null) { try {
	 * rs.close(); } catch (SQLException e) { e.printStackTrace(); } } } //Set
	 * the Appname in com.tie.ui.TieMainPage.java TieMainPage tieMainPage = new
	 * TieMainPage(); tieMainPage.setAppName(appname); return appname;
	 */

}