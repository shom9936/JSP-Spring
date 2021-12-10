<!-- ex01.jsp -->
<%-- JSP 주석  --%>
<%--
# JSP ( Java Server Page )
- HTML 문서 안에 java 코드를 삽입해서 웹 서버에 동적으로 웹페이지를 생성하여 클라이언트에 전달합니다.
- JSP는 서블릿 기술을 바탕으로 해서, 웹 응용프로그램을 작성 할 수 있습니다.

# Servlet 변환 과정
- *.jsp	->	*.java	->	*.class	-> servlet 실행
	jsp 파일을 톰캣 컨테이너가 서블릿
		.java로 변환
		
# JSP 지시자
- 페이지가 실행 될 때 필요한 정보를 정의하는 역할입니다.
- page 지시자
  : 해당 페이지에 대한 정보 및 설정을 하는 지시자입니다. ( <%@ )
    > language		: 페이지 내에서 사용 할 프로그래밍 언어
      contentType	: 페이지 내에서 사용할 언어와 문자 형식 지정
      pageEncoding	: 서버내에서 작업 할 때 사용할 문자 형식 지정
      import		: 사용하려는 class 지정
      
  include 지시자
  : 현재 페이지에 포함될 코드나 문서를 정의합니다.
  taglib 지시자
  : JSP 페이지 내에서 사용되는 별도의 표현언어를 사용하기 위해 쓰이는 지시자입니다.

# 스크립트릿
- <%! %> 선언부	: 전역변수 및 메서드 선언
  <%  %> 스크립트릿	: 일반적인 코드를 작성하는 영역
  <%= %> 표현식	: 데이터를 표현하는 부분 ( 변수 )
 --%>
 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> ex01 </title>
</head>
<body>
	<h1> JSP start </h1>
	<br>
	<%="JSP 페이지 입니다" %>
	<%=getServletInfo() %>
	
</body>
</html>