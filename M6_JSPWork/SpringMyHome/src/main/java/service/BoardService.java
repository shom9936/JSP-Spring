package service;

import java.util.List;

import dao.BoardDAO;
import vo.BoardRecommendVO;
import vo.BoardVO;

public class BoardService {
	BoardDAO boardDAO;
	
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	
	public List<BoardVO> selectList( int start ){
		return boardDAO.selectList( start );
	}
	
	public int getTotal() {
		return boardDAO.getTotal();
	}
	
	public int insert(BoardVO boardVO) {
		return boardDAO.insert(boardVO);
	}
	
	public BoardVO selectOne(int seq) {
		return boardDAO.selectOne(seq);
	}
	
	public int update(BoardVO boardVO) {
		return boardDAO.update(boardVO);
	}
	
	public int delete(int seq) {
		return boardDAO.delete(seq);
	}
	
	public int updateHit(int seq) {
		return boardDAO.updateHit(seq);
	}
	
	public int updatePlusComment(int seq) {
		return boardDAO.updatePlusComment(seq);
	}
	
	public int updateMinusComment(int seq) {
		return boardDAO.updateMinusComment(seq);
	}
	
	public int updateRecomment(int seq) {
		return boardDAO.updateRecomment(seq);
	}
	
	public int updateDecomment(int seq) {
		return boardDAO.updateDecomment(seq);
	}
	
	public BoardRecommendVO checkRecomment(BoardRecommendVO boardRecommendVO) {
		return boardDAO.checkRecomment(boardRecommendVO);
	}
	
	public int insertRecomment(BoardRecommendVO boardRecommentVO) {
		return boardDAO.insertRecomment(boardRecommentVO);
	}
	
	public List<BoardVO> selectPopular(){
		return boardDAO.selectPopular();
	}
}
