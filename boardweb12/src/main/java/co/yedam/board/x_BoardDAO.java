package co.yedam.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.common.x_DAO;

public class x_BoardDAO {
	Connection conn;
	ResultSet rs;
	PreparedStatement psmt;
	
	//삭제 
		public boolean deleteBoard(int bno) {
			conn = x_DAO.getConn(); 
			String sql = "delete from tbl_board where board_no = ?";
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, bno);

				int r = psmt.executeUpdate();
				if(r > 0) { // 한 건 입력되면 반환.
					return true;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false; 
		}
	
	//수정.
		public boolean updateBoard(Board board) {
			conn = x_DAO.getConn(); 
			String sql = "update tbl_board set title = ? , content = ? , writer = ? where board_no = ?";
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, board.getTitle());
				psmt.setString(2, board.getContent());
				psmt.setString(3, board.getWriter());
				psmt.setInt(4, board.getBoardNo());
				
				int r = psmt.executeUpdate();
				if(r > 0) { // 한 건 입력되면 반환.
					return true;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false; 
		}
	//등록.
	public boolean insertBoard(Board board) {
		
		conn = x_DAO.getConn(); 
		String sql = "insert into tbl_board (board_no, title, content, writer) "
					+" values (board_seq.nextval, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, board.getTitle());
			psmt.setString(2, board.getContent());
			psmt.setString(3, board.getWriter());
			
			int r = psmt.executeUpdate();
			if(r > 0) { // 한 건 입력되면 반환.
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // 등록이 안되면 return false
		
	}
	//목록 가져오기.
	public List<Board> boardList(){
		String sql = "select * from tbl_board order by 1";
		conn = x_DAO.getConn();
		List<Board> list = new ArrayList<>();
		
		try {
			psmt = conn.prepareStatement(sql);  // 여기에 실행하기위함
			rs = psmt.executeQuery();
			while(rs.next()) {
				Board board = new Board();
				board.setBoardNo(rs.getInt("board_no"));
				board.setTitle(rs.getString("title"));
				board.setCreateDate(rs.getDate("create_date"));
				board.setWriter(rs.getString("writer"));
		
				
				
				list.add(board);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				psmt.close();
				conn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	
}
