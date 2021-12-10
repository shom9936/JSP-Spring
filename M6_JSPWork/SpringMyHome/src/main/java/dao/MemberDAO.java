package dao;

import org.apache.ibatis.session.SqlSession;

import vo.MemberVO;

public class MemberDAO {
	SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public MemberVO selectOne(String id) {
		return sqlSession.selectOne("myhome.memberSelectOne",id);
	}
	
	public int insert(MemberVO memberVO) {
		return sqlSession.insert("myhome.memberInsert", memberVO);
	}
	
	public int update(MemberVO memberVO) {
		return sqlSession.update("myhome.memberUpdate", memberVO);
	}
	
	public int delete(MemberVO memberVO) {
		return sqlSession.delete("myhome.memberDelete", memberVO);
	}
	
	public String selectID(String id) {
		return sqlSession.selectOne("myhome.memberSelectID", id);
	}
}
