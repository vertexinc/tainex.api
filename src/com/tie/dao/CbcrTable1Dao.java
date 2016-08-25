package com.tie.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tie.model.CbcrTable1;
import com.tie.model.TieMsg;

public class CbcrTable1Dao extends BaseDao{
	public List<CbcrTable1> findCbcrTable1ByTieDocId(int id) {
		getConnection();
	
		List<CbcrTable1> cbcrTable1List = new ArrayList<CbcrTable1>();
		try {
			CbcrTable1 cbcrTable1 = new CbcrTable1();;
			String sql = "select * from mx.cbcrtable1 where tieDocId = ?";

			PreparedStatement selectStatement = conn.prepareStatement(sql);
			selectStatement.setInt(1, id);
			rs = selectStatement.executeQuery();

			while (rs.next()) {
				//int tieDocId = rs.getInt("tieDocId");
				String taxJurisdiction = rs.getString("taxJurisdiction");
				float revenueUnrelatedParty = rs.getFloat("revenueUnrelatedParty");
				float revenueRelatedParty = rs.getFloat("revenueRelatedParty");
				float revenueTotal = rs.getFloat("revenueTotal");
				float plBeforeIncomeTax = rs.getFloat("plBeforeIncomeTax");
				float incomeTaxPaid = rs.getFloat("incomeTaxPaid");
				float incomeTaxAccrued = rs.getFloat("incomeTaxAccrued");
				float statedCapital = rs.getFloat("statedCapital");
				float accumulatedEarnings = rs.getFloat("accumulatedEarnings");
				int numberOfEmployees = rs.getInt("numberOfEmployees");
				float tangibleAssetsNonCash = rs.getFloat("tangibleAssetsNonCash");

				cbcrTable1 = new CbcrTable1(id, taxJurisdiction, revenueUnrelatedParty, revenueRelatedParty, revenueTotal, plBeforeIncomeTax, incomeTaxPaid, incomeTaxAccrued,
						statedCapital, accumulatedEarnings, numberOfEmployees, tangibleAssetsNonCash);
				// tieapp = new TieApp(name,description);
				cbcrTable1List.add(cbcrTable1);
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

		return cbcrTable1List;
	}
}
