<%-- forward.jsp --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> forward </title>
</head>
<body>
	<h1>forward</h1>
	<br>
	<p> forward.jsp -> forwardPro.jsp -> forwardResult.jsp 페이지로 이동합니다. <br>
	    forward로 이동하면 데이터를 공유합니다.<br>
	</p>
	
	<br>
	<input type="button" value="forward" onclick="location.href='forwardPro.jsp'">

</body>
</html>