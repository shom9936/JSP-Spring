<%-- ex01_var.jsp --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     isELIgnored = "false"%>
<%-- core 태그 라이브러리를 사용하기 위해서 선언해야합니다. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>변수 설정</title>
</head>
<body>
	<h1> 변수 설정 </h1>
	<br>
	<%-- <c:set> : 변수 설정  --%>
	<c:set var="num1" value="1" />
	<c:set var="num2"> 10 </c:set>
	<c:set var="num3" value="${ 30 }" />
	<c:set var="num4" value="40" scope="request"/>
	<h3>
	num1 : ${ num1 } <br>
	num2 : ${ num2 } <br>
	num3 : ${ num3 } <br>
	num4 : ${ num4 } <br>
	</h3>
	
	<h1> 변수 삭제 </h1>
	<c:set var="name" value="test" />
	<h3> name : ${ name }</h3>
	<%-- <c:remove> : 변수(속성) 삭제 --%>
	<c:remove var="name"/>
	<h3> name : ${ name }</h3>

</body>
</html>