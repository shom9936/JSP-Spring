package Dept.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Dept.VO.DeptVO;
import Dept.service.DeptService;

@Controller
public class DeptController {
	
	public static final String VIEW_PATH = "/WEB-INF/views/dept/";
	
	private DeptService deptService;
	
	public DeptController(DeptService deptService) {
		this.deptService = deptService;
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		List<DeptVO> list = deptService.selectList();
		model.addAttribute("list",list);
		
		return VIEW_PATH + "deptList.jsp";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert() {
		return VIEW_PATH + "deptInsert.jsp";
	}
	
	@RequestMapping("/checkInsert")
	public String checkInsert(Model model, DeptVO deptVO) {
		int num = deptService.insert(deptVO);
		
		boolean check= true;
		String msg = "입력";
		if(num == 0) check = false;
		model.addAttribute("check", check);
		model.addAttribute("msg", msg);
		return VIEW_PATH + "deptResult.jsp";
	}
	
	@RequestMapping("/update")
	public String update(Model model, int deptno) {
		DeptVO deptVO = deptService.selectOne(deptno);
		model.addAttribute("deptVO", deptVO);
		return VIEW_PATH + "deptUpdate.jsp";
	}
	
	@RequestMapping("/checkUpdate")
	public String checkUpdate(Model model, DeptVO deptVO) {
		int num = deptService.update(deptVO);
		
		boolean check= true;
		String msg = "수정";
		if(num == 0) check = false;
		model.addAttribute("check", check);
		model.addAttribute("msg", msg);
		
		return VIEW_PATH + "deptResult.jsp";
	}
	
	@RequestMapping("/delete")
	public String delete(Model model, int deptno) {
		int num = deptService.delete(deptno);
		boolean check= true;
		String msg = "삭제";
		if(num == 0) check = false;
		model.addAttribute("check", check);
		model.addAttribute("msg", msg);
		return VIEW_PATH + "deptResult.jsp";
	}
}
