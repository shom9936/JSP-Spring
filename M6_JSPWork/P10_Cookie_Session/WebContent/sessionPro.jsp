<%-- sessionPro.jsp --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String userid = request.getParameter("id");
String userpw = request.getParameter("pwd");

session.setAttribute("id", userid);
session.setAttribute("pwd", userpw);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> session 확인</title>
</head>
<body>
	<h1> session 속성 및 사용 </h1>
	<br>
	<p> ID, PW session 속성을 설정했습니다. </p>
	<p> userid 속성 값 : <%=(String)session.getAttribute("id") %> </p>
	<p> userpw 속성 값 : <%=(String)session.getAttribute("pwd") %> </p>

</body>
</html>