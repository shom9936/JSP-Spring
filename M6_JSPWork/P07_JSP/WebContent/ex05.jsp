<%--ex05.jsp --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적</title>
</head>
<body>
	<h1>이름, 성적 입력</h1>
	<br>
	<form action="ex05Pro.jsp" method="post">
		이 름 : <input type="text" name="name"><br><br>
		국 어 : <input type="text" name="kor"><br><br>
		영 어 : <input type="text" name="eng"><br><br>
		수 학 : <input type="text" name="math">
		<br><br>
		<input type="submit" name="전송">
	</form>

</body>
</html>