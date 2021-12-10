package Dept.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import Dept.VO.DeptVO;

public class DeptDAO {
	
	// SqlSession
	// -SqlSessionTemplate 클래스가 SqlSession을 상속받았다.
	private SqlSession sqlSession;
	
	// setter injection
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<DeptVO> selectList() {
		List<DeptVO> list = sqlSession.selectList("dept.deptList");
		return list;
	}
	
	public DeptVO selectOne(int deptno) {
		DeptVO vo = sqlSession.selectOne("dept.deptOne", deptno);
		return vo;
	}
	
	public int insert(DeptVO deptVO) {
		int num = sqlSession.insert("dept.deptInsert", deptVO);
		return num;
	}
	
	public int update(DeptVO deptVO) {
		int num = sqlSession.update("dept.deptUpdate", deptVO);
		return num;
	}
	
	public int delete(int deptno) {
		int num = sqlSession.delete("dept.deptDelete", deptno);
		return num;
	}
	
	public int maxNo() {
		int max = sqlSession.selectOne("dept.deptMax");
		return max;
	}
	
}
