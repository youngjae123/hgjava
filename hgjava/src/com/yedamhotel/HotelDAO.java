package com.yedamhotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HotelDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;

	void disconn() {
        if (conn != null) {
        	try {
				if(conn != null) {
					conn.close();
				}
				if(psmt != null) {
					psmt.close();
				}
				if(rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
	}
	//객실정보
	public List<Room> getList(){
		conn =DAO.getConn();
		List<Room> list = new ArrayList<>();
		sql = "select  room_no,\r\n"
				+ "        room_tp,\r\n"
				+ "        room_ct,\r\n"
				+ "        room_m,\r\n"
				+ "        room_now,\r\n"
				+ "        max\r\n"
				+ "from   room";
		try {
			psmt= conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Room room = new Room();
				room.setRoomno(rs.getInt("room_no"));
				room.setRoomtp(rs.getString("room_tp"));
				room.setRoomct(rs.getString("room_ct"));
				room.setRoomm(rs.getInt("room_m"));
				room.setRoomnow(rs.getString("room_now"));
				room.setMax(rs.getInt("max"));
				list.add(room);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}
}
