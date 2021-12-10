package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import member.dto.MemberDTO;

public class MemberDAO {
	
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "dbtest";
	private String pw = "a1111";
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet res;

	public MemberDAO() {
		try {
			Class.forName(driver);
			System.out.println("로딩 성공!!");
		} catch(ClassNotFoundException e) {
			System.out.println("로딩 실패!!");
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		try {
			con = DriverManager.getConnection(url, user, pw);
			System.out.println("연결 성공!!");
		} catch (Exception e) {
			System.out.println("연결 실패 ㅠㅠ");
			e.printStackTrace();
		}	
		return con;
	}
	
	// 회원가입
	public int write(MemberDTO memberDTO) {
		
		String sql = "insert into member values(?,?,?,?,?,?,?,?, sysdate)";
		int num = 0;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getName());
			pstmt.setString(2, memberDTO.getId());
			pstmt.setString(3, memberDTO.getPwd());
			pstmt.setString(4, memberDTO.getGender());
			pstmt.setString(5, memberDTO.getEmail());
			pstmt.setString(6, memberDTO.getDomain());
			pstmt.setString(7, memberDTO.getTel());
			pstmt.setString(8, memberDTO.getAddr());
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return num;
		
	} // write() end
	
	
	// 중복 확인
	public boolean isExistId(String id) {
		
		String sql = "select * from member where id=?";
		boolean exist = false;   // 결과 ( true : 사용중, false : 미사용 )
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			res = pstmt.executeQuery();
			if(res.next()) {
				exist = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(res != null) res.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return exist;
		
	} // isExistId() end
	
	public String login(String id, String pwd) {
		
		String sql = "select * from member where id=? and password=?";
		String name = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setNString(2, pwd);
			res = pstmt.executeQuery();
			
			if(res.next()) {
				name = res.getString("name");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(res != null) res.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return name;
	} // login() end
	
	// 회원 정보 가져오기
	public MemberDTO getMember(String id) {
		
		String sql = "select * from member where id = ?";
		MemberDTO memberDTO = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			res = pstmt.executeQuery();
			
			if(res.next()) {
				memberDTO = new MemberDTO();
				memberDTO.setName(res.getString("name"));
				memberDTO.setId(res.getString("id"));
				memberDTO.setPwd(res.getString("pwd"));
				memberDTO.setGender(res.getString("gender"));
				memberDTO.setTel(res.getString("tel"));
				memberDTO.setEmail(res.getString("email"));
				memberDTO.setDomain(res.getString("domain"));
				memberDTO.setAddr(res.getString("addr"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(res != null) res.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return memberDTO;
	}
	
	// 회원 정보 수정
	public int modify(MemberDTO memberDTO) {
		
		String sql = "update member set name=?, pwd=?, gender=?, email=?, domain=?, tel=?,addr=? where id = ?";
		int num = 0;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getName());
			pstmt.setString(2, memberDTO.getPwd());
			pstmt.setString(3, memberDTO.getGender());
			pstmt.setString(4, memberDTO.getEmail());
			pstmt.setString(5, memberDTO.getDomain());
			pstmt.setString(6, memberDTO.getTel());
			pstmt.setString(7, memberDTO.getAddr());
			pstmt.setString(8, memberDTO.getId());
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return num;
		
	} // write() end
}
































