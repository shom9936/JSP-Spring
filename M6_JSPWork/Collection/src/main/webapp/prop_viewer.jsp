<%@page import="java.util.Properties"%>
<%@page import="ex.MyProp"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	WebApplicationContext wc = WebApplicationContextUtils.getWebApplicationContext(application);

	MyProp myProp = (MyProp)wc.getBean("myPropBean");
	
	Properties prop = myProp.getProp();
	
	request.setAttribute("prop", prop);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>MyProp의 내용</p>
	<ul>
		<c:forEach var="key" items="${prop.propertyNames() }">
		<!-- propertyNames() -> keySet과 비슷함 -->
			<li>${key } - ${prop[key] }</li>
		</c:forEach>
	</ul>
</body>
</html>


















