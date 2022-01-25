<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//String loginId = "park";
	String loginId = "";
	String ischecked = "";
	
	Cookie cookies [] = request.getCookies();
	if(cookies != null){
		for(Cookie cookie : cookies){
			String cookieName = cookie.getName();
			if(cookieName.equals("loginId")){
				loginId = cookie.getValue();				
			}
		}
	}
	if(!loginId.equals("")) ischecked = "checked";
	%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ID 저장하기</h1>
	<form action="session_test_prosess.jsp" method="post">
		<div>
			<label>
				<span>아이디</span> 
				<input type="text" name="user_id" value="<%= loginId %>" placeholder="아이디를 입력하세요.">	
			</label>
			<label>
				<span>패스워드</span> 
				<input type="password" name="user_pw" placeholder="비밀번호를 입력하세요.">
			</label>
			<label>
				<input type="checkbox" name="save_check" value="yes" <%=ischecked %>> 아이디 저장하기
			</label>
		</div>
		<div> <button>로그인</button> </div>
	</form>
	
</body>
</html>