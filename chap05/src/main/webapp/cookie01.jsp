<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		
		Cookie cookie = new Cookie("id","park");    // 쿠키 정보는 문자로만 보냄
		cookie.setMaxAge(60*60*24);                 // 초 단위로 구성
		response.addCookie(cookie);
		response.addCookie(new Cookie("age","24"));
		response.addCookie(new Cookie("pw","1234"));
		
	%>
	
	<h1>쿠키 보내기..</h1>

	<%
		Cookie cookies [] = request.getCookies();
		if(cookies != null) {
			for(Cookie c : cookies){
				String cookieName = c.getName();
				String cookieValue = c.getValue();
				out.println(cookieName+" : "+cookieValue+"<br>");
				
			}
		}
	
	%>

</body>
</html>