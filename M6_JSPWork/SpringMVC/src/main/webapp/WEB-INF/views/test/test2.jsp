<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>
		TEST2 페이지로 접근합니다.
	</p>
	<p>
		${method }
	</p>
	<p>
		[${ip }]님이 요청한 나라별 인사말
	</p>
	
	<c:forEach var="i" items="${msg }">
		<li> ${i }</li>
	</c:forEach>
</body>
</html>