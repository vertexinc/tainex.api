package com.tie.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.tie.model.TieDoc;
import com.tie.model.TieMsg;
import com.tie.model.TieMsgState;
import com.tie.model.TieMsgTrackingStatus;
import com.tie.model.TieUser;

public class TieMsgTrackingStatusDao extends BaseDao{
	public TieMsgTrackingStatus findTieMsgTrackingStatusById(int id) {
		getConnection();

		TieMsgTrackingStatus tieMsgTrackingStateus = null;
		try {
			String sql = "select * from tiemsgtrackingstateus where tieMsgTrackingStatusId = ?";

			PreparedStatement selectStatement = conn.prepareStatement(sql);
			selectStatement.setInt(1, id);
			rs = selectStatement.executeQuery();

			while (rs.next()) {
				int tieMsgTrackingStatusId = rs.getInt("tieMsgTrackingStatusId");
				String name = rs.getString("name");
				// String code = rs.getString("code");
				String code = rs.getString("code");
				String description = rs.getString("description");
				
				tieMsgTrackingStateus = new TieMsgTrackingStatus(tieMsgTrackingStatusId,
						name,code,description);
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

		return tieMsgTrackingStateus;
	}
	
	public void recordTieMsgStatus(TieMsg tieMsg, String msg, TieMsgState msgState) {
		int tieMsgId = tieMsg.getTieMsgId();
		int tieMsgStateId = msgState.getTieMsgStateId();
		getConnection();
		try {		
			String sql = "update tiemsg set tieMsgStateId = ? where tieMsgId = ?";
			PreparedStatement updateStatement = conn.prepareStatement(sql);
			updateStatement.setInt(1, tieMsgStateId);
			updateStatement.setInt(2, tieMsgId);
			updateStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}// end recordTieMsgStatus(...)
}
