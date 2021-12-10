package com.increpas.param;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import VO.PersonVO;

@Controller
public class ParamController {

	public static final String VIEW_PATH = "/WEB-INF/views/person/";
	
	@RequestMapping("/insert_form")
	public String insertForm() {
		
		return VIEW_PATH + "insert_Form.jsp";
	}
	
	// 낱개로 받기
	@RequestMapping("/insert1")
	public String insert1(Model model, @RequestParam("name")String name1, int age, String tel) {
		// name, age, tel : 파라미터로 자동으로 넘어온다.
		// @RequestParam("name")String name1 : 넘어오는 매개변수의 이름을 다르게 받을때 사용
		
		PersonVO vo= new PersonVO(name1, age, tel);
		
		model.addAttribute("vo", vo);
		
		return VIEW_PATH + "insert_result.jsp";
		
	}
	
	@RequestMapping("/insert2")
	public String insert2(Model model, PersonVO vo) {
		
		model.addAttribute("vo", vo);
		
		return VIEW_PATH + "insert_result.jsp";
	}
	
}
