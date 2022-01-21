<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="SelectServlet" method="get">
		<div>
			<select name="job">
				<option value="">직업을 선택하세요.</option>
				<option value="학생">학생</option>
				<option value="기자">기자</option>
				<option value="검사">검사</option>
				<option value="정치인">정치인</option>
				<option value="개발자">개발자</option>
			</select>	
		</div>
		<button>전송</button>
	</form>
</body>
</html>