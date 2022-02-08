<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>redirect 는 페이지를 다른곳으로 넘기는 역할만 합니다.</p>
	<%
		String name = "네이버";
		//if(name.equals("네이버"))	response.sendRedirect("http://www.naver.com");
		//else response.sendRedirect("http://www.daum.net");
		out.println("<script>alert('로그인 되었습니다.');location.herf='http://www.naver.com'</script>");
	
	%>
	
</body>
</html>