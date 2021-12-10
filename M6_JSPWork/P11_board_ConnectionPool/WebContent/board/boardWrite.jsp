<%-- boardWrite.jsp --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "board.dto.BoardDTO" %>
<%@ page import = "board.dao.BoardDAO" %>
<%
request.setCharacterEncoding("utf-8");
String subject = request.getParameter("subject");
String content = request.getParameter("content");

String name = (String)session.getAttribute("memberName");
String id = (String)session.getAttribute("memberId");

BoardDTO boardDTO = new BoardDTO();
boardDTO.setName(name);
boardDTO.setId(id);
boardDTO.setSubject(subject);
boardDTO.setContent(content);

BoardDAO boardDAO = new BoardDAO();
int num = boardDAO.boardWrite(boardDTO);
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 글쓰기 확인 </title>
</head>
<body>
	<% if(num > 0) {%>
		<p> 작성하신 글이 저장되었습니다.</p>
	<%} else { %>
		<p> 저장에 실패했습니다 </p>
	<%} %>
	<br><br>
	<input type="button" value = "main" onclick="location.href='../main/index.jsp'">
</body>
</html>