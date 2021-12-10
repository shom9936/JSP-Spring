<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.net.URLDecoder" %>
<%
String id = (String)session.getAttribute("memberId");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> main </title>
</head>
<body>
	<h1> Main </h1>
	<br>
	<% if(id == null) {%>
		<a href="../member/writeForm.jsp" > 회원가입 </a><br>
		<a href="../member/loginForm.jsp" > 로그인 </a>
	<%} else { %>
		<a href="../board/boardWriteForm.jsp"> 글쓰기 </a><br><br>
		<a href="../member/logout.jsp" > 로그아웃 </a>
	<%} %>
</body>
</html>