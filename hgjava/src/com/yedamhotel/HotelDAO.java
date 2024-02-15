package com.yedamhotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
	// 객실정보
	public List<Room> getList() {
		conn = DAO.getConn();
		List<Room> list = new ArrayList<>();
		sql = "select  room_no,\r\n" + "        room_tp,\r\n" + "        room_ct,\r\n" + "        room_m,\r\n"
				+ "        room_now,\r\n" + "        max\r\n" + "from   room";
		try {
			psmt = conn.prepareStatement(sql);
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

	// 예약하기
	public boolean insertCus(Customer cus) {
		conn = DAO.getConn();
		SimpleDateFormat sdf = new SimpleDateFormat("yy-mm-dd");
		sql = "insert into customer (name,\r\n" + "                       phone,\r\n" + "                       id,\r\n"
				+ "                       room_no,\r\n" + "                       ci,\r\n"
				+ "                       co,\r\n" + "                       pr)\r\n" + "values (?,\r\n"
				+ "        ?,\r\n" + "        ?,\r\n" + "        ?,\r\n" + "        ?,\r\n" + "        ?,\r\n"
				+ "        ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, cus.getName());
			psmt.setString(2, cus.getPhone());
			psmt.setString(3, cus.getId());
			psmt.setInt(4, cus.getRoomno());
			psmt.setString(5, sdf.format(cus.getCi()));
			psmt.setString(6, sdf.format(cus.getCo()));
			psmt.setInt(7, cus.getPr());

			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	}

	// 삭제
	public boolean deleteCus(String id) {
		conn = DAO.getConn();
		sql = "delete Customer" + " where id = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	}

//=====================================관리자===========================
	// 예약확인
	public List<Customer> getList2(String id) {
		conn = DAO.getConn();
		List<Customer> list = new ArrayList<>();
		sql = "select                     name,\r\n" + "                       id,\r\n"
				+ "                       phone,\r\n" + "                       ci,\r\n"
				+ "                       co,\r\n" + "                       room_no,\r\n"
				+ "                       pr\r\n" + "from customer\r\n" + "where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Customer cus = new Customer();
				cus.setName(rs.getString("name"));
				cus.setPhone(rs.getString("phone"));
				cus.setCi(rs.getDate("ci"));
				cus.setCo(rs.getDate("co"));
				cus.setRoomno(rs.getInt("room_no"));
				cus.setPr(rs.getInt("pr"));
				list.add(cus);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
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

