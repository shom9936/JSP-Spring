<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/join.css?ver=3">
<title>KGU's site</title>
<script type="text/javascript">
	var ckID = false;
	var ckPW = false;
	
	function checkPW(f){
		if(f.password.value == f.rePW.value){
			alert('비밀번호가 일치합니다.');
			ckPW = true;
		} else {
			alert('비밀번호가 일치하지 않습니다.');
		}
	}
	
	function checkID(f){
		if(f.id.value==''){
			alert('아이디를 입력하세요!')
			f.id.focus();
			return;
		}
		
		f.action = 'checkID';
		f.submit();
	}
	
    function checkJoin(f){
    	if(!ckID){
    		alert('아이디를 확인해주세요');
    		f.id.focus();
    		return;

    	}
    	
    	if(!ckPW){
    		alert('비밀번호를 확인해주세요');
    		f.password.focus();
    		return;
    	}
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
		if(f.name.value==''){
			alert('이름을 입력하세요!')
			f.name.focus();
			return;
		}
		if(f.email.value==''){
			alert('이메일을 입력하세요!')
			f.email.focus();
			return;
		}
		if(f.tel1.value==''){
			alert('전화번호를 입력하세요!')
			f.tel1.focus();
			return;
		}
		if(f.tel2.value==''){
			alert('전화번호를 입력하세요!')
			f.tel2.focus();
			return;
		}
		if(f.tel3.value==''){
			alert('전화번호를 입력하세요!')
			f.tel3.focus();
			return;
		}
		f.action = "join";
		f.submit();
	}
</script>

</head>
<body>
	<c:if test="${available}">
		<script>
			ckID = true;
		</script>
	</c:if>

	<div class = "join-form">
		<header class="join-title">
			<h1> <a href="index">Team Fight Tactics</a></h1>
		</header>
		
		<form>
			<div class="input-box">
				<label for="id">아이디</label> <br>
				<input type="text" name="id" value = "${id }" placeholder="&nbsp;&nbsp;아이디">
				<c:choose>
					<c:when test="${available}">
						<button class= "available" onclick="checkID(this.form);" disabled="disabled">사용 가능</button>
					</c:when>
					<c:otherwise>
						<button class= "confirm-box" onclick="checkID(this.form);">사용</button>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="input-box">
				<label for="password"> 비밀번호 </label> <br>
				<input type="password" name="password" value = "${password }" placeholder="&nbsp;&nbsp;비밀번호">		
			</div>
			<div class="input-box">
				<label for="rePW">비밀번호 확인</label> <br>
				<input type="password" name="rePW" placeholder="&nbsp;&nbsp;비밀번호">		
				<button class= "confirm-box" onclick="checkPW(this.form);" type="button">확인</button>
			</div>
			<div class="input-box">
				<label for="name">이름</label> <br>
				<input type="text" name="name" value="${name }" placeholder="&nbsp;&nbsp;이름">
			</div>
			<div class="input-box">
				<label for="email">이메일</label> <br>
				<input type="text" name="email" value="${email}" placeholder="&nbsp;&nbsp;이메일">
			</div>
			<div class="tel-box">
				<label for="tel">전화번호</label> <br>
				<select name="tel1" >
					<option value="010">010</option>
					<option value="011">011</option>
					<option value="017">017</option>
				</select>
				- <input type="text" size="5" maxlength="4" name ="tel2" value="${tel2 }">
				- <input type="text" size="5" maxlength="4" name ="tel3" value="${tel3 }">
			</div>
			<div class="join-box">
				<br>
				<button onclick="checkJoin(this.form);"> 회원가입 </button>
			</div>
		</form>
	</div>
</body>
</html>

