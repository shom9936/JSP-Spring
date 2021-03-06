<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	body{
		min-height: 1500px;
	}
</style>
</head>
<body>
	<h1>formatNumber</h1>
	<div>
		formatNumber : 
		<fmt:formatNumber value="1234567.89" /> <br><br>
		formatNumber groupingUsed : 
		<fmt:formatNumber value="1234567.89" groupingUsed="false" /> <br><br>
		formatNumber type=percent : 
		<fmt:formatNumber value="0.5" type="percent" /> <br><br>
		formatNumber pattern = #,#00.0# : 
		<fmt:formatNumber value="1234567.89" pattern="#,#00.0#" /> <br><br>
		formatNumber type=currency: 
		<fmt:formatNumber value="10000" type="currency" /> <br><br>
		formatNumber type=currency: 
		<fmt:formatNumber value="10000" type="currency" currencySymbol="$" /> <br><br>
	</div>
	<h1>formatDate</h1>
	<div>
		<!-- value 속성에 date를 넣어서 처리하기 위해서는 java.util.Date 클래스로 -->
		<!-- 객체를 생성하는 것이 필수적이다. -->
		<!-- 선행 조건 -->
		<c:set var="now" value="<%=new java.util.Date() %>" />
		
		now :
		${now } <br><br>
		formatDate : 
		<fmt:formatDate value="${now }"/> <br><br>
		formatDate type=time :
		<fmt:formatDate value="${now }" type="time" /> <br><br>
		formatDate type=both :
		<fmt:formatDate value="${now }" type="both" /> <br><br>
		formatDate patter = 년,월,일,시,분,초 :
		<fmt:formatDate value="${now }" pattern="yyyy년 MM월 dd일 hh시 mm분 ss초"/>
		<pre>
			default : <fmt:formatDate value="${now}" 
			    type="both" dateStyle="default" timeStyle="default"></fmt:formatDate>
			short : <fmt:formatDate value="${now}" 
			    type="both" dateStyle="short" timeStyle="short"></fmt:formatDate>
			medium : <fmt:formatDate value="${now}" 
			    type="both" dateStyle="medium" timeStyle="medium"></fmt:formatDate>
			long : <fmt:formatDate value="${now}" 
			    type="both" dateStyle="long" timeStyle="long"></fmt:formatDate>
			full : <fmt:formatDate value="${now}" 
			    type="both" dateStyle="full" timeStyle="full"></fmt:formatDate>
		</pre>
	</div>
	
	<h1>TimeZone</h1>
	<!-- setTimeZone : 특정 지역의 타임존을 설정하는 태그 -->
	<!-- 타임존 : 한국 시간과 영군 런던의 시간이 다른데 이와 같은 시간을 사용하는 지역을 묶어서 나누어 놓은 것 -->
	<!-- timeZone : 타임존을 부분 적용하는 태그 -->
	<div>
		default : 
		<c:out value="${now }" /> <br><br>
		Korea KST : 
		<fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full" /> <br><br>
		<fmt:timeZone value="GMT">
			Swiss GMT : 
			<fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full" /> <br><br>	
		</fmt:timeZone>
		<fmt:timeZone value="GMT-8">
			NewYork GMT : 
			<fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full" /> <br><br>	
		</fmt:timeZone>
	</div>
	
	<h1>Locale</h1>
	<!-- setLocale : 다국어 페이지를 만들 때, 통화와 날짜의 형식을 변경할 때 쓰임 -->
	<div>
		
		톰켓 서버의 기본 로케일 : <%= response.getLocale() %> <br><br>
		<h3>일본어</h3>
		<fmt:setLocale value="ja_jp"/>
		로케일을 일본어로 설정후 로케일 확인 : <%=response.getLocale() %> <br><br>
		통화(currency) : <fmt:formatNumber value="10000" type="currency" /> <br><br>
		날짜 : <fmt:formatDate value="${now }"/> <br><br>
		
		<h3>한국어</h3> 
		<fmt:setLocale value="ko_kr"/>
		로케일을 한국어로 설정 후 로케일 확인 : <%= response.getLocale() %> <br><br>
		통화(currency) : <fmt:formatNumber value="10000" type="currency" /> <br><br>
		날짜 : <fmt:formatDate value="${now }"/> <br><br>
		
		<h3>영어</h3>
		<fmt:setLocale value="en_US"/>
		로케일을 영어로 설정후 로케일 확인 : <%=response.getLocale() %> <br><br>
		통화(currency) : <fmt:formatNumber value="10000" type="currency" /> <br><br>
		날짜 : <fmt:formatDate value="${now }"/> <br><br>
		
		
		
	</div>

</body>
</html>