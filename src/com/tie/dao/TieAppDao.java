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

public class TieAppDao extends BaseDao {
	// findTIeAPpById
	public TieApp findTieAppById(int id) {
		getConnection();
		String appname = "test";
		TieApp tieapp = null;
		try {
			String sql = "select * from tieapp where tieAppId = ?";

			PreparedStatement selectStatement = conn.prepareStatement(sql);
			selectStatement.setInt(1, id);
			rs = selectStatement.executeQuery();

			while (rs.next()) {
				String name = rs.getString("name");
				String code = rs.getString("code");
				String description = rs.getString("description");
				String ctsId = rs.getString("ctsId");
				String ctsPwd = rs.getString("ctsPwd");
				String taxAuthorityCode = rs.getString("taxAuthorityCode");
				String countryCode = rs.getString("countryCode");
				int isRunning = rs.getInt("isRunning");

				tieapp = new TieApp(id, name, code, description, ctsId,
				 ctsPwd, taxAuthorityCode, countryCode,
				 isRunning);
				//tieapp = new TieApp(name,description);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			/*
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}*/
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return tieapp;
	}

	/*
	 * public String appname() { // get connection from super class
	 * getConnection(); String appname = "test"; try {
	 * 
	 * pst = conn.prepareStatement(
	 * "select name from mx.tieapp where tieAppId = 1"); // pst.setString(1,
	 * name); // pst.setString(2, pass);
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