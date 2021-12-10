<%-- ex02.jsp --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<%
Date date = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
String today = sdf.format(date);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> import </title>
<style type="text/css">
p { font-size : 30px; }
</style>
</head>
<body>
	<h1> 오늘 날짜 </h1>
	<br>
	<p> 오늘은 <%=today %> 입니다 </p>
</body>
</html>