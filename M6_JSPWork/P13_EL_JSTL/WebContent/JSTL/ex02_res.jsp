<%-- ex02_res.jsp --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     isELIgnored = "false"%>
<%-- core 태그 라이브러리를 사용하기 위해서 선언해야합니다. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
request.setCharacterEncoding("utf-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 입력 결과 </title>
</head>
<body>

	<h1> if </h1>
	<c:set var="name"> ${param.userName } </c:set>
	<c:set var="age"> ${param.userAge } </c:set>
	<h3>${ name } 님의 나이 : ${ age }</h3>
	
	<c:if test="${age >= 20 }">
		<h3> 성인 입니다.</h3>
	</c:if>
	<c:if test="${age < 20 }">
		<h3> 미성년자 입니다.</h3>
	</c:if>
	<br>
	
	<c:choose>
		<c:when test=" ${age >= 20 }">
			<h3> 성인 </h3>
		</c:when>
		<c:when test="${age >= 8 }">
			<h3> 학생 </h3>
		</c:when>
		<c:otherwise>
			<h3> 미취학 아동 </h3>
		</c:otherwise>
	
	</c:choose>
	
</body>
</html>