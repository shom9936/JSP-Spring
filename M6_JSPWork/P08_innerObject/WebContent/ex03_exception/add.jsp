<%-- add.jsp --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 입력 </title>
</head>
<body>
	<h1> 1 ~ n 까지의 합 </h1>
	<br>
	<form action="addProc.jsp" method = "get">
		1부터 <input type="text" name = "last"> 까지의 합 <br>
		<input type = "submit" value="계산">
	</form>
</body>
</html>