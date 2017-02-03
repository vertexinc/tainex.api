package com.tie.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tie.model.CbcrTable1;
import com.tie.model.TieDoc;
import com.tie.model.TieMsg;
import com.tie.model.TieTaxEntity;

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
	
	public List<CbcrTable1> saveAttachedCbcrTable1(TieDoc parsedDoc, int docId){
		getConnection();
		//use other insertionCode
		try {
			for(int i = 0;i < parsedDoc.getCbcrTable1List().size();i++){
			String sql;// TODO : insert and update in separate methods
			sql = "insert into cbcrtable1 values(?,?,?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement saveStatement = conn.prepareStatement(sql);
			saveStatement.setInt(1, docId);
			saveStatement.setString(2, parsedDoc.getCbcrTable1List().get(i).getTaxJurisdiction());
			saveStatement.setFloat(3, parsedDoc.getCbcrTable1List().get(i).getRevenueUnrelatedParty());
			saveStatement.setFloat(4, parsedDoc.getCbcrTable1List().get(i).getRevenueRelatedParty());
			saveStatement.setFloat(5, parsedDoc.getCbcrTable1List().get(i).getRevenueTotal());
			saveStatement.setFloat(6, parsedDoc.getCbcrTable1List().get(i).getPlBeforeIncomeTax());
			saveStatement.setFloat(7, parsedDoc.getCbcrTable1List().get(i).getIncomeTaxPaid());
			saveStatement.setFloat(8, parsedDoc.getCbcrTable1List().get(i).getIncomeTaxAccrued());
			saveStatement.setFloat(9, parsedDoc.getCbcrTable1List().get(i).getStatedCapital());
			saveStatement.setFloat(10, parsedDoc.getCbcrTable1List().get(i).getAccumulatedEarnings());
			saveStatement.setInt(11, parsedDoc.getCbcrTable1List().get(i).getNumberOfEmployees());
			saveStatement.setFloat(12, parsedDoc.getCbcrTable1List().get(i).getTangibleAssetsNonCash());
			
			saveStatement.executeUpdate();


			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
	return findCbcrTable1ByTieDocId(docId);
		//return null;
	}
}
