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

public class LoginDao extends BaseDao {

	// the db by conn from basedao
	String code;
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	


	public boolean validate(String code, String pass) {
		getConnection();
		setCode(code);
		boolean status = false;
		// Connection conn = BaseDao.getInstance().getConnection();
		// boolean status = false;
		// ResultSet rs = null;
		// PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement("select * from tieuser where code=? and password=?");
			pst.setString(1, code);
			pst.setString(2, pass);

			rs = pst.executeQuery();
			status = rs.next();
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
		return status;
	}

}