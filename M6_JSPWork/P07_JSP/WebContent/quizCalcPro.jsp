<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산 결과</title>
</head>
<body>

<%
	double num1 = Double.parseDouble(request.getParameter("num1"));
	double num2 = Double.parseDouble(request.getParameter("num2"));
	String op = request.getParameter("operation");

	
	if(op.equals("plus")) out.println(num1 + " + " + num2 + " = " + (num1+num2));
	else if(op.equals("substract")) out.println(num1 + " - " + num2 + " = " + (num1-num2));
	else if(op.equals("multiply")) out.println(num1 + " * " + num2 + " = " + (num1*num2));
	else out.println(num1 + " / " + num2 + " = " + (num1/num2));
	
%>

</body>
</html>