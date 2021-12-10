package schoolDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import schoolDTO.SchoolDTO;

public class SchoolDAO {
	
	public SchoolDAO() {
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
	
	public Boolean insert(SchoolDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int su = 0;
		
		String sql = "insert into school values(?, ?, ?)";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getValue());
			pstmt.setInt(3, dto.getCode());
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
		if(su > 0) return true;
		else return false;
	} // insert() end
	
	public void select(SchoolDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		String sql;
		
		if(dto == null) sql = "select * from school";
		else if(dto.getName() != null) sql = "select * from school where name like ?";
		else sql = "select * from school where code = ?";
		
		try {
			
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			
			
			if(dto != null) {
				if(dto.getName() != null) {
					pstmt.setString(1, "%"+dto.getName()+"%");
				}
				else {
					pstmt.setInt(1, dto.getCode());
				}
			}
			res = pstmt.executeQuery();
			
			while(res.next()) {
				String name = res.getString("name");
				String value = res.getString("value");
				int code = res.getInt("code");
				String printValue;
				if(code == 1) printValue = "학번 : ";
				else if(code == 2) printValue = "과목 : ";
				else printValue = "부서 : ";
				
				System.out.println(name + "\t" + printValue + value);
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
	
	public boolean update(SchoolDTO dto) {
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int su = 0;
		
		try {
			String sql = "update school set code = ? , value = ? where name = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getCode());
			pstmt.setString(2, dto.getValue());
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
		
		if(su > 0) return true;
		else return false;
	} // update() end
	
	public boolean delete(String name) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int su = 0;
		
		try {
			String sql = "delete school where name = ?";
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
		
		if(su > 0) return true;
		else return false;
	}
	
	public List<SchoolDTO> getList(){
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet res = null;
		ArrayList<SchoolDTO> list = new ArrayList<SchoolDTO>();
		
		try {
			String sql = "select * from school";
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			res = pstmt.executeQuery();
			
			while(res.next()) {
				String name = res.getString("name");
				String value = res.getString("value");
				int code = res.getInt("code");
				
				SchoolDTO dto = new SchoolDTO(name, value, code);
				list.add(dto);
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
		
		if(list.isEmpty()) list = null;
		return list;
	}

}


