<%-- loginOK.jsp --%>

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
<title> 로그인 성공 </title>
<style type = "text/css">
p {font-size : 20px;}
</style>
</head>
<body>
	<img src="../image/home.jpg" width="300" height = "200" onclick="location.href='../main/index.jsp'">
	<br><br>
	<p><%=name %> 님 안녕하세요...^^ </p>
</body>
</html>