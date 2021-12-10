<%-- fileForm.jsp --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
</head>
<body>
	<form action="fileUpload.jsp" method = "post" enctype = "multipart/form-data">
		<table border="1">
			<tr>
				<td width = "50"> 제 목 </td>
				<td><input type="text" name="subject" size="50"> </td>
			</tr>
			<tr>
				<td width = "50"> 내 용 </td>
				<td>
					<textarea name = "content" rows="20" cols="50" style="resize:none"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan = "2"> <input type="file" name="upload" size="50"></td>
			</tr>
			<tr>
				<td colspan = "2" align="center"> <input type="submit" value="upload">
			</tr>
		</table>
	</form>
</body>
</html>