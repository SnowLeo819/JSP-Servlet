<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello JSP</h1>
	<%
	int num01 = 10;
	int num02 = 20;
	int sum = num01+num02;
	// 내장 객체 (jsp 파일 내에 기본 들어가있는 PrintWriter)
	out.println("<h2>"+sum+"</h2>");
	%>
</body>
</html>