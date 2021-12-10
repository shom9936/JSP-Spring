<%-- member.jsp --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored = "false"%>
<%
request.setCharacterEncoding("utf-8");
%>
<%-- 회원정보를 저장 할 bean 생성 , id : 객체 명, class : import 역할 --%>
<jsp:useBean id = "m" class="el.MemberBean"></jsp:useBean>
<%-- 전송된 회원 정보를 bean 속성에 설정  --%>
<jsp:setProperty name="m" property="*"/>
<%--
빈(bean) 속성 접근
${ 빈이름.속성이름 }
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 회원 정보 출력 </title>
</head>
<body>

	<table border = "1" align = "center">
		<tr bgcolor="#D9E5FF">
			<th width = "20%"> 아이디 </th>
			<th width = "20%"> 비밀번호</th>
			<th width = "20%"> 이름</th>
			<th width = "20%"> E-mail</th>
		</tr>
		<%-- Bean id와 속성 이름을 이용한 회원 정보 출력 --%>
		<tr align = "center">
			<td>${ m.id }</td>
			<td>${ m.pwd }</td>
			<td>${ m.name }</td>
			<td>${ m.email }</td>
		</tr>
	</table>

</body>
</html>