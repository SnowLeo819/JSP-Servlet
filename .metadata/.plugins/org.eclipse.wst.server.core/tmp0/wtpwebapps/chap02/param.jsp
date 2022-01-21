<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="ParamSerclet" method="get">
		<div><label>아이디 : <input type="text" name="user_id" placeholder="user_id"></label></div>
		<div><label>나이 : <input type="text" name="user_age" placeholder="user_age"></label></div>
		<!-- <input type="submit" value="전송">  -->
		<button>전송</button>
	</form>
		<form action="ParamSerclet" method="post">
		<div><label>아이디 : <input type="text" name="user_id" placeholder="user_id"></label></div>
		<div><label>나이 : <input type="text" name="user_age" placeholder="user_age"></label></div>
		<!-- <input type="submit" value="전송">  -->
		<button>전송</button>
	</form>
</body>
</html>