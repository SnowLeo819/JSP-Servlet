<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<dl>
			<dt>NO</dt>
			<dd>${memberInfo.no }</dd>
		</dl>
		<dl>
			<dt>ID</dt>
			<dd>${memberInfo.id }</dd>
		</dl>
		<dl>
			<dt>E-MAIL</dt>
			<dd>${memberInfo.email }</dd>
		</dl>
		<dl>
			<dt>PHONE</dt>
			<dd>${memberInfo.phone }</dd>
		</dl>
		<dl>
			<dt>ZIPCODE</dt>
			<dd>${memberInfo.zipCode }</dd>
		</dl>
		<dl>
			<dt>address</dt>
			<dd>${memberInfo.address }</dd>
		</dl>
		<dl>
			<dt>DATE</dt>
			<dd>${memberInfo.regDate }</dd>
		</dl>
	</div>
</body>
</html>