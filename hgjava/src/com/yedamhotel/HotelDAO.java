package com.yedamhotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
				if (conn != null) {
					conn.close();
				}
				if (psmt != null) {
					psmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

//=======================================고객=====================================

	// 객실정보 확인

	public List<Room> getList() {
		conn = DAO.getConn();
		List<Room> list = new ArrayList<>();
		sql = "select      room_no,\r\n" + "        room_type,\r\n" + "        room_money,\r\n"
				+ "        room_state,\r\n" + "        max_person\r\n" + "from   room";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Room room = new Room();
				room.setRoomno(rs.getInt("room_no"));
				room.setRoomtype(rs.getString("room_type"));
				room.setRoommoney(rs.getInt("room_money"));
				room.setRoomstate(rs.getString("room_state"));
				room.setMaxperson(rs.getInt("max_person"));
				list.add(room);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 예약하기
	public boolean insertCus(String name, String phone, String id, String ci, String co, int pr, int rno) {
		conn = DAO.getConn();
		// SimpleDateFormat sdf = new SimpleDateFormat("yy-mm-dd");
		String sql1;
		String sql2;
		sql1 = "insert into customer (name, \r\n" + "                  phone,\r\n" + "		             id,\r\n"
				+ "				     room_no,\r\n" + "		             check_in,\r\n"
				+ "				     check_out,\r\n" + "		             in_person)\r\n" + "values          (?,\r\n"
				+ "				    ?,\r\n" + "				    ?,\r\n" + "				    ?,\r\n"
				+ "                 to_date(?,'yy-mm-dd')," + "                 to_date(?,'yy-mm-dd'),"
				+ "                 ?)";
		sql2 = "update  room\r\n" + "set room_state ='예약중'\r\n" + "where room_no  = (select room_no\r\n"
				+ "                  from  customer\r\n" + "                  where room_no =?)";
		try {
			psmt = conn.prepareStatement(sql1);
			psmt.setString(1, name);
			psmt.setString(2, phone);
			psmt.setString(3, id);
			psmt.setInt(4, rno);
			psmt.setString(5, ci);
			psmt.setString(6, co);
			psmt.setInt(7, pr);

			int r = psmt.executeUpdate();
			if (r > 0) {
				psmt = conn.prepareStatement(sql2);
				psmt.setInt(1, rno);
				int r1 = psmt.executeUpdate();
				if (r1 > 0) {

					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	}

	// 예약 취소
	public boolean deleteCus(int roomno) {
		conn = DAO.getConn();
		String sql1;
		String sql2;
		sql2 = " delete customer" + " where room_no = ?";
		sql1 = "update room\r\n" + "set room_state = '예약가능'\r\n" + "where room_no  = (select room_no\r\n"
				+ "                  from customer\r\n" + "                  where room_no=?)";

		try {
			psmt = conn.prepareStatement(sql1);
			psmt.setInt(1, roomno);
			int r = psmt.executeUpdate();
			if (r > 0) {
				psmt = conn.prepareStatement(sql2);
				psmt.setInt(1, roomno);
				int r1 = psmt.executeUpdate();
				if (r > 0) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	}

//=====================================관리자===============================================================
	// 예약확인
	public List<Customer> getList2() {
		conn = DAO.getConn();
		List<Customer> cus = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yy-mm-dd");
		sql = "select                     name,\r\n" 
		        + "                       phone,\r\n"
				+ "                       id,\r\n" 
		        + "                       room_no,\r\n"
				+ "                       check_out,\r\n" 
		        + "                       check_in,\r\n"
				+ "                       in_person" 
		        + " from customer\r\n";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				Customer cus1 = new Customer();
				cus1.setName(rs.getString("name"));
				cus1.setPhone(rs.getString("phone"));
				cus1.setId(rs.getString("id"));
				cus1.setRoomno(rs.getInt("room_no"));
				cus1.setCheckout(rs.getDate("check_out"));
				cus1.setCheckin(rs.getDate("check_in"));
				cus1.setInperson(rs.getInt("in_person"));

			}
		} catch (

		SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return cus;
	}

	// 예약정보 수정
	public boolean updateCus(String id) {
		conn = DAO.getConn();
		sql = "update customer " + " set id = nvl(?,id)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
