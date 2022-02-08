<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>request info</title>
</head>
<body>
	<!-- 내장객체.. import 안해도 되는 것.
			out, request, response, pageContext, application -->
	<ul>
		<li>컨텍스트 패스 : <%= request.getContextPath() %></li>
		<li>요청방식 : <%= request.getMethod() %></li>
		<li>요청 URL : <%= request.getRequestURL() %></li>
		<li>요청 URI : <%= request.getRequestURI() %></li>
		<li>서버 이름 : <%= request.getServerName() %></li>
		<li>서버 프로토콜 : <%= request.getProtocol() %></li>
	</ul>
			
</body>
</html>