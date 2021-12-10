package service;

import java.util.List;

import dao.VisitDAO;
import vo.VisitVO;

public class VisitService {
	private VisitDAO visitDAO;

	public VisitService() {}
	public VisitService(VisitDAO visitDAO) {
		this.visitDAO = visitDAO;
	}
	
	public List<VisitVO> selectList(){
		return visitDAO.selectList();
	}
	
	public int insert(VisitVO vo) {
		return visitDAO.insert(vo);
	}
	
	public VisitVO selectOne(int idx) {
		return visitDAO.selectOne(idx);
	}
	
	public int update(VisitVO vo) {
		return visitDAO.update(vo);
	}
	
	public int delete(int idx) {
		return visitDAO.delete(idx);
	}
	
	public String deleteAjax(int idx) {
		int res = visitDAO.delete(idx);
		String result = "no"; // 삭제 실패시
		
		if(res != 0) {
			result = "yes"; // 삭제 성공시
		} 
		return result;
	}
	public String updateAjax(VisitVO vo) {
		int res = visitDAO.update(vo);
		String result = "no"; // 수정 실패시
		
		if(res != 0) {
			result = "yes"; // 수정 성공시
		} 
		return result;
	}
	
}
