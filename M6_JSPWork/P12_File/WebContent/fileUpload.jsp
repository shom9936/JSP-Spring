<%-- fileUpload.jsp --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.File" %>
<%@ page import = "java.net.URLEncoder" %>
<%@ page import = "com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import = "com.oreilly.servlet.MultipartRequest" %>
<%
// 실제 폴더
String realFolder = request.getServletContext().getRealPath("/storage");

// 파일 업로드 객체
// new MultipartRequest ( request , 파일 저장 경로 , 파일 크기 , 인코딩 방식, 파일 정책);
// - new DefaultFileRenamePolicy() : 업로드 시 똑같은 파일이 있을 경우, 기존 파일 이름에 숫자를 덧붙여서 저장합니다.
MultipartRequest mr = 
	new MultipartRequest(request, realFolder, 5*1024*1024, "utf-8" , new DefaultFileRenamePolicy());

String subject = mr.getParameter("subject");
String content = mr.getParameter("content");

// 업로드 한 실제 파일명
String orginalFileName = mr.getOriginalFileName("upload");
// 서버에 저장된 파일명
String fileName = mr.getFilesystemName("upload");
// 파일 객체
File file = mr.getFile("upload");

long fileSize = 0;
if(file != null) fileSize = file.length();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 파일 업로드 확인 </title>
</head>
<body>
	<h3> 업로드 완료 </h3>
	<br>
	<ul>
		<li>제 목 : <%=subject %></li>
		<li>내 용 : <%=content %></li>
		<li>파 일 : 
			<a href="fileDownload.jsp?fileName=<%=URLEncoder.encode(orginalFileName, "utf-8") %>">
				<%=orginalFileName %> </a> &nbsp; <%=fileName %>
		</li>
		<li>크 기 : <%=fileSize %> </li>
	</ul>
	
</body>
</html>