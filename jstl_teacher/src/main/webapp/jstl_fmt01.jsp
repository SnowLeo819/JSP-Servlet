<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>format 설정</h1>
	<c:set var="num01" value="12345" />
	<fmt:formatNumber value="${num01 }" type="currency" var="currencyNum01"/>
	<ul>
		<li>콤마 : <fmt:formatNumber value="${num01 }"/> </li>
		<li>콤마 : <fmt:formatNumber value="${num01 }" groupingUsed="false"/> </li>
	</ul>
	
	<h1>통화 기호</h1>	
	<ul>
		<li>${currencyNum01 }</li>
	</ul>
	
	<h1>퍼센트 기호</h1>
	<fmt:formatNumber value="0.03" type="percent" var="percentNum"/> 	
	<ul>
		<li>${percentNum }</li>
	</ul>
	
	<%-- fmt:parseNumber : 패턴 X / fmt:formatNumber : 패턴 O --%>
	<h1>문자를 숫자로</h1> 
	<c:set value="6,789.01" var="num02"/> 	
	<fmt:parseNumber value="${num02 }" var="parseNum02"/>
	<fmt:parseNumber value="${num02 }" integerOnly="true" var="parseNum03"/>
	<ul>
		<li>${parseNum02 }</li>
		<li>${parseNum03 }</li>
		<li><fmt:formatNumber value="123456789.01" pattern="00,000.00"/></li>
		<li><fmt:formatNumber value="${parseNum02 }" pattern="00,000.00"/></li>
	</ul>
</body>
</html>