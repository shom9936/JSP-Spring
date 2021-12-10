package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.BoardRecommendVO;
import vo.BoardVO;
import vo.CommentVO;
import vo.ListVO;

public class BoardDAO {
	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<BoardVO> selectList( int start ) {
		int s= start+1;
		int e= start+8;
		ListVO testVO = new ListVO();
		testVO.setStart(s);
		testVO.setEnd(e);
		return sqlSession.selectList("board.selectList", testVO);
	}
	
	public int getTotal() {
		return sqlSession.selectOne("board.selectCount");
	}
	
	public int insert(BoardVO boardVO) {
		return sqlSession.insert("board.boardWrite", boardVO);
	}
	
	public BoardVO selectOne(int seq) {
		return sqlSession.selectOne("board.selectOne", seq);
	}
	
	public int update(BoardVO boardVO) {
		return sqlSession.update("board.boardModify", boardVO);
	}
	
	public int delete(int seq) {
		return sqlSession.delete("board.boardDelete", seq);
	}
	
	public int updateHit(int seq) {
		return sqlSession.update("board.updateHit", seq);
	}
	
	public int updatePlusComment(int seq) {
		return sqlSession.update("board.updatePlusComment", seq);
	}
	
	public int updateMinusComment(int seq) {
		return sqlSession.update("board.updateMinusComment", seq);
	}
	
	public int updateRecomment(int seq) {
		return sqlSession.update("board.updateRecomment", seq);
	}
	
	public int updateDecomment(int seq) {
		return sqlSession.update("board.updateDecomment", seq);
	}
	
	public BoardRecommendVO checkRecomment(BoardRecommendVO boardRecommendVO) {
		return sqlSession.selectOne("board.selectRecomment", boardRecommendVO);
	}
	
	public int insertRecomment(BoardRecommendVO boardRecommendVO) {
		return sqlSession.insert("board.insertRecomment", boardRecommendVO);
	}
	
	public List<BoardVO> selectPopular(){
		return sqlSession.selectList("board.selectPopular");
	}
}