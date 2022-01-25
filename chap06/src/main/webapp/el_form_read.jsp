<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String user_id = request.getParameter("user_id");
	String user_pw = request.getParameter("user_pw");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%= user_id %> <br>
	<%= user_pw %> <br>
	
	==== <br>
	
	${param.user_id} <br>
	${param.user_id == "park"} <br>
	${param.user_pw } <br>
	${param.user_pw == 1234} <br>   <!-- 형변환도 자동으로 해줌.. -->
	
</body>
</html>