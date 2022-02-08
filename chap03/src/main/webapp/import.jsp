<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>import</title>
</head>
<body>
	<%
		Calendar calendar = Calendar.getInstance();	
		SimpleDateFormat today = new SimpleDateFormat("yyyy-mm-dd");
		SimpleDateFormat now = new SimpleDateFormat("hh : mm : ss");
	%>
	<p>오늘은 <strong><%=today.format(calendar.getTime()) %></strong> </p>
	<p>지금 시간은 <strong><%=now.format(calendar.getTime()) %></strong> </p>

</body>
</html>