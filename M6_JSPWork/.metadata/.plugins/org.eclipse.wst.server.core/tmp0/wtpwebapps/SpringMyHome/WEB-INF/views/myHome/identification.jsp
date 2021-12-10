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
	function checkPW(f){
		if(f.ckPW.value == ''){
			alert('비밀번호를 입력하세요');
			return;
		}
		if(f.ckPW.value == f.password.value){
			location.href = '${url}';
		} else {
			alert('비밀번호가 일치하지않습니다');
		}
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
				<input id = "id" type="text" name="id" value = "${vo.id }" disabled="disabled">
	
			</div>
			<div class="input-box">
				<input type="password" name="ckPW" placeholder="&nbsp;&nbsp;비밀번호">
				<input type="hidden" value="${vo.password }" name="password">	
			</div>
			<br><br>
			<span>
				<span class="login-button">
					<c:if test="${url == 'delete' }"> 
						<input type="button" value="탈퇴" onclick="checkPW(this.form);">
					</c:if>
					<c:if test="${url == 'modify' }"> 
						<input type="button" value="수정" onclick="checkPW(this.form);">
					</c:if>
				</span>
			</span>
		</form>
	</div>
</body>
</html>