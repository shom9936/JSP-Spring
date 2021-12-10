<%-- calcInput.jsp --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 계산 입력 </title>
</head>
<body>
	<form action="calcResult.jsp" method="post">
		<input type="text" name="num1">
		<select name="opt">
			<option value="+"> + </option>
			<option value="-"> - </option>
			<option value="*"> x </option>
			<option value="/"> / </option>
		</select>
		<input type="text" name="num2">
		<br><br>
		<input type="submit" value="계산">
	</form>
</body>
</html>
















