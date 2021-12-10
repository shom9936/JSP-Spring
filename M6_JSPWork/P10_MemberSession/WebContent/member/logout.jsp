<%-- logout.jsp --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// session 삭제
session.removeAttribute("memberName");
session.removeAttribute("memberId");
session.invalidate();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 로그아웃 </title>
<script type="text/javascript">
	// logout.jsp가 호출되면서 바로 실행합니다.
	window.onload=function(){
		alert("로그아웃");
		location.href="../main/index.jsp";
	}

</script>
</head>
<body>

</body>
</html>