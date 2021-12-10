<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/myPage.css?ver=2">
<title>KGU's site</title>
<script type="text/javascript">
	function modify(){
		alert('본인 확인을 위해 비밀번호를 한번 더 입력해주세요');
		location.href='identification?url=modify';
	}
	
	function del(){
		alert('본인 확인을 위해 비밀번호를 한번 더 입력해주세요');
		location.href='identification?url=delete';
	}
</script>
</head>
<body>
	<div class = "myPage">
		<header class="myPage-title">
			<h1> <a href="index">Team Fight Tactics</a> </h1>
		</header>
		
		<table class = "info">
			<tr>
				<th> ID </th>
				<td> ${vo.id }</td>
			</tr>
			<tr>
				<th> Name</th>
				<td> ${vo.name }</td>
			</tr>
			<tr>
				<th> E-mail</th>
				<td> ${vo.email }</td>
			</tr>
			<tr>
				<th> TEL</th>
				<td> ${vo.tel1 } - ${vo.tel2 } - ${vo.tel3 }</td>
			</tr>
		</table>
		
		<span class="button">
			<input type="button" value="수정" onclick="modify();"> 
			<input type="button" value="탈퇴" onclick="del();">
		</span>
	</div>
</body>
</html>