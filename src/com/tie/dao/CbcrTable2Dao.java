package com.tie.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tie.model.CbcrTable1;
import com.tie.model.CbcrTable2;
import com.tie.model.TieDoc;
import com.tie.model.TieMsg;

public class CbcrTable2Dao extends BaseDao{
	public List<CbcrTable2> findCbcrTable2ByTieDocId(int id) {
		getConnection();
	
		List<CbcrTable2> cbcrTable2List = new ArrayList<CbcrTable2>();
		try {
			CbcrTable2 cbcrTable2 = new CbcrTable2();;
			String sql = "select * from cbcrtable2 where tieDocId = ?";

			PreparedStatement selectStatement = conn.prepareStatement(sql);
			selectStatement.setInt(1, id);
			rs = selectStatement.executeQuery();

			while (rs.next()) {
				//int tieDocId = rs.getInt("tieDocId");
				String taxJurisdiction = rs.getString("taxJurisdiction");
				String entityCode = rs.getString("entityCode");
				String taxJurisOfIncorporation = rs.getString("taxJurisOfIncorporation");
				int mainBusRAndD = rs.getInt("mainBusRAndD");
				int mainBusHoldingIp = rs.getInt("mainBusHoldingIp");
				int mainBusPurchasing = rs.getInt("mainBusPurchasing");
				int mainBusSaleMktDistr = rs.getInt("mainBusSaleMktDistr");
				int mainBusAdminMgmtSupportSvc = rs.getInt("mainBusAdminMgmtSupportSvc");
				int mainBusProvSvcToUnrelatedParti = rs.getInt("mainBusProvSvcToUnrelatedParti");
				int mainBusInternalGroupFinance = rs.getInt("mainBusInternalGroupFinance");
				int mainBusRegulatedFinSvc = rs.getInt("mainBusRegulatedFinSvc");
				int mainBusInsurance = rs.getInt("mainBusInsurance");
				int mainBusHoldingEquityInstrument = rs.getInt("mainBusHoldingEquityInstrument");
				int mainBusDormant = rs.getInt("mainBusDormant");
				int mainBusOther = rs.getInt("mainBusOther");
				String mainBusOtherNotes = rs.getString("mainBusOtherNotes");
				int mainBusMfctOrPrdn = rs.getInt("mainBusMfctOrPrdn");

				cbcrTable2 = new CbcrTable2(id, taxJurisdiction, entityCode, taxJurisOfIncorporation, mainBusRAndD, mainBusHoldingIp, mainBusPurchasing, mainBusSaleMktDistr,
						mainBusAdminMgmtSupportSvc, mainBusProvSvcToUnrelatedParti, mainBusInternalGroupFinance, mainBusRegulatedFinSvc,mainBusInsurance
						,mainBusHoldingEquityInstrument,mainBusDormant,mainBusOther,mainBusOtherNotes,mainBusMfctOrPrdn);
				// tieapp = new TieApp(name,description);
				cbcrTable2List.add(cbcrTable2);
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

		return cbcrTable2List;
	}

	public List<CbcrTable2> saveAttachedCbcrTable2(TieDoc parsedDoc, int tieDocId) {
		// TODO Auto-generated method stub
		getConnection();
		//use other insertionCode
		try {
			for(int i = 0;i < parsedDoc.getCbcrTable2List().size();i++){
			String sql;// TODO : insert and update in separate methods
			sql = "insert into cbcrtable2 values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement saveStatement = conn.prepareStatement(sql);
			saveStatement.setInt(1, tieDocId);
			saveStatement.setString(2, parsedDoc.getCbcrTable2List().get(i).getTaxJurisdiction());
			saveStatement.setString(3, parsedDoc.getCbcrTable2List().get(i).getEntityCode());
			saveStatement.setString(4, parsedDoc.getCbcrTable2List().get(i).getTaxJurisOfIncorporation());
			saveStatement.setInt(5,parsedDoc.getCbcrTable2List().get(i).getMainBusRAndD());
			saveStatement.setInt(6,parsedDoc.getCbcrTable2List().get(i).getMainBusHoldingIp());
			saveStatement.setInt(7,parsedDoc.getCbcrTable2List().get(i).getMainBusPurchasing());
			saveStatement.setInt(8,parsedDoc.getCbcrTable2List().get(i).getMainBusSaleMktDistr());
			saveStatement.setInt(9,parsedDoc.getCbcrTable2List().get(i).getMainBusAdminMgmtSupportSvc());
			saveStatement.setInt(10,parsedDoc.getCbcrTable2List().get(i).getMainBusProvSvcToUnrelatedParti());
			saveStatement.setInt(11,parsedDoc.getCbcrTable2List().get(i).getMainBusInternalGroupFinance());
			saveStatement.setInt(12,parsedDoc.getCbcrTable2List().get(i).getMainBusRegulatedFinSvc());
			saveStatement.setInt(13,parsedDoc.getCbcrTable2List().get(i).getMainBusInsurance());
			saveStatement.setInt(14,parsedDoc.getCbcrTable2List().get(i).getMainBusHoldingEquityInstrument());
			saveStatement.setInt(15,parsedDoc.getCbcrTable2List().get(i).getMainBusDormant());
			saveStatement.setInt(16,parsedDoc.getCbcrTable2List().get(i).getMainBusOther());
			saveStatement.setString(17,parsedDoc.getCbcrTable2List().get(i).getMainBusOtherNotes());
			saveStatement.setInt(18,parsedDoc.getCbcrTable2List().get(i).getMainBusMfctOrPrdn());
			saveStatement.executeUpdate();


			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
	return findCbcrTable2ByTieDocId(tieDocId);
		//return null;
	}
	
	public void deleteCbcrTable2ByDocId(int docId) {
		getConnection();
		try {
			String sql;
			sql = "delete from cbcrtable2 where tieDocId = ?";
			PreparedStatement deleteStatement = conn.prepareStatement(sql);
			deleteStatement.setInt(1, docId);
			deleteStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
