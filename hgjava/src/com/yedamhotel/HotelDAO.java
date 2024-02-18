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
	

	// 예약하기
	public boolean insertCus(Customer box) {
		conn = DAO.getConn();
		SimpleDateFormat sdf = new SimpleDateFormat("yy-mm-dd");
		sql = "insert into customer (name, \r\n"
				+ "                  phone,\r\n"
				+ "		             id,\r\n"
				+ "				     room_no,\r\n"
				+ "		             ci,\r\n"
				+ "				     co,\r\n"
				+ "		             pr)\r\n"
				+ "values          (?,\r\n"
				+ "				    ?,\r\n"
				+ "				    ?,\r\n"
				+ "				    ?,\r\n"
				+ "				    ?,\r\n"
				+ "			        ?,\r\n"
				+ "                 ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, box.getName());
			psmt.setString(2, box.getPhone());
			psmt.setString(3, box.getId());
			psmt.setString(4, box.getRoomno());
			psmt.setString(5, box.getCi());
			psmt.setString(6, box.getCo());
			psmt.setInt(7, box.getPr());

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
//업데이트
	public boolean updateCus(Customer box) {
		conn = DAO.getConn();
		SimpleDateFormat sdf = new SimpleDateFormat("yy-mm-dd");
		sql = "update     customer\r\n"
				+ "set    room_no = ?\r\n"
				+ "where  phone = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, box.getRoomno());
			psmt.setString(2, box.getPhone());
//			psmt.setString(1, box.getName());
//			psmt.setString(3, box.getId());
//			psmt.setString(5, box.getCi());
//			psmt.setString(6, box.getCo());
//			psmt.setInt(7, box.getPr());

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
	// 예약 취소
	public boolean deleteCus(String name) {
		conn = DAO.getConn();
		sql = "delete from customer" + " where name = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
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
	// 현재 객실별 정보
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
				cus.setCi(rs.getString("ci"));
				cus.setCo(rs.getString("co"));
				cus.setRoomno(rs.getString("room_no"));
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
	
	// 예약확인
		public List<Room> getList() {
			conn = DAO.getConn();
			List<Room> list = new ArrayList<>();
			sql = "select  room_no,\r\n" 
			        + "        room_tp,\r\n" 
					+ "        room_ct,\r\n" 
			        + "        room_m,\r\n"
					+ "        room_now,\r\n" 
			        + "        max\r\n" 
					+ "from   room";
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
//	public void clear() {
//		for (int i = 0; i < 25; i++)
//			System.out.println();
//	}

	public boolean insertCus(Customer[] box) {
		return false;
	}}
//	public void 
//	}

