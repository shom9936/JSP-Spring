<%-- ex04.jsp --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> control </title>
<style type="text/css">
td { font-size : 30px}
.datain{
	font-size:30px;
}
</style>
</head>
<body>
	<h1>이름 , 나이 입력</h1>
	<br>
	<form action="ex04Pro.jsp" method="post">
		<table border="1">
			<tr>
				<td> 이름 : </td><td><input type="text" class="datain" name="name"></td>
			</tr>
			<tr>
				<td> 나이 : </td><td><input type="text" class="datain"name="age"></td>
			</tr>
			<tr>
				<td colspan="2" align = "center" >
					<input type="submit" class="datain" value="입력 완료"> 
				</td>
			</tr>
		</table>
	</form>
</body>
</html>