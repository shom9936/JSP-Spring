<%@page import="java.util.Set" %>
<%@page import="ex.MySet" %>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	WebApplicationContext wc = WebApplicationContextUtils.getRequiredWebApplicationContext(application);

	MySet mySet = (MySet)wc.getBean("mySetBean");
	
	Set<String> set = mySet.getSet();
	
	request.setAttribute("set", set);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fieldset style="display: inline;">
		<legend>MySet의 내용</legend>
		<ul>
			<c:forEach var="d" items="${set }">
				<li> ${d } </li>
			</c:forEach>
		</ul>
	</fieldset>
</body>
</html>