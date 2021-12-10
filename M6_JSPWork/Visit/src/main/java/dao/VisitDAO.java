package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.VisitVO;

public class VisitDAO {
	private SqlSession sqlSession;

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<VisitVO> selectList(){
		List<VisitVO> list = sqlSession.selectList("visit.visitList");
		return list;
	}
	
	public int insert(VisitVO vo) {
		return sqlSession.insert("visit.visitInsert", vo);
	}
	
	public VisitVO selectOne(int idx) {
		return sqlSession.selectOne("visit.visitSelectOne", idx);
	}
	
	public int update(VisitVO vo) {
		return sqlSession.update("visit.visitUpdate", vo);
	}
	
	public int delete(int idx) {
		return sqlSession.delete("visit.visitDelete", idx);
	}
}
