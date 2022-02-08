<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="research_ok.jsp" method="get">
		<table border = "1" widht="600px">
			<tr>
				<th>이름</th>
				<td><input type="text" name="user_name" placeholder="이름을 적으세요."></td>
			</tr>
			<tr>
				<th>성별</th>
				<td>
					<label><input type="radio" name="gender" value="male">남자</label> 
					<label><input type="radio" name="gender" value="female">여자</label> 
				</td>
			</tr>
			<tr>
				<th>좋아하는 계절</th>
				<td>
					<label><input type="checkbox" name="season" value="spring">봄</label> 
					<label><input type="checkbox" name="season" value="summer">여름</label> 
					<label><input type="checkbox" name="season" value="fall">가을</label> 
					<label><input type="checkbox" name="season" value="winter">겨울</label> 
				</td>
			</tr>
		</table>
		<button type="submit">전송</button>
		<button type="reset">취소</button>
	</form>

</body>
</html>