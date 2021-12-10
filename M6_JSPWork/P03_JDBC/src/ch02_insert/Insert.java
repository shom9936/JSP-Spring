package ch02_insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/*
 * 쿼리 실행을 위한 객체 생성 - PrepareStatement
 * - java.sql.PrepareStatement
 * 
 * 쿼리 실행 메서드
 * - int excuteUpdate()
 *   > insert, delete, update 문에서 실행 결과를 받을 때 사용하는 메서드
 *   
 *   ResultSet executeQuery()
 *   > select 문에서 실행 결과를 받을 때 사용하는 메서드
 */

/*
create table dbtest(
name varchar2(20),
age number,
height number(10, 2),
logtime date
);
 */


class InsertTest{
	
	public InsertTest() {
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
	
	public void insertArticle() {
		Scanner scan = new Scanner(System.in);
		System.out.print("이름 입력 : ");
		String name = scan.next();
		System.out.print("나이 입력 : ");
		int age = scan.nextInt();
		System.out.print("키 입력  : ");
		double height = scan.nextDouble();
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int su = 0;
		
		try {
			String sql = "insert into dbtest values(?, ?, ?, sysdate)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name); // 1부터 시작
			pstmt.setInt(2, age);
			pstmt.setDouble(3, height);
			su = pstmt.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
				if(scan != null) scan.close();
			}
			catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		System.out.println(su + "개의 행이 추가되었습니다.");
		
	}
	
}

public class Insert {

	public static void main(String[] args) {
		
		InsertTest it = new InsertTest();
		it.insertArticle();
	}

}
