package com.tie.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.tie.model.CbcrTable3;
import com.tie.model.TieMsg;

public class CbcrTable3Dao extends BaseDao{
	public List<CbcrTable3> findCbcrTable3ByTieDocId(int id) {
		getConnection();
	
		List<CbcrTable3> cbcrTable3List = new ArrayList<CbcrTable3>();
		try {
			CbcrTable3 cbcrTable3 = new CbcrTable3();;
			String sql = "select * from mx.cbcrtable3 where tieDocId = ?";

			PreparedStatement selectStatement = conn.prepareStatement(sql);
			selectStatement.setInt(1, id);
			rs = selectStatement.executeQuery();

			while (rs.next()) {
				//int tieDocId = rs.getInt("tieDocId");
				String countryCode = rs.getString("countryCode");
				String summaryRef = rs.getString("summaryRef");
				String mneGroupName = rs.getString("mneGroupName");
				String fiscalYearConcerned = rs.getString("fiscalYearConcerned");
				String additionalInfo = rs.getString("additionalInfo");

				cbcrTable3 = new CbcrTable3(id, countryCode, summaryRef, mneGroupName, fiscalYearConcerned, additionalInfo);
				// tieapp = new TieApp(name,description);
				cbcrTable3List.add(cbcrTable3);
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

		return cbcrTable3List;
	}
}
