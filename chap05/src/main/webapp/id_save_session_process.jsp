<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String user_id =  request.getParameter("user_id");
	String user_pw =  request.getParameter("user_pw");
	String save_check =  request.getParameter("save_check");
	System.out.println(user_id+"=="+user_pw+"=="+save_check);
	if(user_id.equals("park") && user_pw.equals("1234")) {
		if(save_check != null && save_check.equals("yes")) {
			// 쿠키로 id 저장...
			Cookie cookie = new Cookie("loginId", user_id);
			cookie.setPath("/");
			cookie.setMaxAge(20);
			response.addCookie(cookie);
		} else {
			Cookie cookie = new Cookie("loginId","");
			cookie.setPath("/");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		session.setAttribute("login_user", user_id);
		out.println("<script>alert('로그인 되었습니다.'); location.href='main.jsp';</script>");
	} 
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
</html>