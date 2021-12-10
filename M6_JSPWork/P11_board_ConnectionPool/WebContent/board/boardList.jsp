<%-- boardList.jsp --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "board.dao.BoardDAO" %>
<%@ page import = "board.dto.BoardDTO" %>
<%@ page import = "java.util.ArrayList" %>
<%
int pg = Integer.parseInt(request.getParameter("pg"));

// 페이지당 글 목록
int article = 3; // 페이지당 글 수
int currentPage = pg; // 현재 페이지
int startNum = (currentPage - 1) * article + 1;
int endNum = startNum + article - 1;

BoardDAO boardDAO = new BoardDAO();
ArrayList<BoardDTO> list = boardDAO.boardList(startNum, endNum);

// 페이징
int totalArticle = boardDAO.getTotalArticle(); // 전체 글 수
int totalPage = (totalArticle - 1) / article + 1;

int block = 3; // 페이지 블록
int startPage = (currentPage - 1) / block * block + 1;
int endPage = startPage + block - 1;
if(endPage > totalPage) endPage = totalPage;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 글 목록 </title>
<script type="text/javascript">
function isLogin(seq){
	<%if(session.getAttribute("memberId") == null) { %>
		alert("로그인 하세요!!");
	<%} else { %>
		location.href="boardView.jsp?seq="+seq+"&pg="+<%=pg%>;
	<% } %>
}
</script>
<style type="text/css">
#paging_block{
	width: 800px; float : center; text-align: center;
}
#paging{
	color: black; text-decoration: none;
}
#currentPaging{
	color: red; text-decoration: underline;
}
</style>
</head>
<body>
	<table border="1" width="800" cellpadding="5">
		<tr>
			<td width="50" align="center"> 글번호 </td>
			<td width="300" align="center"> 제 목 </td>
			<td width="100" align="center"> 작성자 </td>
			<td width="100" align="center"> 작성일 </td>
			<td width="50" align="center"> 조회수 </td>
		</tr>
	<% for(BoardDTO boardDTO : list) { %>
		<tr>
		<%-- c:if 사용해서 글 없을시 작성한 글이 없습니다 출력 --%>
			<td align = "center"> <%=boardDTO.getSeq()%></td>
			<td align = "center"> 
				<a href="#" id = "subjectArticle" onclick = "isLogin(<%=boardDTO.getSeq() %>)">
				<%=boardDTO.getSubject()%> 
				</a>
			</td>
			<td align = "center"> <%=boardDTO.getName()%></td>
			<td align = "center"> <%=boardDTO.getLogtime()%></td>
			<td align = "center"> <%=boardDTO.getHit()%></td>
		</tr>
	<%} %>
	</table>
	<!-- 페이지 번호 -->
	<div id = "paging_block">
	<%if(startPage > block)  {%>
		[ <a href="boardList.jsp?pg=<%=startPage-1 %>" id = "paging"> 이전 </a> ]
	<%} %>
	
	<%for(int i = startPage; i<= endPage ; i++) {%>
		<%if( i == pg ) { %>
			[ <a href="boardList.jsp?pg=<%=i %>" id = "currentPaging"> <%=i %> </a> ]
		<%} else {%>
			[ <a href="boardList.jsp?pg=<%=i %>" id = "paging"> <%=i %> </a> ]
		<%} %>
	<%} %>
	
	<%if(endPage < totalPage) {%>
		[ <a href="boardList.jsp?pg=<%=endPage+1 %>" id = "paging"> 다음 </a> ]
	<%} %>
	</div><br><br>
	<input type="button" value = "main" onclick="location.href='../main/index.jsp'">
</body>
</html>