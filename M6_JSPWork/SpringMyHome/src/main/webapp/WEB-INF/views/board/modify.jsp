<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>

<script type="text/javascript">
    function checkModify(f){
		if(f.title.value==''){
			alert('제목을 입력하세요!')
			f.title.focus();
			return;
		}
		if(f.content.value==''){
			alert('내용을 입력하세요!')
			f.password.focus();
			return;
		}
		if(f.photo.value==''){
			if(confirm('파일을 첨부하지않으시겠습니까?') == false){
				f.filename.focus();
				return;
			}
		}
		
		f.action = "boardUpdate";
		f.submit();
	}
</script>

<div align = "center">
	<form method="post" enctype = "multipart/form-data">
		<table border = "1">
			<tr>
				<th> 제목 </th>
				<td> <input type="text" name="title" value="${boardVO.title }"> </td>
			</tr>
			<tr>
				<th> 내용 </th>
				<td>
					<textarea rows="20" cols="62" name="content" placeholder="내용을 입력해주세요" >${boardVO.content }</textarea>
				</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td> <input type="file" name="photo"> </td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="hidden" name="seq" value="${boardVO.seq }">
					<input type="button" value="수정" onclick="checkModify(this.form);">
				</td>
			</tr>
		</table>
	</form>
</div>
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>