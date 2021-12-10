package ch03_select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class SelectTest{
	
	public SelectTest() {
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
	
	public void selectArticle() {
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
	}
	
}

public class Select {

	public static void main(String[] args) {
		
		SelectTest st = new SelectTest();
		st.selectArticle();

	}

}
