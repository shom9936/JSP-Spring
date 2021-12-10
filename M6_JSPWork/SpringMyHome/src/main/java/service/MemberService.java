package service;

import dao.MemberDAO;
import vo.MemberVO;

public class MemberService {
	MemberDAO memberDAO;

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	public MemberVO selectOne(String id) {
		return memberDAO.selectOne(id);
	}
	
	public boolean selectID(String id) {
		String check = memberDAO.selectID(id);
		if(check != null) return true;
		else return false;
	}
	
	public int insert(MemberVO memberVO) {
		return memberDAO.insert(memberVO);
	}
	
	public int update(MemberVO memberVO) {
		return memberDAO.update(memberVO);
	}
	
	public int delete(MemberVO memberVO) {
		return memberDAO.delete(memberVO);
	}
	
}
