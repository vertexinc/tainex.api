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
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.tie.model.TieDoc;
import com.tie.model.TieMsg;
import com.tie.model.TieMsgPackage;
import com.tie.model.TieMsgState;
import com.tie.model.TieMsgTrackingLog;
import com.tie.ui.TieMainPage;

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
				String msgReceiverList = rs.getString("msgReceiverList");
				tieMsg = new TieMsg(tieMsgId, subject, code, description, notes, senderId, ownerid, tieMsgStateId,
						sendingEntityIdNum, transmittingCountry, receivingCountries, messageType, lauguage, warning,
						contact, messageRefId, messageTypeIndic, corrMessageRefIds, reportingPeriod, timestamp, rawMsg,
						msgReceiverList);
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
				String msgReceiverList = rs.getString("msgReceiverList");
				msg = new TieMsg(tieMsgId, subject, code, description, notes, senderId, ownerid, tieMsgStateId,
						sendingEntityIdNum, transmittingCountry, receivingCountries, messageType, lauguage, warning,
						contact, messageRefId, messageTypeIndic, corrMessageRefIds, reportingPeriod, timestamp, rawMsg,
						msgReceiverList);
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
			TieDoc emptyDoc = new TieDoc();
			emptyDoc.setTieDocId(0);
			TieMainPage.getTieMainPage().setCurrentTieDoc(emptyDoc);
			savemessageTiemsgReceiverList(tieMsg);
			return insertTieMessage(tieMsg, sessionId);
		} else {
			savemessageTiemsgReceiverList(tieMsg);
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
			sql = "insert into tiemsg values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement saveStatement = conn.prepareStatement(sql);
			saveStatement.setString(1, null);
			saveStatement.setString(2, tieMsg.getSubject());
			saveStatement.setString(3, insersionCode);
			saveStatement.setString(4, tieMsg.getDescription());
			saveStatement.setString(5, tieMsg.getNotes());
			saveStatement.setInt(6, 4); // CD This is hard coded as 4, will
										// change to tieMsg.getSenderId()
										// later
			saveStatement.setInt(7, 4); // CD This is hard coded as 4, will
										// change to tieMsg.getOwnerId()
										// later
			saveStatement.setInt(8, 1);
			saveStatement.setString(9, tieMsg.getSendingEntityIdNum());
			saveStatement.setString(10, tieMsg.getTransmittingCountry());
			saveStatement.setString(11, tieMsg.getReceivingCountries());
			saveStatement.setString(12, tieMsg.getMessageType());
			saveStatement.setString(13, tieMsg.getLanguage());
			saveStatement.setString(14, tieMsg.getWarning());
			saveStatement.setString(15, tieMsg.getContact());
			saveStatement.setString(16, tieMsg.getMessageRefId());
			saveStatement.setString(17, tieMsg.getMessageTypeIndic());
			saveStatement.setString(18, tieMsg.getCorrMessageRefIds());
			saveStatement.setString(19, tieMsg.getReportingPeriod());
			saveStatement.setString(20, tieMsg.getTimestamp());
			saveStatement.setString(21, tieMsg.getRawMsg());
			saveStatement.setString(22, tieMsg.getMsgReceiverList());
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
		// After saving, return the message from db
		return findTieMsgByTieMsgId(newMsgId);
	}

	public void savemessageTiemsgReceiverList(TieMsg tieMsg) {
		// Parse the receiverList into each object
		ArrayList<String> receiverList = parseReceiverListString(tieMsg.getMsgReceiverList());
		// loop through each receipient to store the recepient info
		for (String receipientString : receiverList) {
			TieMsgTrackingLog tieMsgTrackingLog = new TieMsgTrackingLog();
			tieMsgTrackingLog.setTieMsgId(tieMsg.getTieMsgId());
			parseReceipientString(tieMsgTrackingLog, receipientString);
			// hardcode sendercode
			tieMsgTrackingLog.setSenderCode("Marisol");
			tieMsgTrackingLog.setTrackingNote("Tracking Note");
			tieMsgTrackingLog.setCtsTrackingId("2");
			tieMsgTrackingLog.setTieMsgTrackingStatusId(2);
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			String instant = timestamp.toInstant().toString();
			tieMsgTrackingLog.setTimeStamp(instant);
			insertTiemsgReceiverList(tieMsgTrackingLog);
		}
	}

	private void insertTiemsgReceiverList(TieMsgTrackingLog tieMsgTrackingLog) {
		TieMsgTrackingLogDao tieMsgTrackingLogDao = new TieMsgTrackingLogDao();
		tieMsgTrackingLogDao.recordTieMsgTrackingLog(tieMsgTrackingLog);
	}

	private void updateTiemsgReceiverList(TieMsgTrackingLog tieMsgTrackingLog) {
		// TODO Auto-generated method stub
		TieMsgTrackingLogDao tieMsgTrackingLogDao = new TieMsgTrackingLogDao();
		tieMsgTrackingLogDao.updateTieMsgTrackingLog(tieMsgTrackingLog);
	}

	private void parseReceipientString(TieMsgTrackingLog tieMsgTrackingLog, String receipientString) {
		// TODO Auto-generated method stub
		String[] tieMsgReceiverStringSet = receipientString.split("@");
		if (tieMsgReceiverStringSet.length == 2) {
			tieMsgTrackingLog.setReceiverCode(tieMsgReceiverStringSet[0]);
			tieMsgTrackingLog.setReceivingCountry(tieMsgReceiverStringSet[1]);
		}

	}

	private ArrayList<String> parseReceiverListString(String msgReceiverList) {
		ArrayList<String> receiverList = new ArrayList<String>();
		String[] recipientStringList = msgReceiverList.split(";", -1);
		for (int i = 0; i < recipientStringList.length; i++) {
			if (recipientStringList[i].indexOf("@") != -1) {
				receiverList.add(recipientStringList[i]);
			}
		}
		return receiverList;
	}

	public TieMsg updateTieMessage(TieMsg tieMsg) {
		int currMsgId = tieMsg.getTieMsgId();
		getConnection();
		try {
			System.out.println("Started to updateTieMessage");
			String sql;// TODO : insert and update in separate methods
			sql = "update tiemsg set subject=?, description=?,notes=?,senderId=?,ownerid=?,tieMsgStateId=?,sendingEntityIdNum=?,transmittingCountry=?,receivingCountries=?,messageType=?,lauguage=?,warning=?,contact=?,messageRefId=?,messageTypeIndic=?,corrMessageRefIds=?,reportingPeriod=?,timestamp=?,rawMsg=?,msgReceiverList=? WHERE tieMsgId=?";
			PreparedStatement saveStatement = conn.prepareStatement(sql);
			saveStatement.setString(1, tieMsg.getSubject());
			// saveStatement.setString(2, tieMsg.getCode());
			saveStatement.setString(2, tieMsg.getDescription());
			saveStatement.setString(3, tieMsg.getNotes());
			saveStatement.setInt(4, 4);
			saveStatement.setInt(5, 4);
			saveStatement.setInt(6, 1);
			saveStatement.setString(7, tieMsg.getSendingEntityIdNum());
			saveStatement.setString(8, tieMsg.getTransmittingCountry());
			saveStatement.setString(9, tieMsg.getReceivingCountries());
			saveStatement.setString(10, tieMsg.getMessageType());
			saveStatement.setString(11, tieMsg.getLanguage());
			saveStatement.setString(12, tieMsg.getWarning());
			saveStatement.setString(13, tieMsg.getContact());
			saveStatement.setString(14, tieMsg.getMessageRefId());
			saveStatement.setString(15, tieMsg.getMessageTypeIndic());
			saveStatement.setString(16, tieMsg.getCorrMessageRefIds());
			saveStatement.setString(17, tieMsg.getReportingPeriod());
			saveStatement.setString(18, tieMsg.getTimestamp());
			saveStatement.setString(19, tieMsg.getRawMsg());
			saveStatement.setString(20, tieMsg.getMsgReceiverList());
			System.out.println("tieMsg.getMsgReceiverList()" + tieMsg.getMsgReceiverList());
			saveStatement.setInt(21, tieMsg.getTieMsgId());
			saveStatement.executeUpdate();
			System.out.println("Done  update: " + tieMsg);
		} catch (Exception e) {
			System.out.println(e);
		}
		return findTieMsgByTieMsgId(currMsgId);
	}

	public void deleteMessageById(int tieMsgId) {
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
	}// end deleteMessageById(.)

	public TieMsg recordTieMsgStatus(TieMsg tieMsg, String msg, TieMsgState msgState) {
		int tieMsgId = tieMsg.getTieMsgId();
		int tieMsgStateId = msgState.getTieMsgStateId();
		getConnection();
		try {
			String sql = "update tiemsg set tieMsgStateId = ?, timestamp = ? where tieMsgId = ?";
			PreparedStatement updateStatement = conn.prepareStatement(sql);
			updateStatement.setInt(1, tieMsgStateId);
			String timeStamp = getTimeStamp();
			updateStatement.setString(2, timeStamp);
			updateStatement.setInt(3, tieMsgId);
			updateStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return findTieMsgByTieMsgId(tieMsgId);
	}// end recordTieMsgStatus(...)

	private String getTimeStamp() {
		// TODO Auto-generated method stub
		String timeStamp = new SimpleDateFormat("M/dd/yyyy, K:mm a").format(new java.util.Date());
		return timeStamp;
	}
}