
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

		retval = loginDao.validate(name, pass);
		return retval;
	}
}
