<%-- elTest3.jsp --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 비교 연산자 </title>
</head>
<body>
	<h1> 비교 연산자 </h1>
	<br>
	<h2>
	\${ 10 == 10} : ${ 10 == 10 } <br>
	\${ 10 eq 10 } : ${ 10 eq 10 } <br>
	\${ "hello" == "hello"} : ${ "hello" == "hello" } <br>
	\${ "hello" eq "hello" } : ${ "hello" eq "hello" } <br>
	
	\${ 20 != 10 } : ${ 20 != 10 } <br>
	\${ 20 ne 10 } : ${ 20 ne 10 } <br>
	
	\${ 10 < 10 } : ${ 10 < 10 } <br>
	\${ 10 lt 10 } : ${ 10 lt 10 } <br>
	
	\${ 20 > 3} : ${ 20 > 3 } <br>
	\${ 20 gt 3} : ${ 20 gt 3 } <br>
	
	\${ 10 <= 2 } : ${ 10 <= 2 } <br>
	\${ 10 le 2 } : ${ 10 le 2 } <br>
	
	\${ 10 >= 5 } : ${ 10 >= 5 } <br>
	\${ 10 ge 5 } : ${ 10 ge 5 } <br>
	
	
	</h2>
</body>
</html>