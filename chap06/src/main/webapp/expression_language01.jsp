<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> <% out.println("hello world"); %> </h1> 
	<h1> <%= "hello world" %> </h1>
	<h1> ${"hello world"} </h1>
	정수 : ${10} <br>
	실수 : ${4.5} <br>
	문자열 : ${"문자열입력"} <br>
	boolean : ${true} <br>
	null : ${null} <br>
	
	${10+10} <br>
	${10-10} <br>
	${10*10} <br>
	${10/10} <br>
	${10>10} <br>
	${(10>10)?5:3} <br>
	
</body>
</html>