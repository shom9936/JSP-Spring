<%-- ex03Pro.jsp --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int num1 = Integer.parseInt(request.getParameter("num1"));
	int num2 = Integer.parseInt(request.getParameter("num2"));
	
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
p {font-size : 30px; }
</style>
</head>
<body>
	<h1> 두 수의 합</h1>
	<br>
	<p> <%= num1 %> + <%= num2 %> = <%= num1+num2 %> </p>
</body>
</html>