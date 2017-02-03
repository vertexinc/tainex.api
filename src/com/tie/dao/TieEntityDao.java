package com.tie.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tie.model.TieDoc;
import com.tie.model.TieMsg;
import com.tie.model.TieTaxEntity;

public class TieEntityDao extends BaseDao {
	public List<TieTaxEntity> findTieEntityByTieDocId(int id) {
		getConnection();

		List<TieTaxEntity> taxEntityList = new ArrayList<TieTaxEntity>();
		try {
			TieTaxEntity taxentity = new TieTaxEntity();

			String sql = "select * from mx.taxentity where tieDocId = ? order by taxIdNum";

			PreparedStatement selectStatement = conn.prepareStatement(sql);
			selectStatement.setInt(1, id);
			rs = selectStatement.executeQuery();

			while (rs.next()) {
				int tieDocId = rs.getInt("tieDocId");
				String entityCode = rs.getString("entityCode");
				String name = rs.getString("name");
				String description = rs.getString("description");
				String taxIdNum = rs.getString("taxIdNum");

				String incorpCountryCode = rs.getString("incorpCountryCode");
				String otherEntityInfo = rs.getString("otherEntityInfo");
				String resCountryCode = rs.getString("resCountryCode");
				String idNum = rs.getString("idNum");
				int isPermExtabliment = rs.getInt("isPermExtabliment");
				String addrLegalType = rs.getString("addrLegalType");
				String addrCountryCode = rs.getString("addrCountryCode");
				String addrFreeText = rs.getString("addrFreeText");
				String addrStreet = rs.getString("addrStreet");
				String addrBuildingIdentifier = rs.getString("addrBuildingIdentifier");
				String addrSuiteIdentifier = rs.getString("addrSuiteIdentifier");
				String addrFloorIdentifier = rs.getString("addrFloorIdentifier");
				String addrPOB = rs.getString("addrPOB");

				taxentity = new TieTaxEntity(tieDocId, entityCode, name, description, taxIdNum, incorpCountryCode,
						otherEntityInfo, resCountryCode, idNum, isPermExtabliment, addrLegalType, addrCountryCode,
						addrFreeText, addrStreet, addrBuildingIdentifier, addrSuiteIdentifier, addrFloorIdentifier,
						addrPOB);
				// tieapp = new TieApp(name,description);
				taxEntityList.add(taxentity);
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

		return taxEntityList;
	}

	public TieTaxEntity findTieEntityByCode(String code) {
		getConnection();
		TieTaxEntity mainEntity = new TieTaxEntity();

		try {
			String sql = "select * from mx.taxentity where entityCode = ?";

			PreparedStatement selectStatement = conn.prepareStatement(sql);
			selectStatement.setString(1, code);
			rs = selectStatement.executeQuery();

			while (rs.next()) {
				int tieDocId = rs.getInt("tieDocId");
				// String entityCode = rs.getString("entityCode");
				String name = rs.getString("name");
				String description = rs.getString("description");
				String taxIdNum = rs.getString("taxIdNum");

				String incorpCountryCode = rs.getString("incorpCountryCode");
				String otherEntityInfo = rs.getString("otherEntityInfo");
				String resCountryCode = rs.getString("resCountryCode");
				String idNum = rs.getString("idNum");
				int isPermExtabliment = rs.getInt("isPermExtabliment");
				String addrLegalType = rs.getString("addrLegalType");
				String addrCountryCode = rs.getString("addrCountryCode");
				String addrFreeText = rs.getString("addrFreeText");
				String addrStreet = rs.getString("addrStreet");
				String addrBuildingIdentifier = rs.getString("addrBuildingIdentifier");
				String addrSuiteIdentifier = rs.getString("addrSuiteIdentifier");
				String addrFloorIdentifier = rs.getString("addrFloorIdentifier");
				String addrPOB = rs.getString("addrPOB");

				mainEntity = new TieTaxEntity(tieDocId, code, name, description, taxIdNum, incorpCountryCode,
						otherEntityInfo, resCountryCode, idNum, isPermExtabliment, addrLegalType, addrCountryCode,
						addrFreeText, addrStreet, addrBuildingIdentifier, addrSuiteIdentifier, addrFloorIdentifier,
						addrPOB);
				// tieapp = new TieApp(name,description);
				// taxEntityList.add(taxentity);
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

		return mainEntity;
	}
	
	public List<TieTaxEntity> saveAttachedDocEntity(TieDoc parsedDoc,int docId){
		
//		String entityCode = parsedDoc.getReportingEntity().getEntityCode();
//		String timestamp = new Timestamp(System.currentTimeMillis()).toString();
//		String className = this.getClass().getSimpleName();
//		String insersionCode = sessionId + timestamp + className;
		
	getConnection();
		//use other insertionCode
		try {
			for(int i = 0;i < parsedDoc.getTaxEntityList().size();i++){
			String sql;// TODO : insert and update in separate methods
			sql = "insert into taxentity values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement saveStatement = conn.prepareStatement(sql);
			saveStatement.setInt(1, docId);
			saveStatement.setString(2, parsedDoc.getTaxEntityList().get(i).getEntityCode());
			saveStatement.setString(3, parsedDoc.getTaxEntityList().get(i).getName());
			saveStatement.setString(4, parsedDoc.getTaxEntityList().get(i).getDescription());
			// tieDocTypeId
			saveStatement.setString(5, parsedDoc.getTaxEntityList().get(i).getTaxIdNum());
			// tieMsgId need to be passed in
			saveStatement.setString(6, parsedDoc.getTaxEntityList().get(i).getIncorpCountryCode());

			saveStatement.setString(7, parsedDoc.getTaxEntityList().get(i).getOtherEntityInfo());
			saveStatement.setString(8, parsedDoc.getTaxEntityList().get(i).getResCountryCode());
			saveStatement.setString(9, parsedDoc.getTaxEntityList().get(i).getIdNum());
			saveStatement.setInt(10, parsedDoc.getTaxEntityList().get(i).getIsPermExtabliment());
			saveStatement.setString(11, parsedDoc.getTaxEntityList().get(i).getAddrLegalType());
			saveStatement.setString(12, parsedDoc.getTaxEntityList().get(i).getAddrCountryCode());
			saveStatement.setString(13, parsedDoc.getTaxEntityList().get(i).getAddrFreeText());
			saveStatement.setString(14, parsedDoc.getTaxEntityList().get(i).getAddrStreet());
			saveStatement.setString(15, parsedDoc.getTaxEntityList().get(i).getAddrBuildingIdentifier());
			saveStatement.setString(16, parsedDoc.getTaxEntityList().get(i).getAddrSuiteIdentifier());
			saveStatement.setString(17, parsedDoc.getTaxEntityList().get(i).getAddrFloorIdentifier());
			saveStatement.setString(18, parsedDoc.getTaxEntityList().get(i).getAddrPOB());
			saveStatement.setString(19, "no value");
			saveStatement.setString(20, "no value");
			saveStatement.setString(21, "no value");
			saveStatement.executeUpdate();

			// separate method to handle the Id

//			String updateDocCodeSql = "update taxentity set code=? where tieDocId = ?";
//			PreparedStatement updateDocCodeStatement = conn.prepareStatement(updateDocCodeSql);
//			updateDocCodeStatement.setString(1, entityCode);
//			updateDocCodeStatement.setInt(2, dotId);
//			updateDocCodeStatement.executeUpdate();

			// Set code to Id after return the tiemsg;
			// updateCode();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
	return findTieEntityByTieDocId(docId);
		//return null;
	}

}
