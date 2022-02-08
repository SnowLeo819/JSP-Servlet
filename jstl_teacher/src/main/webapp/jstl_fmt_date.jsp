<%@page import="java.util.Date"%>
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
	<%--<c:set var="today" value="<%= new java.util.Date() %>" /> --%>
	<c:set var="today" value="<%= new Date() %>" />
	
	<h1>날짜 포멧</h1>
	<ul>
		<li> full: <fmt:formatDate value="${today }" type="date" dateStyle="full"/> </li>
		<li> short: <fmt:formatDate value="${today }" type="date" dateStyle="short"/> </li>
		<li> long: <fmt:formatDate value="${today }" type="date" dateStyle="long"/> </li>
		<li> default: <fmt:formatDate value="${today }" type="date" dateStyle="default"/> </li>
	</ul>
	
		<h1>시간 포멧</h1>
	<ul>
		<li> full: <fmt:formatDate value="${today }" type="time" timeStyle="full"/> </li>
		<li> short: <fmt:formatDate value="${today }" type="time" timeStyle="short"/> </li>
		<li> long: <fmt:formatDate value="${today }" type="time" timeStyle="long"/> </li>
		<li> default: <fmt:formatDate value="${today }" type="time" timeStyle="default"/> </li>
	</ul>	
	
		<h1>날짜/시간 포멧</h1>
	<ul>
		<li> full: <fmt:formatDate value="${today }" type="both" dateStyle="full"/> </li>
		<li> short: <fmt:formatDate value="${today }" type="both" dateStyle="short"/> </li>
		<li> long: <fmt:formatDate value="${today }" type="both" dateStyle="long"/> </li>
		<li> default: <fmt:formatDate value="${today }" type="both" dateStyle="default"/> </li>
		<br>
		<li> full: <fmt:formatDate value="${today }" type="both" timeStyle="full"/> </li>
		<li> short: <fmt:formatDate value="${today }" type="both" timeStyle="short"/> </li>
		<li> long: <fmt:formatDate value="${today }" type="both" timeStyle="long"/> </li>
		<li> default: <fmt:formatDate value="${today }" type="both" timeStyle="default"/> </li>
	</ul>
	
	<h1>날짜/시간 패턴</h1>
	<ul>
		<li> pattern: <fmt:formatDate value="${today }" pattern="yyyy-MM-dd hh:mm:ss"/> </li>
		
	</ul>
</body>
</html>