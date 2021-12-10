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
	// session 속성 설정
	
	if(name != null){
		session.setAttribute("memberName", name);
		session.setAttribute("memberId", id);
		
		response.sendRedirect("loginOK.jsp");
	} else {
		response.sendRedirect("loginFail.jsp");
	}
	%>

</body>
</html>