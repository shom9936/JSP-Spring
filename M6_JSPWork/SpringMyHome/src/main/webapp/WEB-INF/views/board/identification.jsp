<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>

<script type="text/javascript">
	function checkPW(f){
		if(f.ckPW.value == ''){
			alert('비밀번호를 입력하세요');
			return;
		}
		if(f.ckPW.value == f.password.value){
			location.href = 'boardDelete';
			f.action = "boardDelete";
			f.submit();
		} else {
			alert('비밀번호가 일치하지않습니다');
		}
	}
</script>

<form>
	<table>
		<tr>
			<th> ID </th>
			<td> ${vo.id } </td>
		</tr>
		<tr>
			<th> PW </th>
			<td>
				<input type="password" name = "ckPW">
				<input type="hidden" value="${vo.password }" name="password">
				<input type="hidden" value="${seq }" name = "seq">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="button" value="삭제" onclick="checkPW(this.form);">
			</td>

		</tr>
	</table>
</form>
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>