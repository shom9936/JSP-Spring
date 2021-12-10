<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/login.css?ver=2">
<title>KGU's site</title>
<script type="text/javascript">
    function checkLogin(f){
		if(f.id.value==''){
			alert('아이디를 입력하세요!')
			f.id.focus();
			return;
		}
		if(f.password.value==''){
			alert('비밀번호를 입력하세요!')
			f.password.focus();
			return;
		}
		
		f.action = "login";
		f.submit();
	}
</script>
</head>
<body>
	<div class = "login-form">
		<header class="login-title">
			<h1> <a href="index">Team Fight Tactics</a></h1>
		</header>
		
		<form>
			<div class="input-box">
				<input id = "id" type="text" name="id" value="${id }" placeholder="&nbsp;&nbsp;아이디">
	
			</div>
			<div class="input-box">
				<input id="password" type="password" name="password" placeholder="&nbsp;&nbsp;비밀번호">		
			</div>
			<br><br>
			<span>
				<span class="check-id">
					<c:choose>
						<c:when test="${checkID }">
							<input type="checkbox" name="ckid" value="x" checked = "checked">
						</c:when>
						<c:otherwise>
							<input type="checkbox" name="ckid" value="x">
						</c:otherwise>
					</c:choose>
					<font size="3pt"> 아이디 기억하기 </font>
				</span>
				<span class="login-button">
					<input type="button" value = "로그인" onclick="checkLogin(this.form);">
				</span>
			</span>
		</form>
	</div>
</body>
</html>