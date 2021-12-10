<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>

<script type="text/javascript">
    function checkWrite(f){
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
		
		f.action = "boardInsert";
		f.submit();
	}
</script>

<div align = "center">
	<form method="post" enctype = "multipart/form-data">
		<table class="write">
			<thead class="thead">
				<tr>
					<th> 제목 </th>
					<td> <input type="text" name="title"> </td>
				</tr>
			</thead>
			<tr>
				<td class="blank" colspan="2"></td>
			</tr>
			<tbody class="write_tbody">
				<tr>
					<th> 내용 </th>
					<td>
						<textarea rows="20" cols="62" name="content" placeholder="내용을 입력해주세요"> </textarea>
					</td>
				</tr>
			</tbody>
			<tr>
				<td class="blank" colspan="2"></td>
			</tr>
			<tr class="write_tfoot">
				<th> 파일 </th>
				<td><input type="file" name="photo"> </td>
			</tr>
			<tr>
				<td class="blank" colspan="2"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"> <input type="button" value="완료" class = "complite" onclick="checkWrite(this.form);"> </td>
			</tr>
		</table>
	</form>
</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp" %>