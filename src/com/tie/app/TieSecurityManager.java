
package com.tie.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tie.dao.BaseDao;
import com.tie.dao.LoginDao;

/**
 * @author awang Validate username and psw authentication & authorization
 */
public class TieSecurityManager extends TieControllerBase {

	/**
	 * Authenticate the given user name and password.
	 */
	public boolean authentiate(String name, String pass) {
		boolean retval = false;
		LoginDao loginDao = new LoginDao();
		/*
		 * BaseDao basedao = new BaseDao();
		 * 
		 * basedao.getConnection();
		 * 
		 * Connection conn = basedao.conn; PreparedStatement pst = basedao.pst;
		 * ResultSet rs = basedao.rs;
		 * 
		 * try { pst = conn.prepareStatement(
		 * "select * from mx.tieuser where name=? and code=?"); pst.setString(1,
		 * name); pst.setString(2, pass);
		 * 
		 * rs = pst.executeQuery(); retval = rs.next(); } catch (Exception e) {
		 * System.out.println(e); } finally { if (conn != null) { try {
		 * conn.close(); } catch (SQLException e) { e.printStackTrace(); } } if
		 * (pst != null) { try { pst.close(); } catch (SQLException e) {
		 * e.printStackTrace(); } } if (rs != null) { try { rs.close(); } catch
		 * (SQLException e) { e.printStackTrace(); } } }
		 */
		retval = loginDao.validate(name, pass);
		return retval;
	}
}
