<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		제목 : ${vo.title }<br>
		<a href="resources/upload/${vo.filename1 }" download>
		<img src="resources/upload/${vo.filename1 }" width="200px"></a><br>
		<img src="resources/upload/${vo.filename2 }" width="200px"><br>
		<a href="form">다시 등록</a>
	</div>
</body>
</html>