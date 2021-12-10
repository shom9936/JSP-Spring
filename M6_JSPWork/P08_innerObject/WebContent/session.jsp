<%-- session.jsp --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// session 유지 시간
session.setMaxInactiveInterval(10);
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session</title>
</head>
<body>
	<h1> session </h1>
	<br>
	<p> isNew() : <%=session.isNew() %> </p>
	<p> 생성 시간     : <%=session.getCreationTime() %> </p>
	<p> 최종 접속 시간 : <%= session.getLastAccessedTime() %>
	<p> 세션 ID  : <%= session.getId() %> </p>
	
</body>
</html>