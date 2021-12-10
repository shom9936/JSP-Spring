<%@page import="dto.PersonDTO"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//root-context.xml에 객체를 선언하면 그 객체는
	//Spring Container(applicationScope) 안에 객체들이 저장된 상태이다.
	// -> 싱글톤으로 만들어진다.
	//Spring Containe에서 참조값을 얻어와야 한다.
	
	//applicationScope는 서블릿 영역이므로 스프링에서 바로 접근 불가.
	
	WebApplicationContext wc = WebApplicationContextUtils.getWebApplicationContext(application);

	PersonDTO p1 = (PersonDTO)wc.getBean("p1");
	
	PersonDTO p2 = wc.getBean("p2", PersonDTO.class);
	
	PersonDTO p3 = (PersonDTO)wc.getBean("p3");
	
	pageContext.setAttribute("p1", p1);
	
	pageContext.setAttribute("p2", p2);
	
	pageContext.setAttribute("p3", p3);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<p> ${p1.name } / ${p1.age } / ${p1.tel }</p>
		<p> ${p2.name } / ${p2.age } / ${p2.tel }</p>
		<p> ${p3.name } / ${p3.age } / ${p3.tel }</p>
	</div>
</body>
</html>