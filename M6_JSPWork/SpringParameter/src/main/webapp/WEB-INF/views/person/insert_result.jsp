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
        <div align="center">
                이름 : ${vo.name }<br>
                나이 : ${vo.age }<br>
                전화번호 : ${vo.tel }<br>
                <a href="insert_form" style="text-decoration: none;">돌아가기</a>
        </div>
</body>
</html>