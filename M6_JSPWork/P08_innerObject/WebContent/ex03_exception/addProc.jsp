<%-- addProc.jsp --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    errorPage="addException.jsp"%>
<% 
int last = Integer.parseInt(request.getParameter("last")); 

int sum = 0;
for(int i = 0; i<= last; i++) sum+= i;

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> addProc</title>
</head>
<body>
	<h1> 결과 </h1>
	<br>
	<h3> 1 ~ <%=last %> 까지의 합은 <%= sum %></h3>	
</body>
</html>