<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>

<script type="text/javascript" src="${ pageContext.request.contextPath }/resources/js/ajax.js"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath }/resources/js/boardView.js"></script>
<div class="boardView">
	<br>
	<div class="boardInfo">
		<div class="boardTitle"> ${boardVO.title } </div>
		<div class="boardWriterInfo">
			작성자 : ${boardVO.name } &nbsp;&nbsp;&nbsp;&nbsp;
			작성일: ${boardVO.logtime } &nbsp;&nbsp;&nbsp;&nbsp;
			조회수 : ${boardVO.hit }
		</div>
	</div>
	<hr>
	<div class="boardContent">
		<pre>${boardVO.content }</pre>
	</div>
	<div class="boardFile">
		<c:if test="${boardVO.filename != 'no_file' }">
			<font> 첨부파일 : </font> <a href="fileDownload?seq=${boardVO.seq }&filename=${boardVO.filename}">${boardVO.filename }</a>
		</c:if>
	</div>
	
	<div class="boardViewrecomment" align="center">
		<form>
			<input type="hidden" name="seq" value="${boardVO.seq }">
			<input type="hidden" name="id" value="${login }">
			<input type="hidden" name="up_down">
			<button type="button" class = "up" onclick="recommendBoard(this.form);">
				<img src="${pageContext.request.contextPath }/resources/img/good.png" width = "50px" height="50px"><br>${boardVO.recomment_cnt }
			</button>
			<button type="button" class = "down" onclick="decommendBoard(this.form);">
				<img src="${pageContext.request.contextPath }/resources/img/bad.png" width = "50px" height="50px"><br>${boardVO.decomment_cnt }
			</button>
		</form>
	</div>
	
	<table class="comment">
		<tr>
			<td align="left" colspan="2"> 답변 ${cnt } </td>
		</tr>
		<c:if test="${!isEmpty }">
			<c:forEach  var="vo_c" items = "${list }">
				<tr>
					<td width="620px">
						${vo_c.id } (${vo_c.logtime }) <br>
						<pre> ${vo_c.content } </pre>
					</td>
					<td width="80px" align = "center">
						<c:choose>
							<c:when test="${vo_c.id == login }">
								<form>
									<input type="hidden" name="board_no" value="${boardVO.seq}" >
									<input type="hidden" name="seq" value="${vo_c.seq }">
									<input type="button" value="삭제" onclick="deleteComment(this.form);">
								</form>
							</c:when>
							<c:otherwise>
								${vo_c.recomment }<br>
								<form>
									<input type="hidden" name="seq" value="${vo_c.seq }">
									<input type="hidden" name="board_no" value="${boardVO.seq }">
									<input type="hidden" name="id" value="${login }">
									<input type="hidden" name="up_down">
									<button type="button" onclick="up(this.form);" class= "commentUpDown">
										<img src="${pageContext.request.contextPath }/resources/img/thumb_up.png" width = "20px" height="20px">
									</button>
									<button type="button" onclick="down(this.form);" class= "commentUpDown">
										<img src="${pageContext.request.contextPath }/resources/img/thumb_down.png" width = "20px" height="20px">
									</button>
								</form>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${isEmpty}">
			<tr>
				<th align="center" colspan = "2"> 댓글이 아직 없습니다 </th>
			</tr>
		</c:if>
		<tr>
			<td colspan="2">
				<form>
					<table>
						<tr>
							<td width="620px">
								<input type="hidden" name="board_no" value="${boardVO.seq }">
								<input type="hidden" name="id" value="${login }">
								<textarea rows="4" cols="70" name="content" placeholder="댓글쓰기"> </textarea>
							</td>
							<td width="80px" align="center">
								<input type="button" value="등록" onclick="writeComment(this.form);">
							</td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>
	<br>
	<div align="center">
		<input type="button" value="목록" onclick="location.href='list?start=${start}'">
		<c:if test="${boardVO.id == login }">
			<input type="button" value="수정" onclick="location.href='boardModify?seq=${boardVO.seq }'">
			<input type="button" value="삭제" onclick="location.href='boardIdentification?url=boardDelete&seq=${boardVO.seq}'">
		</c:if>
	</div>
</div>
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>