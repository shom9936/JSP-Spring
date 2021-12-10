<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet"  
	      href="${ pageContext.request.contextPath }/resources/css/visit.css">
<script type="text/javascript" src="${ pageContext.request.contextPath }/resources/js/httpRequest.js"></script>
<script type="text/javascript">
	function checkModify(f){
		if(f.pwd.value == f.c_pwd.value){
			f.action = "modifyForm?vo=${vo}";
			f.submit();
		} else {
			alert('비밀번호가 일치하지 않습니다');
			return;
		}
	}
	
	function checkDelete(f){
		if(f.pwd.value == f.c_pwd.value){
			if(!confirm("삭제하시겠습니까?")){
				return;
			}
			f.action = "delete";
			f.submit();
		} else {
			alert('비밀번호가 일치하지 않습니다');
			return;
		}
		
	}
	
	function modify(f){
		var pwd = f.pwd.value;
		var c_pwd = f.c_pwd.value;
		
		if(pwd != c_pwd){
			alert("비밀번호가 틀립니다.");
			return;
		}
		
		f.action="modifyForm";
		f.submit();
	}
	
	function del(f) {
		var pwd = f.pwd.value;
		var c_pwd = f.c_pwd.value;
		
		if(pwd != c_pwd){
			alert("비밀번호가 틀립니다.");
			return;
		}
		
		if(confirm("정말 삭제하시겠습니까?")== false){
			return;
		}
		
		// Ajax : 부분 동적 페이지
		// Ajax를 통해서 서버로 전송
		var url = "deleteAjax";
		
		// 한글, 특수문자가 들어가 있을 경우를 대비해서 인코딩해서 보낸다.
		var param = "idx=" + encodeURIComponent(f.idx.value);
		
		sendRequest(url, param, resultFn, "GET");
		
	}
	
	/*
		Ajax 요청 시 XMLHttpRequest 객체는 각 상태별로 readyState가 변한다.

		readyState
		0(객체명.UNSENT, 보내지 않음)이었다가,
		
		open메소드를 호출하는 순간 1(객체명.OPEND)
		
		로 바뀌고 send()호출 시 순차적으로
		
		2(객체명.HEADERS_RECEIVED), 
		3(객체명.LOADING), 
		4(객체명.DONE)
		
		으로 바뀐다.
		
		최종적으로 readyState가 4(객체명.DONE)가 된다면 
		
		status
		
		404 - 서버주소 잘못 기입
		401 - apiKey 잘못 기입
		400 - api에서 요구하는 데이터를 잘못보냄
		
		200 , 201 - 데이터 처리 완료

	*/
	
	function resultFn(){
		// 결과를 받을 콜백 메소드
		if(xhr.readyState == 4 && xhr.status == 200){
			var data = xhr.responseText;
			
			if(data == "no"){
				alert("삭제 실패");
				return;
			}
			
			alert("삭제 성공");
			
			location.href="list";
		}
	}
</script>
<title>Insert title here</title>
</head>
<body>
	
	<div align="center">
		<div id="main_box">
			<h1> ::::방명록 리스트:::: </h1>
			<input type="button" value="글쓰기" onclick="location.href='/visit/writeForm'">
			<c:forEach var="vo" items="${list }">
				<table class="visit_box">
					<tr class="type_content">
						<td><pre>${vo.content }</pre><br>
						<c:if test="${vo.filename1 !='no_file' }">
							<img src="resources/upload/${vo.filename1 }" width="200px"><br>
						</c:if>
						<c:if test="${vo.filename2 !='no_file' }">
								<img src="resources/upload/${vo.filename2 }" width="200px">
						</c:if>
						</td>
					</tr>
					<tr class="type_name">
						<td> 작성자 : ${vo.name } (${vo.ip }) </td>
					</tr>
					<tr class="type_regdate">
						<td> 작성일자 : ${vo.regdate } </td>
					</tr>
					<tr>
						<td>
							<form>
								비밀번호:<input type="password" name="pwd">
								<input type="hidden" name="c_pwd" value="${vo.pwd }">
								<input type="hidden" name="idx" value="${vo.idx }">
								<input type="button" value="수정" onclick="checkModify(this.form);"> 
								<input type="button" value="삭제" onclick="del(this.form);">
							</form>
						</td>
					</tr>
				</table>
				<br>
			</c:forEach>
		</div>
	</div>
</body>
</html>