<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/join.css?ver=2">
<title>KGU's site</title>
<script type="text/javascript">
    function checkModify(f){
		
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
		f.action = "update";
		f.submit();
	}
</script>
</head>
<body>
	<div class = "join-form">
		<header class="join-title">
			<h1> Team Fight Tactics </h1>
		</header>
		
		<form>
			<div class="input-box">
				<label for="id">아이디</label> <br>
				<input type="text" name="id" value="${vo.id }" disabled="disabled">
				<input type="hidden" value = "${vo.id }" name = "id">
			</div>
			<div class="input-box">
				<label for="name">이름</label> <br>
				<input type="text" name="name" value="${vo.name }" disabled="disabled">
			</div>
			<div class="input-box">
				<label for="email">이메일</label> <br>
				<input type="text" name="email" value="${vo.email}">
			</div>
			<div class="tel-box">
				<label for="tel">전화번호</label> <br>
				<!-- <input id = "tel" type="text" name="id" placeholder="&nbsp;&nbsp;전화번호"> -->
				<select name="tel1" >
					<option value="010">010</option>
					<option value="011">011</option>
					<option value="017">017</option>
				</select>
				- <input type="text" size="5" maxlength="4" name ="tel2" value="${vo.tel2}">
				- <input type="text" size="5" maxlength="4" name ="tel3" value="${vo.tel3}">
			</div>
			<div class="modify-box">
				<br> 
				<button class="back" type="button" onclick="location.href='myPage'"> 뒤로 가기</button>
				<button class="modify" type="button" onclick="checkModify(this.form);"> 수정 </button>
			</div>
		</form>
	</div>
</body>
</html>
