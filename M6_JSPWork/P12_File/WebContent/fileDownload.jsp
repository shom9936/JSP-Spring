<%-- fileDownload.jsp --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.*" %>
<%@ page import = "java.net.URLEncoder" %>
<%
request.setCharacterEncoding("utf-8");
String fileName = request.getParameter("fileName");

// 실제 폴더
String realFolder = request.getServletContext().getRealPath("/storage");

// 파일 객체 생성
File file = new File(realFolder, fileName);

fileName = "attachment;fileName=" + new String(URLEncoder.encode(fileName,"utf-8")).replaceAll("\\+", " ");
response.setHeader("Content-Disposition", fileName);
response.setHeader("Content-Length", file.length() + "");

out.clear();
out = pageContext.pushBody(); // 기존 jsp 객체 out의 스트림을 지우고 출력해야 오류가 생기지 않습니다.

// 요청된 파일을 읽어들여서 클라이언트에 저장
BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());

byte[] b = new byte[(int)file.length()];
bis.read(b,0,b.length);
bos.write(b);

bis.close();
bos.close();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 파일 다운로드 </title>
</head>
<body>

</body>
</html>