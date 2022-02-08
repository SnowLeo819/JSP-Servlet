<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%
    	String user_id = request.getParameter("user_id");
    	String user_pw = request.getParameter("user_pw");
    	String favorites[] = request.getParameterValues("favorite");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>넘어온 id : <%= user_id %></p>
	<p>넘어온 pw : <%= user_pw %></p>
	
	<hr>
	
	<p>넘어온 id : ${param.user_id}</p>
	<p>넘어온 pw : ${param.user_pw}</p>
	
	<hr>
	
	<ul>
		<li>${paramValues.favorite[0]}</li>
		<li>${paramValues.favorite[1]}</li>
		<li>${paramValues.favorite[2]}</li>
		<li>${paramValues.favorite[3]}</li>
	</ul>
	
</body>
</html>