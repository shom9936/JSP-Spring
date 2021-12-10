<%-- calcResult.jsp --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
double num1 = Double.parseDouble(request.getParameter("num1"));
double num2 = Double.parseDouble(request.getParameter("num2"));
String opt = request.getParameter("opt");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 계산 결과 </title>
<style type="text/css">
p { font-size: 20px; }
</style>
</head>
<body>
	<%
	double result = 0;
	switch(opt){
	case "+":
		result = num1 + num2; break;
	case "-":
		result = num1 - num2; break;
	case "*":
		result = num1 * num2; break;
	case "/":
		result = num1 / num2; break;
	}
	%>
	<p> <%=num1 %> <%=opt %> <%=num2 %> <%=result %></p>
</body>
</html>
















