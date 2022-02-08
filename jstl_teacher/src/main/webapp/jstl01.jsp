<%@page import="com.jjang051.common.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- view -->
	<c:set var="directVar" value="100"></c:set>
	<c:set var="elVar" value="${directVal mod 5 }"></c:set>
	<c:set var="betweenVar">변수값 설정</c:set> <!-- 이렇게도 쓸 수 있다. 많이 사용하지는 않는다. -->
	<c:set var="personVar01" value='<%= new Person("홍길동",29) %>' scope="request" ></c:set>
	<ul>	
		<li>directVar : ${directVar }</li>
		<li>elVar : ${elVar }</li>
		<li>betweenVar : ${betweenVar }</li>
		<li>이름 : ${personVar01.name }</li>
		<li>나이 : ${personVar01.age }</li>
	</ul>
</body>
</html>