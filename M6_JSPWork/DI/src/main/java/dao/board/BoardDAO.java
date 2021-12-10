package dao.board;

import java.util.ArrayList;
import java.util.List;

import dao.DAO;

public class BoardDAO implements DAO{
	@Override
	public int insert(Object ob) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public List selectList() {
		List<String> list = new ArrayList<String>();
		list.add("참외");
		list.add("수박");
		list.add("사과");
		list.add("메론");
		return list;
	}
	
	@Override
	public int update(Object ob) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int delete(int i) {
		// TODO Auto-generated method stub
		return 0;
	}
}
