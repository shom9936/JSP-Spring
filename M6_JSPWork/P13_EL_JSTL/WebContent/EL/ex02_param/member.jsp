<%-- member.jsp --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored = "false"%>
<%
request.setCharacterEncoding("utf-8");
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");
String name = request.getParameter("name");
String email = request.getParameter("email");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 회원 정보 출력 </title>
</head>
<body>

	<table border = "1" align = "center">
		<tr bgcolor="#D9E5FF">
			<th width = "20%"> 아이디 </td>
			<th width = "20%"> 비밀번호</td>
			<th width = "20%"> 이름</td>
			<th width = "20%"> E-mail</td>
		</tr>
		<tr align = "center">
			<td><%=id %></td>
			<td><%=pwd %></td>
			<td><%=name %></td>
			<td><%=email %></td>
		</tr>
		<%--param 객체를 이용해서 getParameter() 메서드를 사용하지 않고 회원 정보를 출력합니다.--%>
		<tr align = "center">
			<td>${ param.id }</td>
			<td>${ param.pwd }</td>
			<td>${ param.name }</td>
			<td>${ param.email }</td>
		</tr>
	</table>

</body>
</html>