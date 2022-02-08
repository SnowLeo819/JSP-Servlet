<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="el_form_read02.jsp" method="get">
		<div> <input type="text" name="user_id"></div>
		<div> <input type="text" name="user_pw"></div>
		<div>
			<label> <span>낚시</span> <input type="checkbox" name="favorite" value="낚시"> </label>
			<label> <span>영화</span> <input type="checkbox" name="favorite" value="영화"> </label>
			<label> <span>게임</span> <input type="checkbox" name="favorite" value="게임"> </label>
			<label> <span>음악</span> <input type="checkbox" name="favorite" value="음악"> </label>
			<label> <span>만화</span> <input type="checkbox" name="favorite" value="만화"> </label>
			

		
		</div>
		
		<button>전송</button>
	
	</form>

</body>
</html>