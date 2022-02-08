<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="requestVar" value="앞에서 전달한 것" scope="request" />
	<c:redirect url="include/other.jsp">
		<c:param name="user_param01" value="토르"  />
		<c:param name="user_param02" value="헐크"  />
	</c:redirect>
</body>
</html>