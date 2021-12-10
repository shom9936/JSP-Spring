<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산기</title>
</head>
<body>

<h1> 사칙연산 계산기 </h1>
<br>
<form action="quizCalcPro.jsp" method = "post">
	<input type=text id = data name = num1 > 
	<select name = operation>
		<option value=plus> + </option>
		<option value=substract> - </option>
		<option value=multiply> * </option>
		<option value=divide> / </option>
	</select>
	<input type=text id = data name = num2 >
	<input type="submit" value="계산"> &nbsp; <input type="reset" value="다시 작성">
</form>

</body>
</html>