<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style type="text/css">

</style>

<div style="width: 700px;">
	<fieldset>
		<legend align = "center">
			<font size="+2" color="green" face="돋움체"> 인기글</font> 
		</legend>
		<c:forEach items="${list }" var="vo">
			<div>
				<c:if test="${login != null }">
					<a href="view?seq=${vo.seq }&start=0"> ${vo.title } [ ${vo.comment_cnt } ]</a>
				</c:if>
				<c:if test="${login == null }">
					${vo.title } [ ${vo.comment_cnt } ]
				</c:if>
			</div>
		</c:forEach>	
	</fieldset>
	
</div>
