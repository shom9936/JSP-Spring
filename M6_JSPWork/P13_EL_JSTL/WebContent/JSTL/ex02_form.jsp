<%-- ex02_form.jsp --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     isELIgnored = "false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력 정보</title>
</head>
<body>
	<form action="ex02_res.jsp" method="post">
		이름 : <input type="text" name="userName"><br>
		나이 : <input type="text" name="userAge"><br>
		<input type="submit" value="전송">
	</form>
</body>
</html>