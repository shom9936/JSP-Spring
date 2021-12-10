package service;

import java.util.List;

import dao.CommentDAO;
import vo.CommentRecommendVO;
import vo.CommentVO;

public class CommentService {
	CommentDAO commentDAO;
	
	public void setCommentDAO(CommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}
	
	public List<CommentVO> selectList(int seq){
		return commentDAO.selectList(seq);
	}
	
	public int insert(CommentVO commentVO) {
		return commentDAO.insert(commentVO);
	}
	
	public int delete(int seq) {
		return commentDAO.delete(seq);
	}
	
	public int recommend(int seq) {
		return commentDAO.recommend(seq);
	}
	
	public int decommend(int seq) {
		return commentDAO.decommend(seq);
	}
	
	public CommentRecommendVO checkRecomment(CommentRecommendVO commentRecommendVO) {
		return commentDAO.checkRecomment(commentRecommendVO);
	}
	
	public int recommentInsert(CommentRecommendVO commentRecommendVO) {
		return commentDAO.recommentInsert(commentRecommendVO);
	}
	
}
