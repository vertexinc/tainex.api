package com.tie.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
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

				tieDoc = new TieDoc(tieDocId, name, code, description, tieDocTypeId, tieMsgId, reportingEntityCode,
						currencyCode, resCountryCode, sourceDoc, accountingStandard, reportingPeriod);
				// tieapp = new TieApp(name,description);
				tieDocList.add(tieDoc);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			/*
			 * if (conn != null) { try { conn.close(); } catch (SQLException e)
			 * { e.printStackTrace(); } }
			 */
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

				tieDoc = new TieDoc(tieDocId, name, code, description, tieDocTypeId, tieMsgId, reportingEntityCode,
						currencyCode, resCountryCode, sourceDoc, accountingStandard, reportingPeriod);
				// tieapp = new TieApp(name,description);

			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			/*
			 * if (conn != null) { try { conn.close(); } catch (SQLException e)
			 * { e.printStackTrace(); } }
			 */
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

	public TieDoc saveAttachedDoc(TieDoc tieDoc, String sessionId,int currentMsgId) {
		if (tieDoc.getTieDocId() <= 0) {
			return insertTieDoc(tieDoc, sessionId,currentMsgId);
		} else {
			return updateTieDoc(tieDoc);
		}
	}// end saveAttachedDoc(..)

	private TieDoc updateTieDoc(TieDoc tieDoc) {
		// TODO Auto-generated method stub
		return null;
	}// end updateTieMessage(.)

	private TieDoc insertTieDoc(TieDoc tieDoc, String sessionId,int currentMsgId) {
		// TODO Auto-generated method stub
		int newDocId = 0;
		String timestamp = new Timestamp(System.currentTimeMillis()).toString();
		String className = this.getClass().getSimpleName();
		String insersionCode = sessionId + timestamp + className;
		String recoverCode = tieDoc.getCode();
		getConnection();
		
		try {
			System.out.println("Started to insert");
			String sql;// TODO : insert and update in separate methods
			sql = "insert into tieDoc values(?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement saveStatement = conn.prepareStatement(sql);
			saveStatement.setString(1, null);
			saveStatement.setString(2, tieDoc.getName());
			saveStatement.setString(3, insersionCode);
			saveStatement.setString(4, tieDoc.getDescription());
			// tieDocTypeId
			saveStatement.setInt(5, 1);
			// tieMsgId need to be passed in
			saveStatement.setInt(6, currentMsgId);

			saveStatement.setString(7, tieDoc.getReportingEntityCode());
			saveStatement.setString(8, tieDoc.getCurrencyCode());
			saveStatement.setString(9, tieDoc.getResCountryCode());
			saveStatement.setString(10, tieDoc.getSourceDoc());
			saveStatement.setString(11, tieDoc.getAccountingStandard());
			saveStatement.setString(12, tieDoc.getReportingPeriod());

			saveStatement.executeUpdate();

			// separate method to handle the Id
			String newDocIdSql = "select * from tieDoc where code = ?";
			PreparedStatement newDocIdSqlStatement = conn.prepareStatement(newDocIdSql);
			newDocIdSqlStatement.setString(1, insersionCode);
			rs = newDocIdSqlStatement.executeQuery();
			while (rs.next()) {
				newDocId = rs.getInt("tieDocId");
			}
			System.out.println("Done  insert: " + tieDoc);
			System.out.println("new TieMSgId : " + newDocId);

			String updateDocIdSql = "update tieDoc set code=tieDocId where tieDocId = ?";
			PreparedStatement updateDocIdStatement = conn.prepareStatement(updateDocIdSql);
			updateDocIdStatement.setInt(1, newDocId);
			updateDocIdStatement.executeUpdate();

			String updateDocCodeSql = "update tieDoc set code=? where tieDocId = ?";
			PreparedStatement updateDocCodeStatement = conn.prepareStatement(updateDocCodeSql);
			updateDocCodeStatement.setString(1, recoverCode);
			updateDocCodeStatement.setInt(2, newDocId);
			updateDocCodeStatement.executeUpdate();

			// Set code to Id after return the tiemsg;
			// updateCode();
		} catch (Exception e) {
			System.out.println(e);
		}
		// After saving, return the doc from db
		//System.out.println("Done insertTieDoc with return: " + findTieDocByTieDocId(newDocId).toString());
		return findTieDocByTieDocId(newDocId);
	}// end insertTieMessage(..)
}