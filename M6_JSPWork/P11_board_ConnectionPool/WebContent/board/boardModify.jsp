<%-- boardModify.jsp --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.dao.BoardDAO" %>
<%@ page import="board.dto.BoardDTO" %>
<%
request.setCharacterEncoding("utf-8");
int seq = Integer.parseInt(request.getParameter("seq"));
int pg = Integer.parseInt(request.getParameter("pg"));
String subject = request.getParameter("subject");
String content = request.getParameter("content");

BoardDTO boardDTO = new BoardDTO();
boardDTO.setSeq(seq);
boardDTO.setSubject(subject);
boardDTO.setContent(content);

BoardDAO boardDAO = new BoardDAO();
int num = boardDAO.boardModify(boardDTO);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정 결과</title>
<script type="text/javascript">
window.onload=function(){
	<%if(num > 0) { %>
		alert("수정되었습니다.");
		location.href="boardList.jsp?pg=<%=pg%>";
	<%} else { %>
		alert("수정 실패 ㅠㅠ");
		history.back(-1);
		
	<% } %>
}
</script>
</head>
<body>

</body>
</html>