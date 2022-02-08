<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>url 태그로 링크 만들기...</h1>
	<c:url value="include/other.jsp" var="link">
		<c:param name="user_param01" value="doctor stranger"></c:param>
		<c:param name="user_param02">호크아이</c:param>
	</c:url>
	<a href="${link }">other.jsp로 링크 걸기</a>
</body>
</html>