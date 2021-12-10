<%-- member/writeForm.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 회원가입 </title>
<script type="text/javascript" src="../script/memberScript.js"></script>
</head>
<body>
	<form action="write.jsp" name="writeForm" method="post">
		<table border="1" cellpadding="4">
			<tr>
				<td width="120" align="center"> 이 름 </td>
				<td width="300"><input type="text" name="name"></td>
			</tr>
			<tr>
				<td align="center"> 아이디 </td>
				<td>
					<input type="text" name="id">
					<input type="button" value="중복체크" onclick="checkId()">
				</td>
			</tr>
			<tr>
				<td align="center"> 비밀번호 </td>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td align="center"> 비밀번호 확인 </td>
				<td><input type="password" name="repwd"></td>
			</tr>
			<tr>
				<td align="center"> 성 별 </td>
				<td>
					<input type="radio" name="gender" value="M" checked><label for="genderM"> 남 </label>
					<input type="radio" name="gender" value="F"><label for="genderF"> 여 </label>
				</td>
			</tr>
			<tr>
				<td align="center"> E-mail </td>
				<td>
					<input type="text" name="email" size="10"> @
					<select name="domain">
						<option value="naver.com"> naver </option>
						<option value="gmail.com"> gmail </option>
						<option value="doum.net"> daum </option>
					</select>
				</td>
			</tr>
			<tr>
				<td align="center"> 핸드폰 </td>
				<td>
					<input type="text" name="tel1" size="3" maxlength="3"> - 
					<input type="text" name="tel2" size="3" maxlength="4"> - 
					<input type="text" name="tel3" size="3" maxlength="4">
				</td>
			</tr>
			<tr>
				<td align="center"> 주 소 </td>
				<td><input type="text" name="addr" size="50"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="회원가입" onclick="checkWrite()"> &nbsp;
					<input type="reset" value="다시작성">
				</td>
			</tr>

		</table>
	</form>
</body>
</html>






















