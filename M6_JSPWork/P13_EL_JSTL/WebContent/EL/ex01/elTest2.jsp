<%-- elTest2.jsp --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored = "false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 표현 언어 산술 연산자</title>
</head>
<body>
	<h1> 표현 언어 산술 연산자 </h1>
	<br>
	<h2>
	\${ 10 + 10} : ${ 10 + 10 } <br>
	\${ 20 - 10 } : ${ 20 - 10 } <br>
	\${ 10 * 10 } : ${ 10 * 10 } <br>
	\${ 10 / 3 } : ${ 10 / 3 } <br>
	\${ 10 div 3 } : ${ 10 div 3 } <br>
	\${ 10 % 4 } : ${ 10 % 4 } <br>
	\${ 10 mod 4 } : ${ 10 mod 4 } <br>
	
	</h2>
</body>
</html>