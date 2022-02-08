<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>select를 통해 값 전달하기...</h1>
	<form action="jstl_color_select_result.jsp" method="get">
		<label>색깔을 골라주세요.</label>
		<select name="color">
			<option value="1">RED</option>
			<option value="2">GREEN</option>
			<option value="3">BLUE</option>
		</select>
		<button>전송</button>
	</form>
</body>
</html>