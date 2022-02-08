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
	<h1>JSTL if</h1>
	<c:set var="num" value="101"></c:set>
	<%--<c:set var="num" value="100" />--%>
	<c:set var="str" value="java"></c:set>
	<h2>if 숫자비교</h2>
	<c:if test="${num%2 == 0 }" var="result">
		${num }은 짝수 입니다.
	</c:if>
	<p>num result : ${result }</p>
	
	<h2>if 문자비교</h2>
	<c:if test="${str eq 'jstl' }" var="result02">
		${str }은 jstl이 맞습니다.
	</c:if>
	<c:if test="${not result02 }" var="result02">
		${str }은 jstl이 아닙니다.
	</c:if>
	<p>str result : ${result02 }</p>
	<h2>주의할 점</h2>
	<c:if test="100" var="result03">
		test에 일반값이 들어오면 false입니다.
	</c:if>
	<%-- true를 제외한 일반값은 다 false --%>
	<p>result03 : ${result03 }</p>
	<c:if test="true" var="result04">
		test에 true이 들어오면 true입니다.
	</c:if>
	<%-- true를 제외한 일반값은 다 false --%>
	<p>result04 : ${result04 }</p>
	<c:if test="${true}" var="result05">
		test에 el을 쓴 true이 들어오면 true입니다.
	</c:if>
	<%-- test="${true}" 따옴표 사이에 공백은 허용하지 않는다 false를 리턴한다. --%>
	<p>result05 : ${result05 }</p>
	
	
</body>
</html>





