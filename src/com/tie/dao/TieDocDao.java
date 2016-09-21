package com.tie.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tie.model.TieDoc;
import com.tie.model.TieMsg;
import com.tie.model.TieTaxEntity;

public class TieDocDao extends BaseDao {

	public List<TieDoc> findTieDocByTieMsgId(int id) {
		getConnection();

		List<TieDoc> tieDocList = new ArrayList<TieDoc>();
		try {
			TieDoc tieDoc = new TieDoc();
			;
			String sql = "select * from mx.tiedoc where tiemsgid = ?";

			PreparedStatement selectStatement = conn.prepareStatement(sql);
			selectStatement.setInt(1, id);
			rs = selectStatement.executeQuery();

			while (rs.next()) {
				int tieDocId = rs.getInt("tieDocId");
				String name = rs.getString("name");
				String code = rs.getString("code");
				String description = rs.getString("description");
				
				int tieDocTypeId = rs.getInt("tieDocTypeId");
				int tieMsgId = rs.getInt("tieMsgId");
				
				String reportingEntityCode = rs.getString("reportingEntityCode");
				String currencyCode = rs.getString("currencyCode");
				String resCountryCode = rs.getString("resCountryCode");
				String sourceDoc = rs.getString("sourceDoc");
				String accountingStandard = rs.getString("accountingStandard");
				String reportingPeriod = rs.getString("reportingPeriod");
				
				tieDoc = new TieDoc(tieDocId, name, code, description, tieDocTypeId,tieMsgId,reportingEntityCode,currencyCode,
						resCountryCode,sourceDoc,accountingStandard,reportingPeriod);
				// tieapp = new TieApp(name,description);
				tieDocList.add(tieDoc);
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

		return tieDocList;

	}
	public TieDoc findTieDocByTieDocId(int id) {
		getConnection();
		TieDoc tieDoc = new TieDoc();
		
		try {
		
			
			String sql = "select * from mx.tiedoc where tieDocId = ?";

			PreparedStatement selectStatement = conn.prepareStatement(sql);
			selectStatement.setInt(1, id);
			rs = selectStatement.executeQuery();

			while (rs.next()) {
				int tieDocId = rs.getInt("tieDocId");
				String name = rs.getString("name");
				String code = rs.getString("code");
				String description = rs.getString("description");
				
				int tieDocTypeId = rs.getInt("tieDocTypeId");
				int tieMsgId = rs.getInt("tieMsgId");
				
				String reportingEntityCode = rs.getString("reportingEntityCode");
				String currencyCode = rs.getString("currencyCode");
				String resCountryCode = rs.getString("resCountryCode");
				String sourceDoc = rs.getString("sourceDoc");
				String accountingStandard = rs.getString("accountingStandard");
				String reportingPeriod = rs.getString("reportingPeriod");
				
				tieDoc = new TieDoc(tieDocId, name, code, description, tieDocTypeId,tieMsgId,reportingEntityCode,currencyCode,
						resCountryCode,sourceDoc,accountingStandard,reportingPeriod);
				// tieapp = new TieApp(name,description);
				
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

		return tieDoc;

	}
	
	
}