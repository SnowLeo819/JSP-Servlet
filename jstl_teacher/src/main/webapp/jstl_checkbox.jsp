<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>좋아하는 avengers를 모두 고르시오.</h1>
	<form action="jstl_checkbox_result.jsp" method="get">
		<label><input type="checkbox" name="avengers" value="ironman"><span>ironman</span></label>
		<label><input type="checkbox" name="avengers" value="hulk"><span>hulk</span></label>
		<label><input type="checkbox" name="avengers" value="tor"><span>tor</span></label>
		<label><input type="checkbox" name="avengers" value="spiderman"><span>spiderman</span></label>
		<label><input type="checkbox" name="avengers" value="doctor stranger"><span>doctor stranger</span></label>
		<label><input type="checkbox" name="avengers" value="antman"><span>antman</span></label>
		<br>
		<button>전송</button>
	</form>
</body>
</html>