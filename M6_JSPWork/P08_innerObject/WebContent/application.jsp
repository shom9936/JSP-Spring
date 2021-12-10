<%-- application.jsp --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> application </title>
</head>
<body>
	<table border="1">
		<tr>
			<td> JSP 버전</td>
			<td><%=application.getMajorVersion() %>, <%=application.getMinorVersion() %></td>
		</tr>
		<tr>
			<td>웹 어플리케이션 파일시스템 경로</td>
			<td><%=application.getRealPath("/") %></td>
		</tr>
	</table>


</body>
</html>