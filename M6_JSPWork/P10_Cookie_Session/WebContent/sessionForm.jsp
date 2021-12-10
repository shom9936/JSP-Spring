<%-- sessionForm.jsp --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> sessionForm</title>
</head>
<body>
	<form action="sessionPro.jsp" method = "post">
		<label> ID : </label><input type="text" name = "id"><br>
		<label> PW : </label><input type="password" name = "pwd">
		<br><br>
		<input type="submit" value="세션 확인">
	</form>


</body>
</html>