<!-- boardModifyForm.jsp -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="board.dao.BoardDAO" %>
<%@ page import="board.dto.BoardDTO" %>
<%
int seq = Integer.parseInt(request.getParameter("seq"));
int pg = Integer.parseInt(request.getParameter("pg"));

BoardDAO boardDAO = new BoardDAO();
BoardDTO boardDTO = boardDAO.boardView(seq);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
<script type="text/javascript">
function checkBoardModify(){
	if(document.boardModifyForm.subject.value==""){
		alert("제목을 입력하세요!!");
		document.boardModifyForm.subject.focus();
	}
	else if(document.boardModifyForm.content.value==""){
		alert("내용을 입력하세요!!");
		document.boardModifyForm.content.focus();
	}
	else{
		document.boardModifyForm.submit();
	}
}
</script>
</head>
<body>
	<form action="boardModify.jsp" name= "boardModifyForm" method = "post">
		<input type="hidden" name="seq" value="<%=seq %>">
		<input type="hidden" name="pg" value="<%=pg %>">
		<table border="1" cellpadding="4">
			<tr>
				<td width="50" align="center"> 제 목 </td>
				<td>
					<input type="text" id="subject" name="subject" value=<%=boardDTO.getSubject() %>" style="width:98%">
				</td>
			</tr>
			<tr>
				<td width="50" align="center"> 내 용 </td>
				<td>
					<textarea row="20" cols="60" id="content" name="content" style="width:98%; resize:none; valign=top;">
					<%=boardDTO.getContent() %>
					</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="수정완료" onclick="checkBoardModify()">
					&nbsp;
					<input type="reset" value="다시 작성">
				</td>
			</tr>
		</table>
	</form>
	<br><br>
	<input type="button" value = "main" onclick="location.href='../main/index.jsp'">
</body>
</html>