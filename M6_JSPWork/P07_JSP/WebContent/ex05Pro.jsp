<%--ex05Pro.jsp --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 성적 결과 </title>
<style type="text/css">
pre{font-size : 20px ;}
</style>
</head>
<body>
	<h1> 성적 </h1>
	<br>
	<pre>
		A : 100 ~ 90
		B : 89 ~ 80
		C : 79 ~ 70
		D : 69 ~ 60
		F : 59 ~ 0
	</pre>
	<hr>
	<%
		String name = request.getParameter("name");
		float kor = Float.parseFloat(request.getParameter("kor"));
		float eng = Float.parseFloat(request.getParameter("eng"));
		float math = Float.parseFloat(request.getParameter("math"));
		float total = kor + eng + math;
		float avg = total / 3 ;
		
		String grade = "F";
		if(avg >= 90) grade = "A";
		else if(avg >= 80) grade = "B";
		else if(avg >= 70) grade = "C";
		else if(avg >= 60) grade = "D";
		
		out.println(name + "님의 성적 : " + grade);
	%>

</body>
</html>