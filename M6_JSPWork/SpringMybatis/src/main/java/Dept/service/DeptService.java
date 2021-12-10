package Dept.service;

import java.util.List;

import Dept.VO.DeptVO;
import Dept.dao.DeptDAO;

public class DeptService {
	private DeptDAO deptDao;
	
	public DeptService(DeptDAO deptDao) {
		this.deptDao = deptDao;
	}
	
	// 데이터 처리
	public List<DeptVO> selectList(){
		return deptDao.selectList();
	}
	
	public DeptVO selectOne(int deptno) {
		return deptDao.selectOne(deptno);
	}
	
	public int insert(DeptVO deptVO) {
		int deptno = deptDao.maxNo() + 1;
		deptVO.setDeptno(deptno);
		return deptDao.insert(deptVO);
	}
	
	public int update(DeptVO deptVO) {
		return deptDao.update(deptVO);
	}
	
	public int delete(int deptno) {
		return deptDao.delete(deptno);
	}
}
