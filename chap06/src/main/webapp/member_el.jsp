<%@page import="chap06.MemberDto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	List<MemberDto> memberList = new ArrayList<>();
	memberList.add(new MemberDto("박지형","park"));	
	memberList.add(new MemberDto("설표","snowleopard"));
	pageContext.setAttribute("members", memberList);

%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li>${members}</li>   <!-- 일괄 --> 
		<li>${members[0]}</li>   <!-- 객체 -->
				
				<!-- private, public 구분없이 접근 가능함. -->
				<!-- 2가지 조회 방법 모두 제공 -->
		<li>${members[0].name} === ${members[0].getName()}</li>  
		<li>${members[0].id} === ${members[0].getId()}</li>
		
	</ul>
</body>
</html>