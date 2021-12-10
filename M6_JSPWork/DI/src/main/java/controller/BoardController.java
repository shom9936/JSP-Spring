package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.board.BoardService;

@Controller // 어노테이션을 통해서 Controller를 지정해야 한다.
public class BoardController {
	
	// root-context.xml은 Controller를 제와한 모든 객체를 만든다.
	
	private BoardService service;
	
	public BoardController() {
		System.out.println("=== BoardController 생성자 ===");
	}
	
	public void setService(BoardService service) {
		this.service = service;
	}
	
	// 사용자가 요청한 url 맵핑
	@RequestMapping("/board/list")
	public String list(Model model) {
		// Model 인터페이스
		// - servlet과 Controller의 중간 매게체
		// - request 영역과 binding 처리가 되어 있다. ( binding : 연결 )
		//	 request 영역과 연결되어 있다
		
		// service를 통해 dao의 selectList를 호출할 수 있다.
		List<String> list = service.selectList();
		
		model.addAttribute("list", list); // request.setAttribute와 비슷한 역할
		
		return "board_list"; // /WEB_INF/views/board_list.jsp
	}
	
}
