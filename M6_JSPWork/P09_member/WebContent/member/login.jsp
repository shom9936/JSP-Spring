<%-- login.jsp --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "member.dao.MemberDAO" %>
<%@ page import =  "java.net.URLEncoder" %>
<%--
URLEncoder class
- 웹 브라우저의 주소에 일반 문자열을 웹에서 사용되는 형식으로 변환합니다.
 --%>
<%
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");

MemberDAO memberDAO = new MemberDAO();
String name = memberDAO.login(id, pwd);
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 로그인 확인</title>
</head>
<body>

	<%
	if(name != null){
		response.sendRedirect("loginOK.jsp?name="+URLEncoder.encode(name, "utf-8") + "&id="+id);
	} else {
		response.sendRedirect("loginFail.jsp");
	}
	%>

<%--  
	<%if(name != null) {%>
		<p> <%= name %> 님이 로그인하셨습니다. </p>
	<%} else { %>
		<p> 아이디 또는 비밀번호가 틀렸습니다. </p>
	<%} %>

--%>
</body>
</html>