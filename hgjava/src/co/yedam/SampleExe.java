package co.yedam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SampleExe {
	
	static void insertEmp(Connection conn) throws SQLException{ 
		String sql="insert into employee (emp_no,\r\n"
				+ "                       emp_name,\r\n"
				+ "                       email,\r\n"
				+ "                       phone,\r\n"
				+ "                       salary,\r\n"
				+ "                       department)\r\n"
				+ "values                (?,\r\n"
				+ "                      ?,\r\n"
				+ "                      ?,\r\n"
				+ "                      ?,\r\n"
				+ "                      ?,\r\n"
				+ "                      ?)";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setInt(1, 777);
		psmt.setString(2, "박과장");
		psmt.setString(3, "Park@mail.com");
		psmt.setString(4, "234-1234");
		psmt.setString(5, "456");
		psmt.setString(6, "인사");
		
		int r = psmt.executeUpdate();// insert,update, delete
	    System.out.println("처리된 건수: " + r);
	    if(r>0) {
	    	conn.commit();
	    	System.out.println("정상적 입력.");
	    }
	}
	
  public static void main(String[] args) {
//	  String dept = "인사";// selsect * from employee where department = '인사'
//	  String sql = "select * from employee where department = ?  and emp_no >= ?";//sql영역
//	  // String sql = "select * from employee where department = '" + dept + "'";//sql영역
//	  //Connection객체.
//	  Connection conn = DAO.getConn();
//	  //쿼리를 해석하고 처리된 결과를 반환.
//	  try {
//		  conn.setAutoCommit(false); // autocommit
//		  insertEmp(conn);
//		  
//		PreparedStatement psmt = conn.prepareStatement(sql);
//		psmt.setString(1, dept);
//		psmt.setInt(2, 101);
//	    ResultSet rs = psmt.executeQuery();//조회
//	    System.out.println("사원번호           사원명");
//	    System.out.println("=====================");
//	    while(rs.next()) {
//	    	System.out.println("사원번호: " + rs.getInt("emp_no") + ", 사원명: " + rs.getString("emp_name"));
//	    }
//	} catch (SQLException e) {
//		e.printStackTrace();
//	}
//	  System.out.println("=====================");
	String dept = "인사";
	int page = 3;
	EmpDAO edao = new EmpDAO();
	List<Employee> list = edao.getList(dept, 1);
	System.out.println("사원번호 이름    전화번호   부서");
    System.out.println("=====================");
    for(Employee emp : list) {
		System.out.println(emp.getEmpNo()+" "+ emp.getEmpName()+ " " + emp.getPhone() + " " + emp.getDepartment());
	}
    System.out.println("=====================");
  }
}
