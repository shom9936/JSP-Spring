<%-- boardDelete.jsp --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.dao.BoardDAO" %>
<%
int seq = Integer.parseInt(request.getParameter("seq"));

BoardDAO boardDAO = new BoardDAO();
int num = boardDAO.boardDelete(seq);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 글 삭제 확인 </title>
<script type="text/javascript">
window.onload=function(){
	alert("삭제 성공!!");
	location.href="boardList.jsp?pg=1";
}
</script>
</head>
<body>

</body>
</html>