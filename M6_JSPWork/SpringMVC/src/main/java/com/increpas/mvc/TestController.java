package com.increpas.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


// @Component - @Controller, @Service, @Repository 들의 부모 클래스
// 명확성을 위해서 Component보다 역할에 맞는 어노테이션을 적어준다.

//@Component
@Controller
public class TestController {
	
	// 실행 경로를 참조할 수 있는 상수를 지정한다.
	public static final String VIEW_PATH="/WEB-INF/views/test/";
	
	public TestController() {
		System.out.println("--- TestController() --- 생성자 호출");
	}
	
	@RequestMapping("/test")
	public String test(Model model, HttpServletRequest request) {
		
		 String[] msg = new String[] {
                 "안녕하세요",
                 "Hello",
                 "Xin chào.",
                 "おはようございます"                
		 };
		 
		 String ip = request.getRemoteAddr();
		 request.setAttribute("ip", ip);
		
		model.addAttribute("msg", msg); // model을 통해 배열을 request 영역에 저장한다.
		return VIEW_PATH + "test.jsp"; // /WEB-INF/views/test/test.jsp로 포워딩
	}
	
	@RequestMapping("/test2")
	public ModelAndView test2(HttpServletRequest request) {
		
		// ModelAndView
		// - 데이터와 뷰 정보를 하나의 객체로 포장해서 전달한다.
		
		// mv에 뷰 정보 담는 메소드
		ModelAndView mv = new ModelAndView(/*VIEW_PATH + "test2.jsp"*/);
		mv.setViewName(VIEW_PATH + "test2.jsp");
		
		
		 String[] msg = new String[] {
                 "안녕하세요",
                 "Hello",
                 "Xin chào.",
                 "おはようございます"                
		 };
		 
		 String ip = request.getRemoteAddr();
		 
		 mv.addObject("ip", ip);
		 mv.addObject("method","test2() 메소드를 호출함");
		 mv.addObject("msg", msg);
		
		return mv; // /WEB-INF/views/test/test.jsp로 포워딩
	}
}
