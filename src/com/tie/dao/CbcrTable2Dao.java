package com.tie.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tie.model.CbcrTable1;
import com.tie.model.CbcrTable2;
import com.tie.model.TieMsg;

public class CbcrTable2Dao extends BaseDao{
	public List<CbcrTable2> findCbcrTable2ByTieDocId(int id) {
		getConnection();
	
		List<CbcrTable2> cbcrTable2List = new ArrayList<CbcrTable2>();
		try {
			CbcrTable2 cbcrTable2 = new CbcrTable2();;
			String sql = "select * from mx.cbcrtable2 where tieDocId = ?";

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
				int mainBusOtherNotes = rs.getInt("mainBusOtherNotes");
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
}
