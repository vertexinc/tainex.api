/**
 * 
 */
/**
 * @author awang
 *
 */
package com.tie.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tie.model.TieMsg;

public class TieMsgDao extends BaseDao {
	// SELECT AUTO_INCREMENT
	// FROM information_schema.TABLES
	// WHERE TABLE_SCHEMA = "mx"
	// AND TABLE_NAME = "tiemsg"

	// Easiest way to find the recent max iD:
	// SELECT MAX(tiemsgid) FROM mx.tiemsg

	public List<TieMsg> findTieMsgByOwnerId(int id) {
		getConnection();

		List<TieMsg> msgList = new ArrayList<TieMsg>();
		try {
			TieMsg tieMsg = new TieMsg();

			String sql = "select * from tiemsg where ownerid = ?";

			PreparedStatement selectStatement = conn.prepareStatement(sql);
			selectStatement.setInt(1, id);
			rs = selectStatement.executeQuery();

			while (rs.next()) {
				int tieMsgId = rs.getInt("tieMsgId");
				String subject = rs.getString("subject");
				String code = rs.getString("code");
				String description = rs.getString("description");
				String notes = rs.getString("notes");
				int senderId = rs.getInt("senderId");
				int ownerid = rs.getInt("ownerid");
				int tieMsgStateId = rs.getInt("tieMsgStateId");
				String sendingEntityIdNum = rs.getString("sendingEntityIdNum");
				String transmittingCountry = rs.getString("transmittingCountry");
				String receivingCountries = rs.getString("receivingCountries");
				String messageType = rs.getString("messageType");
				String lauguage = rs.getString("lauguage");
				String warning = rs.getString("warning");
				String contact = rs.getString("contact");
				String messageRefId = rs.getString("messageRefId");
				String messageTypeIndic = rs.getString("messageTypeIndic");
				String corrMessageRefIds = rs.getString("corrMessageRefIds");
				String reportingPeriod = rs.getString("reportingPeriod");
				String timestamp = rs.getString("timestamp");
				String rawMsg = rs.getString("rawMsg");

				tieMsg = new TieMsg(tieMsgId, subject, code, description, notes, senderId, ownerid, tieMsgStateId,
						sendingEntityIdNum, transmittingCountry, receivingCountries, messageType, lauguage, warning,
						contact, messageRefId, messageTypeIndic, corrMessageRefIds, reportingPeriod, timestamp, rawMsg);
				// tieapp = new TieApp(name,description);
				msgList.add(tieMsg);
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

		return msgList;
	}

	public TieMsg findTieMsgByTieMsgId(int id) {
		getConnection();

		TieMsg msg = new TieMsg();
		try {

			String sql = "select * from tiemsg where tiemsgId = ?";

			PreparedStatement selectStatement = conn.prepareStatement(sql);
			selectStatement.setInt(1, id);
			rs = selectStatement.executeQuery();

			while (rs.next()) {
				int tieMsgId = rs.getInt("tieMsgId");
				String subject = rs.getString("subject");
				String code = rs.getString("code");
				String description = rs.getString("description");
				String notes = rs.getString("notes");
				int senderId = rs.getInt("senderId");
				int ownerid = rs.getInt("ownerid");
				int tieMsgStateId = rs.getInt("tieMsgStateId");
				String sendingEntityIdNum = rs.getString("sendingEntityIdNum");
				String transmittingCountry = rs.getString("transmittingCountry");
				String receivingCountries = rs.getString("receivingCountries");
				String messageType = rs.getString("messageType");
				String lauguage = rs.getString("lauguage");
				String warning = rs.getString("warning");
				String contact = rs.getString("contact");
				String messageRefId = rs.getString("messageRefId");
				String messageTypeIndic = rs.getString("messageTypeIndic");
				String corrMessageRefIds = rs.getString("corrMessageRefIds");
				String reportingPeriod = rs.getString("reportingPeriod");
				String timestamp = rs.getString("timestamp");
				String rawMsg = rs.getString("rawMsg");

				msg = new TieMsg(tieMsgId, subject, code, description, notes, senderId, ownerid, tieMsgStateId,
						sendingEntityIdNum, transmittingCountry, receivingCountries, messageType, lauguage, warning,
						contact, messageRefId, messageTypeIndic, corrMessageRefIds, reportingPeriod, timestamp, rawMsg);
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

		return msg;
	}

	public TieMsg saveTieMessage(TieMsg tieMsg, String sessionId) {
		// TODO : insert and update in separate methods
		if (tieMsg.getTieMsgId() <= 0) {
			return insertTieMessage(tieMsg, sessionId);
		} else {
			return updateTieMessage(tieMsg);
		}

	}

	public TieMsg insertTieMessage(TieMsg tieMsg, String sessionId) {
		int newMsgId = 0;
		// Set specific code for message insertion
		String timestamp = new Timestamp(System.currentTimeMillis()).toString();
		String className = this.getClass().getSimpleName();
		String insersionCode = sessionId + timestamp + className;
		System.out.println("insertionCode: " + insersionCode);
		getConnection();
		try {
			System.out.println("Started to insert");
			String sql;// TODO : insert and update in separate methods
			sql = "insert into tiemsg values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement saveStatement = conn.prepareStatement(sql);
			saveStatement.setString(1, null);
			saveStatement.setString(2, tieMsg.getSubject());
			saveStatement.setString(3, insersionCode);
			saveStatement.setString(4, tieMsg.getDescription());
			saveStatement.setString(5, tieMsg.getNotes());
			saveStatement.setInt(6, 3);
			saveStatement.setInt(7, 4); // CD This is hard coded as 4, will
										// change to tieMsg.getOwnerId()
										// later
			saveStatement.setInt(8, 1);
			saveStatement.setString(9, tieMsg.getSendingEntityIdNum());
			saveStatement.setString(10, tieMsg.getTransmittingCountry());
			saveStatement.setString(11, tieMsg.getReceivingCountries());
			saveStatement.setString(12, tieMsg.getMessageType());
			saveStatement.setString(13, tieMsg.getLauguage());
			saveStatement.setString(14, tieMsg.getWarning());
			saveStatement.setString(15, tieMsg.getContact());
			saveStatement.setString(16, tieMsg.getMessageRefId());
			saveStatement.setString(17, tieMsg.getMessageTypeIndic());
			saveStatement.setString(18, tieMsg.getCorrMessageRefIds());
			saveStatement.setString(19, tieMsg.getReportingPeriod());
			saveStatement.setString(20, tieMsg.getTimestamp());
			saveStatement.setString(21, tieMsg.getRawMsg());
			saveStatement.executeUpdate();

			// separate method to handle the Id
			String newMsgIdSql = "select * from tiemsg where code = ?";
			PreparedStatement newMsgIdSqlStatement = conn.prepareStatement(newMsgIdSql);
			newMsgIdSqlStatement.setString(1, insersionCode);
			rs = newMsgIdSqlStatement.executeQuery();
			while (rs.next()) {
				newMsgId = rs.getInt("tieMsgId");
			}
			System.out.println("Done  insert: " + tieMsg);
			System.out.println("new TieMSgId : " + newMsgId);

			String updateMsgIdSql = "update tiemsg set code=tieMsgId where tieMsgId = ?";
			PreparedStatement updateMsgIdStatement = conn.prepareStatement(updateMsgIdSql);
			updateMsgIdStatement.setInt(1, newMsgId);
			updateMsgIdStatement.executeUpdate();

			// Set code to Id after return the tiemsg;
			// updateCode();
		} catch (Exception e) {
			System.out.println(e);
		}
		//After saving, return the message from db
		return findTieMsgByTieMsgId(newMsgId);
	}

	// public void updateCode() throws SQLException {
	// int newMsgId = 0;
	// getConnection();
	//
	// String newMsgIdSql = "select * from mx.tiemsg where code IS NULL";
	// PreparedStatement newMsgIdSqlStatement =
	// conn.prepareStatement(newMsgIdSql);
	// rs = newMsgIdSqlStatement.executeQuery();
	//
	// newMsgId = rs.getInt("tieMsgId");
	// System.out.println(newMsgId);
	//
	// String updateMsgIdSql = "update mx.tiemsg set code=tieMsgId where
	// tieMsgId = ?";
	// PreparedStatement updateMsgIdStatement =
	// conn.prepareStatement(updateMsgIdSql);
	// updateMsgIdStatement.setInt(1, newMsgId);
	// updateMsgIdStatement.executeUpdate();
	// }

	public TieMsg updateTieMessage(TieMsg tieMsg) {
		int currMsgId = tieMsg.getTieMsgId();
		getConnection();
		try {
			System.out.println("Started to updateTieMessage");
			String sql;// TODO : insert and update in separate methods
			sql = "update tiemsg set subject=?, description=?,notes=?,senderId=?,ownerid=?,tieMsgStateId=?,sendingEntityIdNum=?,transmittingCountry=?,receivingCountries=?,messageType=?,lauguage=?,warning=?,contact=?,messageRefId=?,messageTypeIndic=?,corrMessageRefIds=?,reportingPeriod=?,timestamp=?,rawMsg=? WHERE tieMsgId=?";
			PreparedStatement saveStatement = conn.prepareStatement(sql);
			saveStatement.setString(1, tieMsg.getSubject());
//			saveStatement.setString(2, tieMsg.getCode());
			saveStatement.setString(2, tieMsg.getDescription());
			saveStatement.setString(3, tieMsg.getNotes());
			saveStatement.setInt(4, 3);
			saveStatement.setInt(5, 4);
			saveStatement.setInt(6, 1);
			saveStatement.setString(7, tieMsg.getSendingEntityIdNum());
			saveStatement.setString(8, tieMsg.getTransmittingCountry());
			saveStatement.setString(9, tieMsg.getReceivingCountries());
			saveStatement.setString(10, tieMsg.getMessageType());
			saveStatement.setString(11, tieMsg.getLauguage());
			saveStatement.setString(12, tieMsg.getWarning());
			saveStatement.setString(13, tieMsg.getContact());
			saveStatement.setString(14, tieMsg.getMessageRefId());
			saveStatement.setString(15, tieMsg.getMessageTypeIndic());
			saveStatement.setString(16, tieMsg.getCorrMessageRefIds());
			saveStatement.setString(17, tieMsg.getReportingPeriod());
			saveStatement.setString(18, tieMsg.getTimestamp());
			saveStatement.setString(19, tieMsg.getRawMsg());
			saveStatement.setInt(20, tieMsg.getTieMsgId());
			saveStatement.executeUpdate();
			System.out.println("Done  update: " + tieMsg);
		} catch (Exception e) {
			System.out.println(e);
		}
		return findTieMsgByTieMsgId(currMsgId);
	}
	
	public void deleteMessageById(int tieMsgId){
		getConnection();
		try {
			String sql;// TODO : insert and update in separate methods
			sql = "delete from tiemsg where tiemsgid = ?";
			PreparedStatement deleteStatement = conn.prepareStatement(sql);
			deleteStatement.setInt(1, tieMsgId);
			deleteStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}