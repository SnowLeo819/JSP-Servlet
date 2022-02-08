<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>변수 및 함수 선언하기</title>
</head>
<body>
	<%!
		String msg = "안녕하세요";
		int num01 = 10;
		int num02 = 20;
		public int abs(int num){
			if(num < 0) return num = -num;
			else return num;
		}
	%>
	<%
		out.println(msg+"<br>");
		out.println(num01+"<br>");
		out.println(num02+"<br>");
		out.println("-5의 절대값은 "+abs(-5)+"<br>");
	%>

</body>
</html>