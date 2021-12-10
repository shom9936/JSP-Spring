<%-- logout.jsp --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// Cookie 삭제
Cookie[] cookies = request.getCookies();
if(cookies!= null){
	for(int i = 0; i<cookies.length; i++){
		if(cookies[i].getName().equals("memberName")){
			cookies[i].setMaxAge(0); // cookie 삭제
			cookies[i].setPath("/");
			response.addCookie(cookies[i]);
		}
		else if(cookies[i].getName().equals("memberId")){
			cookies[i].setMaxAge(0);
			cookies[i].setPath("/");
			response.addCookie(cookies[i]);
		}
	}
}
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