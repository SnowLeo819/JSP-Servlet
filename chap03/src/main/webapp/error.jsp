<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page isErrorPage="true" %>  <!-- 에러페이지 표시 필수! -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 다음과 같은 에러가 발생하였습니다. </h1>
	<%= exception.getMessage() %>

</body>
</html>