package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import board.dto.BoardDTO;

public class BoardDAO {
	
	private DataSource ds;
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet res;

	public BoardDAO() {
		try {
			// InitialContext 객체 생성 ( JNDI : Java Naming and Directory Interface )
			// > javax.naming
			Context context = new InitialContext();
			// Context 클래스의 lookup() 메서드는 "java:comp/env/jdbc/oracle"를 가지고 Datasource 객체를 구합니다.
			// - lookup() 메서드를 사용해서 naming 서비스에서 자원을 찾습니다.
			// - JNDI 의 이름은 java:comp/env 에 등록되어 있습니다.
			ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
		} catch(NamingException e) {
			System.out.println("로딩 실패!!");
			e.printStackTrace();
		}
	}
	
	// 글쓰기
	public int boardWrite(BoardDTO boardDTO) {
		
		String sql = "insert into board values(board_seq.nextval, ?, ?, ?, ?, 0, sysdate)";
		int num = 0;
		
		try {
			// DataSource의 getConnection() 메서드를 사용해서 커넥션 풀로부터 커넥션 객체 가져오기
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, boardDTO.getId());
			pstmt.setString(2, boardDTO.getName());
			pstmt.setString(3, boardDTO.getSubject());
			pstmt.setString(4, boardDTO.getContent());
			num = pstmt.executeUpdate();
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
		return num;
	}
	
	public ArrayList<BoardDTO> boardList (int start, int end){
		
		String sql = "select seq, id , name, subject, content, hit, to_char(logtime, 'YYYY.MM.DD') as logtime from" 
					+ "(select rownum rn, tt.*"
					+ "from (select * from board order by seq desc) tt)"
					+ "where rn>=? and rn <= ?";
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		BoardDTO boardDTO = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			res = pstmt.executeQuery();
			
			while(res.next()) {
				boardDTO = new BoardDTO();
				boardDTO.setSeq(res.getInt("seq"));
				boardDTO.setId(res.getString("id"));
				boardDTO.setName(res.getString("name"));
				boardDTO.setSubject(res.getString("subject"));
				boardDTO.setContent(res.getString("content"));
				boardDTO.setHit(res.getInt("hit"));
				boardDTO.setLogtime(res.getString("logtime"));
				
				list.add(boardDTO);
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
		
		return list;
	} // boardlist() end
	
	// 전체 글 수
	public int getTotalArticle() {
		
		String sql = "select count(*) from board";
		int total = 0;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			res = pstmt.executeQuery();
			if(res.next()) {
				total = res.getInt(1);
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
		
		return total;
	} // getTotalArticle() end
	
	// 조회수 증가
	public int updateHit(int seq) {
		
		String sql = "update board set hit=hit+1 where seq=?";
		int num = 0;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,  seq);
			num = pstmt.executeUpdate();
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
		
		return num; 
	} // updateHit() end
	
	// 글 내용 가져오기
	public BoardDTO boardView(int seq) {
		
		String sql = "select * from board where seq = ?";
		BoardDTO boardDTO = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, seq);
			res = pstmt.executeQuery();
			
			if(res.next()) {
				boardDTO = new BoardDTO();
				boardDTO.setSeq(res.getInt("seq"));
				boardDTO.setId(res.getString("id"));
				boardDTO.setName(res.getString("name"));
				boardDTO.setSubject(res.getString("subject"));
				boardDTO.setContent(res.getString("content"));
				boardDTO.setHit(res.getInt("hit"));
				boardDTO.setLogtime(res.getString("logtime"));
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
		
		return boardDTO;
	} // boardView() end;
	
	public int boardModify(BoardDTO boardDTO) {
		String sql = "update board set subject = ? , content=? where seq=?";
		int num = 0;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  boardDTO.getSubject());
			pstmt.setString(2,  boardDTO.getContent());
			pstmt.setInt(3, boardDTO.getSeq());
			num = pstmt.executeUpdate();
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
		
		return num; 
	}
	
	// 글 삭제 
	public int boardDelete(int seq) {
		String sql = "delete from board where seq = ?";
		int num = 0;		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, seq);
			num = pstmt.executeUpdate();
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
		
		return num;
	} // boardDelete() end
}













