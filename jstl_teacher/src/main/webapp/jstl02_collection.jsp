<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.jjang051.common.Person"%>
<%@page import="java.util.ArrayList"%>
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
	<h1>Collection에 값 담아보기...</h1>
	<h2>ArrayList</h2>
	<%
		ArrayList<Person> personList = new ArrayList<>();
		personList.add(new Person("아이언맨",45));
		personList.add(new Person("헐크",50));
		personList.add(new Person("토르",1900));
	%>
	<c:set var = "jstlPersonList" value='<%=personList %>' scope="request"></c:set>
	<ul>
		<li>이름 : ${jstlPersonList[1].name }</li>
		<li>나이 : ${jstlPersonList[1].age }</li>
	</ul>
	
	<h2>Map</h2>
	<%
		Map<String,Person> personMap = new HashMap<>();
		personMap.put("ironman", new Person("토니스타크",45));
		personMap.put("hulk", new Person("배너박사",50));
	%>
	<c:set var="jstlPersonMap" value='<%= personMap %>' scope="request"></c:set>
	<ul>
		<li>이름 : ${jstlPersonMap.ironman.name }</li>
		<li>나이 : ${jstlPersonMap.ironman.age }</li>
	</ul>
</body>
</html>



