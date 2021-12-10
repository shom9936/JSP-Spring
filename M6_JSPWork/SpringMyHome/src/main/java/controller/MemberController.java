package controller;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import service.MemberService;
import vo.MemberVO;

@Controller
public class MemberController {
	private MemberService memberService;
	@Autowired
	ServletContext application;
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpSession session;
	
	private static final String VIEW_PATH = "/WEB-INF/views/myHome/";
	
	public MemberController(MemberService memberService) {
		super();
		this.memberService = memberService;
	}
	
	@RequestMapping("/loginForm")
	public String loginForm( @CookieValue(value = "ckid", required = false) Cookie ckid, Model model) {
		String id = (String) session.getAttribute("login");
		boolean checkID = false;
		
		if(ckid != null) {
			id = ckid.getValue();
			checkID = true;
		}
		
		model.addAttribute("id", id);
		model.addAttribute("checkID", checkID);
		return VIEW_PATH + "loginForm.jsp";
	} // loginForm()
	
	@RequestMapping("/login")
	public String login(Model model, String id, String password, String ckid, HttpServletResponse response) {
		MemberVO memberVO = memberService.selectOne(id);
		String msg = "";
		String url = "";
		boolean check = true;
		if(memberVO.getId().equals(id)) {
			session.setAttribute("login", memberVO.getId());
			session.setAttribute("vo", memberVO);
			msg = "로그인에 성공했습니다.";
			
			if(ckid != null) {
				Cookie ck = new Cookie("ckid", id);
				ck.setMaxAge(60 * 60* 24);
				response.addCookie(ck);
			} else {
				Cookie[] cks = request.getCookies();
				if(cks != null) {
					for(Cookie ck : cks) {
						if(ck.getName().equals("ckid")) {
							if(ck.getValue().equals(id)) {
								ck.setMaxAge(0);
								response.addCookie(ck);
								break;
							}
						}
					}
				}
			}
			
		} else {
			msg = "로그인에 실패했습니다.";
			check = false;
		}
		
		url = "index";
		model.addAttribute("check", check);
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		return VIEW_PATH + "result.jsp";
	} // login()
	
	@RequestMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:index";
	} // logout()
	
	@RequestMapping("/joinForm")
	public String joinForm() {
		return VIEW_PATH + "join.jsp";
	} // joinForm()
	
	@RequestMapping("/checkID")
	public String checkID(MemberVO vo, Model model) {
		if(memberService.selectID(vo.getId())) {
			model.addAttribute("check", false);
			model.addAttribute("msg", "이미 존재하는 아이디입니다");
			return VIEW_PATH + "result.jsp";
		}
		model.addAttribute("available", true);
		model.addAttribute("id", vo.getId());
		
		if(vo.getPassword() != null) model.addAttribute("password", vo.getPassword());
		if(vo.getName() != null) model.addAttribute("name", vo.getName());
		if(vo.getEmail() != null) model.addAttribute("email", vo.getEmail());
		if(vo.getTel2() != null) model.addAttribute("tel2", vo.getTel2());
		if(vo.getTel3() != null) model.addAttribute("tel3", vo.getTel3());
		
		return VIEW_PATH + "join.jsp";
	}
	
	@RequestMapping("/join")
	public String join(MemberVO vo, Model model) {
		String msg = "";
		String url = "";
		boolean check = true;
		
		int res = memberService.insert(vo);
		if(res > 0) {
			msg = "회원가입에 성공했습니다!";
			url = "loginForm";
		} else {
			msg = "회원가입에 실패했습니다.ㅠㅠ";
			check = false;
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		model.addAttribute("check", check);
		
		return VIEW_PATH + "result.jsp";
	} // join()
	
	@RequestMapping("/myPage")
	public String myPage(Model model) {
		String id = (String) session.getAttribute("login");
		MemberVO memberVO = memberService.selectOne(id);
		model.addAttribute(memberVO);
		return VIEW_PATH + "myPage.jsp";
	} // mypage()
	
	@RequestMapping("/modify")
	public String modify(MemberVO memberVO, Model model) {
		model.addAttribute("memberVO", memberVO);
		return VIEW_PATH + "modify.jsp";
	} // modify()
	
	@RequestMapping("/update")
	public String update(MemberVO memberVO, Model model) {
		int res = memberService.update(memberVO);
		String msg = "";
		String url="";
		boolean check = true;
		
		if(res > 0) {
			msg = "수정에 성공했습니다!";
			url = "myPage";
			session.setAttribute("vo", memberService.selectOne(memberVO.getId()));
		} else {
			msg = "수정에 실패했습니다.";
			check = false;
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		model.addAttribute("check", check);
		
		return VIEW_PATH + "result.jsp";
	} // update()
	
	@RequestMapping("/identification")
	public String identification(String url, Model model) {
		model.addAttribute("url", url);
		return VIEW_PATH + "identification.jsp";
	} // identification()
	
	@RequestMapping("/delete")
	public String delete(Model model) {
		String msg = "";
		String url="";
		boolean check = true;
		
		MemberVO memberVO = new MemberVO();
		memberVO.setId((String)session.getAttribute("login"));
		
		int res = memberService.delete(memberVO);
		
		if(res > 0) {
			msg = "회원탈퇴에 성공했습니다!";
			url = "index";
			session.invalidate();
		} else {
			msg = "탈퇴에 실패했습니다.";
			check = false;
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		model.addAttribute("check", check);
		
		return VIEW_PATH + "result.jsp";
	} // delete()
}

















