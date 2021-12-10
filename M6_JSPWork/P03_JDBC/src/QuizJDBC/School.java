package QuizJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class School {
	
	public School() {
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
	
	// 추가 : 1.학생 -> 학번 , 2.교수 -> 과목 , 3.행정 -> 부서
	public void insert(char sel) {
		Scanner scan = new Scanner(System.in);
		String name;
		String value;
		int code;
		
		
		if(sel == '1') {
			System.out.print("이름 입력 : "); name = scan.next();
			System.out.print("학번 입력 : "); value = scan.next();
			code = (int)sel - 48; // '1' -> 49
		}
		else if(sel == '2') {
			System.out.print("이름 입력 : "); name = scan.next();
			System.out.print("과목 입력 : "); value = scan.next();
			code = (int)sel - 48;
		}
		else if(sel == '3') {
			System.out.print("이름 입력 : "); name = scan.next();
			System.out.print("부서 입력 : "); value = scan.next();
			code = (int)sel - 48;
		}
		else {
			return;
		}
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int su = 0;
		
		try {
			String sql = "insert into school values(?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, value);
			pstmt.setInt(3, code);
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
		System.out.println(su + "개의 행이 추가되었습니다.\n");
	}
	
	// 검색 : 1 : 이름 , 2 : 전체  , 3 : 종료
	public void select(char sel) {
		
		String name = null;
		
		if(sel == '1') {
			Scanner scan = new Scanner(System.in);
			System.out.print("검색할 이름 입력 : "); name = scan.next();
		}
		else if(sel == '2') name = "*";
		else return ;
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		
		try {
			String sql = null;
			if(sel == '1') sql = "select * from school where name = '" + name + "'";
			else sql = "select * from school";
			pstmt = con.prepareStatement(sql);
			rst = pstmt.executeQuery();
			
			while(rst.next()) {
				String printName = rst.getString("name");
				String value = rst.getString("value");
				int code = rst.getInt("code");
				String codeString;
				if(code == 1) codeString = "학번";
				else if(code ==2) codeString = "과목";
				else codeString = "부서";
				System.out.println("이름 : " + printName + "\t" +  codeString + " : " + value);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rst != null) rst.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void delete(char sel) {
		if(sel != '1') return;
		
		String name;
		int su = 0;
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 이름 입력 : "); name = scan.next();
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "delete school where name = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setNString(1, name);
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
		System.out.println(su + "개의 행이 삭제되었습니다.");
	}
}
