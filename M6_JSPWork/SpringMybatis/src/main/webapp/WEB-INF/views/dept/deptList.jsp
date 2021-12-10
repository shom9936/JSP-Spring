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
        <table border="1" align="center">
                <tr>
                        <th>부서번호</th>
                        <th>부서명</th>
                        <th>위치</th>
                        <th></th>
                </tr>

                 <c:forEach var="vo" items="${ list }">
                        <tr>
                                <td>${ vo.deptno }</td>
                                <td>${ vo.dname }</td>
                                <td>${ vo.loc }</td>
                                <td>
                                	<button onclick="location.href='/db/update?deptno=${vo.deptno}'">수정</button>
                                	<button onclick="location.href='/db/delete?deptno=${vo.deptno}'">삭제</button>
                                </td>
                        </tr>
                </c:forEach>
                
                <tr>
                	<td colspan="4" align = "right"> <button onclick="location.href='/db/insert'">입력</button> </td>
                </tr>
        </table>

</body>
</html>