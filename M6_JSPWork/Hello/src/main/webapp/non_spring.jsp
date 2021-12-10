<%@ page import = "dto.PersonDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	PersonDTO p1 = new PersonDTO();
	p1.setName("고건우");
	p1.setAge(20);
	p1.setTel("010-3322-5555");
	
	PersonDTO p2 = new PersonDTO("홍길동", 30, "010-1111-2222");
	
	pageContext.setAttribute("p1", p1);
	pageContext.setAttribute("p2", p2);
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
	</div>
</body>
</html>