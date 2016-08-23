package com.tie.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.tie.model.TieMsgTrackingStateus;
import com.tie.model.TieUser;

public class TieMsgTrackingStatusDao extends BaseDao{
	public TieMsgTrackingStateus findTieMsgTrackingStatusById(int id) {
		getConnection();

		TieMsgTrackingStateus tieMsgTrackingStateus = null;
		try {
			String sql = "select * from mx.tiemsgtrackingstateus where tieMsgTrackingStatusId = ?";

			PreparedStatement selectStatement = conn.prepareStatement(sql);
			selectStatement.setInt(1, id);
			rs = selectStatement.executeQuery();

			while (rs.next()) {
				int tieMsgTrackingStatusId = rs.getInt("tieMsgTrackingStatusId");
				String name = rs.getString("name");
				// String code = rs.getString("code");
				String code = rs.getString("code");
				String description = rs.getString("description");
				
				tieMsgTrackingStateus = new TieMsgTrackingStateus(tieMsgTrackingStatusId,
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
}
