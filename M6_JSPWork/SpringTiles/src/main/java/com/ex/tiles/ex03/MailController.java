package com.ex.tiles.ex03;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableAsync
public class MailController {
	@Autowired
	private MailService mailService;
	
	@RequestMapping("/sendMail")
	public void sendSimpleMail(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		mailService.sendMail("shom23@naver.com", "테스트 메일", "안녕하세요 테스트메일입니다.");
		mailService.sendPreConfiguredMail("테스트 메일입니다.");
		out.print("메일을 보냈습니다!");
		

	}
	
	@RequestMapping("/sendHTMLMail")
	public void sendMail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf8");
		PrintWriter out = response.getWriter();
		StringBuffer sb = new StringBuffer();
		
		sb.append("<!DOCTYPE html><html><body>");
		sb.append("<meta http-equiv='Content-Type' content='text/html; charset=euc-kr'>");
 		sb.append("<h1>"+"제품소개"+"<h1><br>");
 		sb.append("신간 도서를 소개합니다.<br><br>");
 		sb.append("<a href='http://www.kyobobook.co.kr/product/detailViewKor.laf?ejkGb=KOR&mallGb=KOR&barcode=9788956746425&orderClick=LAG&Kc=#N'>");
 		sb.append("<img  src='http://image.kyobobook.co.kr/images/book/xlarge/425/x9788956746425.jpg' /> </a><br>");
 		sb.append("</a>");
 		sb.append("<a href='http://www.kyobobook.co.kr/product/detailViewKor.laf?ejkGb=KOR&mallGb=KOR&barcode=9788956746425&orderClick=LAG&Kc=#N'>상품보기</a>");
 		sb.append("</body></html>");
 		
 		String str = sb.toString();
 		mailService.sendMail("shom23@naver.com", "신상품을 소개합니다.", str);
 		out.print("<h1>메일을 보냈습니다!</h1>");
		
	}
	
}
