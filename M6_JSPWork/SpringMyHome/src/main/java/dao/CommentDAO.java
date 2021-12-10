package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.CommentRecommendVO;
import vo.CommentVO;

public class CommentDAO {
	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<CommentVO> selectList(int seq) {
		return sqlSession.selectList("comment.commentSelect", seq);
	}
	
	public int insert(CommentVO commentVO) {
		return sqlSession.insert("comment.commentInsert", commentVO);
	}
	
	public int delete(int seq) {
		return sqlSession.delete("comment.commentDelete", seq);
	}
	
	public int recommend(int seq) {
		return sqlSession.update("comment.commentUp", seq);
	}
	
	public int decommend(int seq) {
		return sqlSession.update("comment.commentDown", seq);
	}
	
	public CommentRecommendVO checkRecomment(CommentRecommendVO commentRecommendVO) {
		return sqlSession.selectOne("comment.commentReSelect", commentRecommendVO);
	}
	
	public int recommentInsert(CommentRecommendVO commentRecommendVO) {
		return sqlSession.insert("comment.commentReInsert", commentRecommendVO);
	}
	
}
