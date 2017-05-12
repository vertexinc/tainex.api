package com.tie.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tie.model.TieDoc;
import com.tie.model.TieMsg;
import com.tie.model.TieMsgReceiver;
import com.tie.model.TieUser;
import com.tie.ui.TieMainPage;

public class TieMsgReceiverDao extends BaseDao {
	// find out the user record by the given usercode

	// ToDo: findTieMsgReceiverByTieMsgId
	public List<TieMsgReceiver> findTieMsgReceiverById(int id) {
		getConnection();

		List<TieMsgReceiver> tieMsgReceiverList = new ArrayList<TieMsgReceiver>();
		try {
			TieMsgReceiver tieMsgReceiver = new TieMsgReceiver();
			String sql = "select * from tiemsgreceiver where tiemsgid = ?";

			PreparedStatement selectStatement = conn.prepareStatement(sql);
			selectStatement.setInt(1, id);
			rs = selectStatement.executeQuery();

			while (rs.next()) {
				int tieMsgId = rs.getInt("tieMsgId");
				String senderCode = rs.getString("senderCode");
				// String code = rs.getString("code");
				String receiverCode = rs.getString("receiverCode");
				int tieMsgTrackingStatusId = rs.getInt("tieMsgTrackingStatusId");
				String trackingNote = rs.getString("trackingNote");
				String receivingCountry = rs.getString("receivingCountry");

				tieMsgReceiver = new TieMsgReceiver(tieMsgId, senderCode, receiverCode, tieMsgTrackingStatusId,
						trackingNote, receivingCountry);
				// tieapp = new TieApp(name,description);
				tieMsgReceiverList.add(tieMsgReceiver);
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

		return tieMsgReceiverList;
	}
//
//	//preprocess raw tieMsgReceive String and then hand over to db
//	public void saveTieMsgReceiver(TieMsg tieMsg, String sessionId) {
//		// TODO : insert and update in separate methods
//		String tieMsgReceiverList = null;
//		if (tieMsg.getMsgReceiverList() != null && tieMsg.getMsgReceiverList().length() > 0) {
//			tieMsgReceiverList = tieMsg.getMsgReceiverList();
//			String[] tieMsgReceiverListItemList = tieMsgReceiverList.split(";");
//			for (String tieMsgReceiverListItem : tieMsgReceiverListItemList) {
//				parseTieMsgReceiver(tieMsg, sessionId, tieMsgReceiverListItem);
//			}
//		}
//	}//end saveTieMsgReceiver(..)
//
//	// Split the receiver list with @
//	private void parseTieMsgReceiver(TieMsg tieMsg, String sessionId, String tieMsgReceiverList) {
//		// TODO Auto-generated method stub
//		String[] tieMsgReceiverStringSet = tieMsgReceiverList.split("@");
//		if (tieMsgReceiverStringSet.length == 2) {
//			String receiverCode = tieMsgReceiverStringSet[0];
//			String receivingCountry = tieMsgReceiverStringSet[1];
//			saveTieMsgReceiverToDB(tieMsg,sessionId,receiverCode,receivingCountry);
//		}
//	}//end parseTieMsgReceiver(...)
//
//	private void saveTieMsgReceiverToDB(TieMsg tieMsg, String sessionId, String receiverCode, String receivingCountry) {
//		// TODO Auto-generated method stub
//		int msgId = tieMsg.getTieMsgId();
//		getConnection();
//		try {
//			String sql;// TODO : insert and update in separate methods
//			sql = "update tiemsg set senderCode=?, receiverCode=?,tieMsgTrackingStatusId=?,trackingNote=?,receivingCountry=? WHERE tiemsgid=?";
//			PreparedStatement saveStatement = conn.prepareStatement(sql);
//			saveStatement.setString(1, tieMsg.getSender().getCode());
//			saveStatement.setString(2, receiverCode);
//			saveStatement.setString(3, receivingCountry);
//			saveStatement.setInt(4, 4);
//			saveStatement.setInt(5, 4);
//			saveStatement.setInt(6, 1);
//			System.out.println("Done  update tieMsgReceiver");
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	}//end saveTieMsgReceiverToDB(....)
}
