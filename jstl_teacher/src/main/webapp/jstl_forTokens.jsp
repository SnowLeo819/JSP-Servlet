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
	<%
		String rgba = "red,green,blue,black.magenta";
	%>
	<h1>forTokens</h1>
	<ul>
	<c:forTokens items="<%=rgba %>" delims=",." var="color">
		<li style="color:${color}; font-size:30px;">${color }</li>
	</c:forTokens>
	</ul>
</body>
</html>