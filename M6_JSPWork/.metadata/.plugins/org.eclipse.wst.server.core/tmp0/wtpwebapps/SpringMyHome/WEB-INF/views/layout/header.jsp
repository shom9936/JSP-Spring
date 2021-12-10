<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/basic.css?ver=4">
<title>KGU's site</title>
</head>
<body>
	<div align="center">
		<header class="header">
			<div class="mainTitle">
				<h1>
					<a href="index">Team Fight Tactics</a>
				</h1>
				<c:choose>
					<c:when test="${login == null }">
						<button class = "login" onclick="location.href='loginForm'">로그인</button>
						<button class = "join" onclick="location.href='joinForm'">회원가입</button>
					</c:when>
					<c:otherwise>
						<button class = "logout" onclick="location.href='logout'">로그아웃</button>
						<button class = "myPage" onclick="location.href='myPage'">내 정보</button>
					</c:otherwise>
				</c:choose>
				
			</div>
		</header>
		<nav>
			<ul>
				<li> <a href="index" class="${li_index }">홈</a></li>
				<li> <a href ="list" class="${li_list }">자유 게시판</a> </li>
				<li> <a href ="#">공략</a> </li>
				<li> <a href ="#">시너지</a> </li>
				<li> <a href ="#">아이템</a> </li>
				<li> <a href ="#">패치노트</a> </li>
			</ul>
		</nav>
		<div class="main">
		