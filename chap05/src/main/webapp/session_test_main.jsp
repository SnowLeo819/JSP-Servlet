<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String loginUser = "";
	loginUser = (String)session.getAttribute("loginUser"); 
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test session</h1>
	
	<% if(loginUser == "" || loginUser == null) { %>
		<a href="session_test_make.jsp"> 로그인창으로 </a>
	<% } else {%>
		<p><%=loginUser%> 님으로 로그인하셨습니다.</p> 
		<a href="session_test_out.jsp"> 로그아웃 </a>
	<% } %>
	

</body>
</html>