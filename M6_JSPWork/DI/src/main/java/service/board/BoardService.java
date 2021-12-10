package service.board;

import java.util.List;

import dao.DAO;
import dao.board.BoardDAO;
import service.Service;

public class BoardService implements Service {

	private DAO dao;
	
	public BoardService() {}
	
	public BoardService(BoardDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public List selectList() {
		return dao.selectList();
	}

}
