<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="RadioServlet" method="get">
		<label><input type="radio" name="gender" value="mail"><span>남자</span></label>
		<label><input type="radio" name="gender" value="femail"><span>여자</span></label>
		<div><button>전송</button></div>
	</form>
</body>
</html>