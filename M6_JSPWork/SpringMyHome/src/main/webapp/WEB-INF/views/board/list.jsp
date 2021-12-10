<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>

<div align="center" >
	<table class = "list">
	  <tr>
	  	<th class="no"> No. </th>
				<th class="title">제목</th>
				<th class="name">글쓴이</th>
				<th class="logdate">작성일</th>
				<th class="hit">조회</th>
				<th class="recomment">추천</th>
	  </tr>
	  
  	<c:choose>
  		<c:when test="${list != null }">
  			<c:forEach var = "vo" items="${list }">
  				<tr>
		  			<td class="no"> ${vo.seq }</td>
		  			<c:if test="${login != null}">
		  				<td class="title"> <a href="view?seq=${vo.seq }&start=${start}"> ${vo.title } [ ${vo.comment_cnt } ]</a></td> 
		  			</c:if>
		  			<c:if test="${login == null }"> <td> ${vo.title } [ ${vo.comment_cnt } ]</td> </c:if>
		  			<td class="name"> ${vo.id }</td>
		  			<td class="logdate"> ${vo.logtime }</td>
		  			<td class="hit"> ${vo.hit }</td>
		  			<td class="recomment"> ${vo.recomment_cnt } </td>
	  			</tr>
  			</c:forEach>
  		</c:when>
  		<c:otherwise>
  			<td colspan="5" align="center"> 작성된 글이 없습니다. </td>
  		</c:otherwise>
  	</c:choose>
	  
	</table>
	<c:if test="${login != null }">
		<div style="text-align: right; margin-right: 150px;">
			<button class="list_write" type="button" onclick="location.href = 'write'"> 글쓰기 </button>
		</div>
	</c:if>
	<br>
	<div class = "pageList">
		<c:if test="${start >= 16 }">
			<a href="list?start=${start-16}" class="otherPage"> &lt;</a>
		</c:if>
		<c:if test="${start >= 8 }">
			<a href="list?start=${start-8}" class="otherPage"> ${nowPage -1 }</a>
		</c:if>
		<a href="#" class="currentPage">${nowPage }</a>
		<c:if test="${start +8 < total }">
			<a href="list?start=${start+8}" class="otherPage"> ${nowPage  +1 }</a>
		</c:if>
		<c:if test="${start +16 < total }">
			<a href="list?start=${start+16}" class="otherPage"> &gt;</a>
		</c:if>
	</div>
</div>


<%@ include file="/WEB-INF/views/layout/footer.jsp" %>