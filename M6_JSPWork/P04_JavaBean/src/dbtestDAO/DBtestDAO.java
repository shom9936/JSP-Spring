package dbtestDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbtestDTO.DBtestDTO;

public class DBtestDAO {

	public DBtestDAO() {
		try {
			 Class.forName("oracle.jdbc.OracleDriver");
			 System.out.println("로딩 성공!!");
		 }
		 catch(ClassNotFoundException e) {
			 System.out.println("로딩 실패!!");
			 e.printStackTrace();
		 }
	}
	 
	public Connection getConnection() {
		
		Connection con = null;
		
		 String url = "jdbc:oracle:thin:@localhost:1521:xe";
		 String user = "dbtest";
		 String pw = "a1111";
		 
		 try {
			con = DriverManager.getConnection(url, user, pw);
			System.out.println("연결 성공!!");
		}
		catch (Exception e) {
			System.out.println("연결 실패ㅠㅠ");
			e.printStackTrace();
		}
		 
		 return con;
	}
	
	public int insert(DBtestDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int su = 0;
		
		String sql = "insert into dbtest values(?, ?, ?, sysdate)";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getAge());
			pstmt.setDouble(3, dto.getHeight());
			su = pstmt.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) pstmt.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return su;
	} // insert() end
	
	public void select() {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet res = null;
		
		try {
			String sql = "select * from dbtest";
			pstmt = con.prepareStatement(sql);
			res = pstmt.executeQuery();
			
			while(res.next()) {
				String name = res.getString("name");
				int age = res.getInt("age");
				double height = res.getDouble("height");
				String logtime = res.getString("logtime");
				
				System.out.println(name + "\t" + age + "\t" + height + "\t" + logtime);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(res != null) res.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} // select() end
	
	public int update(DBtestDTO dto) {
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int su = 0;
		
		try {
			String sql = "update dbtest set age = ?, height = ? where name = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getAge());
			pstmt.setDouble(2, dto.getHeight());
			pstmt.setString(3, dto.getName());
			su = pstmt.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return su;
	} // update() end
	
	public int delete(String name) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int su = 0;
		
		try {
			String sql = "delete dbtest where name = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			su = pstmt.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return su;
	}
	
}
