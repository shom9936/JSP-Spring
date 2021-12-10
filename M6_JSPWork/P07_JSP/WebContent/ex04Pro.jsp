<%-- ex04Pro.jsp --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
get 방식은 한글이 깨지지 않지만 post 방식은 깨집니다.
request.setCharacterEncoding("utf-8");를 사용하면 post 방식에도 한글이 깨지지 않습니다.
 --%>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	String adult = "";
	if(age > 19) adult = "성인";
	else adult = "미성년자";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과 </title>
</head>
<body>
	<h1>성인, 미성년자 </h1>
	<br>
	<p> <%=name %>님의 나이는 <%=age %>입니다. </p>
	<br>
	<p> 당신은 <%=adult %>입니다.</p>

</body>
</html>