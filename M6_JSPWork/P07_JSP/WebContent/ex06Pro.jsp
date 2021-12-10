<%-- ex06.jsp --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<% int dan = Integer.parseInt(request.getParameter("dan")); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>단 출력</title>
</head>
<body>
	<table border = "1" width = "700">
		<tr align = "center" >
			<td colspan="2"> <%=dan %> 단 </td>
		</tr>
		<% for(int i = 1; i<=9; i++){ %>
			<tr align="center">
				<td width="400"> <%=dan %> x <%=i %></td><td width="300"><%=dan*i %></td>
			</tr>
		<% } %>
		<%-- 태그를 연속적으로 실행할 수 있다. --%>
	</table>
	<br>
	
</body>
</html>