<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.net.URLDecoder" %>
<%
String name = null;
String id = null;

Cookie[] cookies = request.getCookies();
if(cookies!= null){
	for(int i = 0; i<cookies.length; i++){
		if(cookies[i].getName().equals("memberName")){
			name = URLDecoder.decode(cookies[i].getValue(), "utf-8");
		}
		else if(cookies[i].getName().equals("memberId")){
			id = cookies[i].getValue();
		}
	}
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> main </title>
</head>
<body>
	<h1> Main </h1>
	<br>
	<% if(name == null) {%>
		<a href="../member/writeForm.jsp" > 회원가입 </a> <br>
		<a href="../member/loginForm.jsp" > 로그인 </a>
	<%} else { %>
		<a href="../member/logout.jsp" > 로그아웃 </a>
	<%} %>
</body>
</html>