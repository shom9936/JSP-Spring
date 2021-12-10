<%-- loginOK.jsp --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.net.URLDecoder" %>
<%
// session으로 전달된 데이터 받기
String name = (String)session.getAttribute("memberName");
String id = (String)session.getAttribute("id");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 로그인 성공 </title>
<style type = "text/css">
p {font-size : 20px;}
</style>
</head>
<body>
	<img src="../image/home.jpg" width="300" height = "200" onclick="location.href='../main/index.jsp'">
	<br><br>
	<p><%=name %> 님 안녕하세요...^^ </p>
	<input type="button" value = "main" onclick="location.href='../main/index.jsp'">
	<input type="button" value = "로그아웃" onclick="location.href='logout.jsp'">
</body>
</html>