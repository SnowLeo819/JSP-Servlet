<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String login_user = "";
	login_user = (String)session.getAttribute("login_user");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>세션 연습</h1>
	
	<%if(login_user == "" || login_user == null){%>
		<a href="id_save_session.jsp">로그인</a>
	<% } else {%>
		<a href="user_info.jsp"><%=login_user %> 님 반갑습니다</a>
		<a href="logout.jsp">로그아웃</a>
	<% } %>
	
	
</body>
</html>