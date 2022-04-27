<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>review list</title>
</head>
<body>
	<ul>
		<c:forEach items=${memberList } var="memberDto" varStatus="loop">
			<li>
			<a href="../member/MemberInfo.do?id=${memberDto.id }">
				
				<dl>
					<dt>NO</dt>
					<dd>${memberDto.no }</dd>
				</dl>
				<dl>
					<dt>ID</dt>
					<dd>${memberDto.id }</dd>
				</dl>
				<dl>
					<dt>E-MAIL</dt>
					<dd>${memberDto.email }</dd>
				</dl>
				<dl>
					<dt>PHONE</dt>
					<dd>${memberDto.phone }</dd>
				</dl>
				<dl>
					<dt>ZIPCODE</dt>
					<dd>${memberDto.zipCode }</dd>
				</dl>
				<dl>
					<dt>address</dt>
					<dd>${memberDto.address }</dd>
				</dl>
				<dl>
					<dt>DATE</dt>
					<dd>${memberDto.regDate }</dd>
				</dl>
			</li>
			</a>
		</c:forEach>
	</ul>


</body>
</html>