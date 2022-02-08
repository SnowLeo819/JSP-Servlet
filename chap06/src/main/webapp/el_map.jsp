<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	Map<String, String> map = new HashMap<>();
    	map.put("한글","훈민정음");
    	map.put("eng","alpabet");
    	pageContext.setAttribute("language", map);
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<p>영문 key : ${language.eng} ===${language["eng"]}</p>
	<p>한글 key : ${language["한글"]}</p>  
	<!-- 한글 작성시에는 []내부에 적은 것만 정상작동 -->

</body>
</html>