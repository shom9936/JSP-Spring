<%--quiz.Gugudan.jsp --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단 전단 출력</title>
</head>
<body>
	<table border="1" width="450">
		</tr>
		<% for(int i = 1; i<=9; i++){ %>
			<tr align="center">
				<%for(int j = 2; j<=9 ; j++){%>
				<td width="50"> <%=j%>*<%=i %>=<%=i*j%></td>
				<% } %>
			</tr>
		<% } %>
	</table>


</body>
</html>