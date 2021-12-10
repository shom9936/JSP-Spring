<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="checkInsert" method="post">
		<table border="1" align="center">
			<tr>
				<th> 부서명 </th>
				<td> <input type="text" name="dname"> </td>
			</tr>
			<tr>
				<th> 위치 </th>
				<td> <input type="text" name="loc"> </td>
			</tr>
			<tr>
				<td colspan="2"> <input type="submit" value="입력"> </td>
			</tr>
		</table>
	</form>
</body>
</html>