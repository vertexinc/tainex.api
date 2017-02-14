package com.tie.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.tie.model.TieApp;
import com.tie.model.TieUser;

public class TieUserDao extends BaseDao {
	
	//find out the user record by the given usercode 
	
	public TieUser findTieUserByCode(String code) {
		getConnection();

		TieUser tieUser = null;
		try {
			String sql = "select * from tieuser where code = ?";

			PreparedStatement selectStatement = conn.prepareStatement(sql);
			selectStatement.setString(1, code);
			rs = selectStatement.executeQuery();

			while (rs.next()) {
				int tieUserId = rs.getInt("tieUserId");
				String uname = rs.getString("name");
				//String code = rs.getString("code");
				String description = rs.getString("description");
				String email = rs.getString("email");
				String ctsUserId = rs.getString("ctsUserId");
				String ctsUserPwd = rs.getString("ctsUserPwd");
				String ctsUserCertificate = rs.getString("ctsUserCertificate");
				int tieAppId = rs.getInt("tieAppId");
				int isExternal = rs.getInt("isExternal");
				String password = rs.getString("password");
				tieUser = new TieUser(tieUserId, uname, code, description, email, ctsUserId, ctsUserPwd,
						ctsUserCertificate, tieAppId, isExternal,password);
				// tieapp = new TieApp(name,description);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			/*if (conn != null) {
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

		return tieUser;
	}
	
	
	public TieUser findTieUserById(int id) {
		getConnection();

		TieUser tieUser = null;
		try {
			String sql = "select * from tieuser where tieuserid = ?";

			PreparedStatement selectStatement = conn.prepareStatement(sql);
			selectStatement.setInt(1, id);
			rs = selectStatement.executeQuery();

			while (rs.next()) {
				//int tieUserId = rs.getInt("tieUserId");
				String uname = rs.getString("name");
				String code = rs.getString("code");
				String description = rs.getString("description");
				String email = rs.getString("email");
				String ctsUserId = rs.getString("ctsUserId");
				String ctsUserPwd = rs.getString("ctsUserPwd");
				String ctsUserCertificate = rs.getString("ctsUserCertificate");
				int tieAppId = rs.getInt("tieAppId");
				int isExternal = rs.getInt("isExternal");
				String password = rs.getString("password");
				tieUser = new TieUser(id, uname, code, description, email, ctsUserId, ctsUserPwd,
						ctsUserCertificate, tieAppId, isExternal,password);
				
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

		return tieUser;
	}
}
