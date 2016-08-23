package com.tie.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tie.model.TieMsgReceiver;
import com.tie.model.TieUser;

public class TieMsgReceiverDao extends BaseDao {
	// find out the user record by the given usercode
	
	//ToDo: findTieMsgReceiverByTieMsgId
	public List<TieMsgReceiver> findTieMsgReceiverById(int id) {
		getConnection();

		List<TieMsgReceiver> tieMsgReceiverList = new ArrayList<TieMsgReceiver>();
		try {
			TieMsgReceiver tieMsgReceiver = new TieMsgReceiver();
			String sql = "select * from mx.tiemsgreceiver where tiemsgid = ?";

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

		return tieMsgReceiverList;
	}
}
