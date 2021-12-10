<%-- outProc.jsp --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String name = request.getParameter("name");
String age = request.getParameter("age");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 데이터 출력 </title>
</head>
<body>
	<h1> 데이터 출력 </h1>
	<br>
	<%if(name.length() != 0 && age.length() != 0) {%>
		<p><%=name %>, <%=age %> </p>
	<%} else { %>
		<p> 이름  or 나이가 입력되지 않았습니다. </p>
	<%} %>
</body>
</html>