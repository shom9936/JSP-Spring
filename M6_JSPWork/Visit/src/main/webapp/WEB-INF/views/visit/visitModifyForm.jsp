<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function send(f){
		if(f.content.value==''){
			alert('내용을 입력하세요!');
			f.content.focus();
			return;
		}
		f.action = "modify";
		f.submit();
	}
</script>
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<form method="post" enctype = "multipart/form-data">
			<table align="center" border="1">
				<tr>
					<th> 이름 </th>
					<td> 
						${vo.name }
						<input type="hidden" name="name" value="${vo.name }"> 
						<input type="hidden" name="pwd" value="${vo.pwd }">
						<input type="hidden" name="idx" value="${vo.idx }">
					</td>
				</tr>
				<tr>
					<th> 내용 </th>
					<td> 
						<textarea rows="20" cols="62" name="content" placeholder="${vo.content }"></textarea>
					</td>
				</tr>
				<tr>
					<th> 사진1 </th>
					<td> <input type="file" name="photo"> </td>
				</tr>
				<tr>
					<th> 사진2 </th>
					<td> <input type="file" name="photo"> </td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" value="수정" onclick="send(this.form);">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>