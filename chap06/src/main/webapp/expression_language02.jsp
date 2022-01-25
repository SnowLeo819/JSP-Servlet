<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	pageContext.setAttribute("scope", "pageContext");
	request.setAttribute("scope", "request");
	session.setAttribute("scope", "session");
	application.setAttribute("scope", "application");
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li>${scope}</li>  <!-- attribute 이름만 쓰면 제일 좁은 범위부터 탐색 -->
		<li>${pageScope.scope}</li>
		<li>${requestScope.scope}</li>
		<li>${sessionScope.scope}</li>
		<li>${applicationScope.scope}</li>
	</ul>

</body>
</html>