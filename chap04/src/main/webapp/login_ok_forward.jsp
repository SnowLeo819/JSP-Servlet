<%@page import="java.net.URLEncoder"%>
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
		int age = Integer.parseInt(request.getParameter("user_age"));
		if (age<=19) {
			out.println("");
	%>	
			<script>
				alert("19세 미만은 입장금지 입니다.")
				history.back();
			</script>
	<%
		} else {
			request.setAttribute("user_name", "park");
			request.setAttribute("user_age", age);
			RequestDispatcher dispatcher = request.getRequestDispatcher("login_success_forward.jsp");
			// 내부적으로 처리하고 출력함 ( 주소는 반영하지 않음 )
			dispatcher.forward(request, response);
		}
	%>

	
</body>
</html>