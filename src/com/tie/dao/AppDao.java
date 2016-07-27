/**
 * 
 */
/**
 *
 *
 */
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
import com.tie.model.TieUser;

public class AppDao {
	public  String appname() {
		String status = "test";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "mx";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "000";
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url + dbName, userName, password);

			pst = conn.prepareStatement("select name from mx.app where id = 1");
			// pst.setString(1, name);
			// pst.setString(2, pass);

			rs = pst.executeQuery();
			while (rs.next()) {
			 status = rs.getString(1);
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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
		return status;
	}
}