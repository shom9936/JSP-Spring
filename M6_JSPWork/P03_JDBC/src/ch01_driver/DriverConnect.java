package ch01_driver;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * JDBC ( JAVA DataBase Connection )
 * - JAVA와 DataBase의 연동을 위한 프로그래밍 API
 * 
 * JDBC 드라이버 로딩
 * - DBMS마다 별도의 드라이버가 필요하다.
 * - 일반적으로 JAR 파일 형태로 DBMS마다 기본적으로 제공합니다.
 * - 드라이버 위치
 *   > 11G : C:\oraclexe\oracle\product\11.x.x\server\jdbc\lib\ojdbc6.jar
 *     18C : C:\app\윈도우계정명\product\18.x.x\dbhomeXE\jdbc\lib\ojdbc8.jar
 * - 프로젝트의 build path를 사용해서 추가합니다.
 * - JDBC 드라이버 클래스
 *   > oracle.jdbc.OracleDriver
 * 
 * Connection : java.sql.Connection
 * - 연결 관리를 할 수 있는 객체를 생성합니다.
 * - java.sql.DriverManager 클래스 안에 getConnection() 메소드를 사용해서 생성합니다.
 * - 형식
 *   > jdbc:DMBS명:데이터베이스 식별자(host, port, sid)
 *     jdbc:oracle:드라이버:localhost:1521:xe
 * 
 * 설정
 * - 프로젝트 우클릭 -> build path -> configuration build path -> libraries -> add External jars 
 *   -> 드라이버 추가 -> apply
 */

public class DriverConnect {
	 public static void main(String[] args) {
		
		 try {
			 Class.forName("oracle.jdbc.OracleDriver");
			 System.out.println("로딩 성공!!");
		 }
		 catch(ClassNotFoundException e) {
			 System.out.println("로딩 실패!!");
			 e.printStackTrace();
		 }
		 
		 String url = "jdbc:oracle:thin:@localhost:1521:xe";
		 String user = "dbtest";
		 String pw = "a1111";
		 
		 Connection con = null;
		 
		 try {
			con = DriverManager.getConnection(url, user, pw);
			System.out.println("연결 성공!!");
		}
		catch (Exception e) {
			System.out.println("연결 실패ㅠㅠ");
			e.printStackTrace();
		}
	}
}
