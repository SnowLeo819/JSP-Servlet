<%@page import="com.jjang051.model.MemberDto"%>
<%@page import="com.jjang051.model.MemberDao"%>
<%@page import="com.jjang051.jdbc.JDBCConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./include/header.jsp"%>
<%
	String user_id = request.getParameter("user_id");
	MemberDao memberDao =  new MemberDao();
	MemberDto memberDto = memberDao.getSelectOne(user_id);
	request.setAttribute("memberDto", memberDto);
	//el을 통해서 출력할려고 하면 setAttribute로 담아둬야 한다.
%>
<main>
	<div class="container">
		<h2 class="subTitle">MEMBER INFO</h2>
		<div id="contents">
			<div class="tableBox">
				<table>
					<colgroup>
						<col style="width: 150px">
						<col>
					</colgroup>
					<tbody>
						<tr>
							<th>ID</th>
							<td>${memberDto.id }</td>
						</tr>
						<tr>
							<th>NAME</th>
							<td>${memberDto.name }</td>
						</tr>
						<tr>
							<th>E-MAIL</th>
							<td>${memberDto.email }</td>
						</tr>
						<tr>
							<th>PHONE</th>
							<td>${memberDto.phone }</td>
						</tr>
						<tr>
							<th>ZIP-CODE</th>
							<td>${memberDto.zipCode }</td>
						</tr>
						<tr>
							<th>ADDRESS</th>
							<td>${memberDto.address }</td>
						</tr>
					</tbody>
				</table>
				<div class="btns">
					<a href="update.jsp?user_id=${loggedId }&user_name=${loggedName }" class="btn btnConfirm">회원정보 수정</a>
					<a href="delete.jsp?user_id=${loggedId }" class="btn btnCancel">회원탈퇴</a>
				</div>
			</div>
		</div>
	</div>
</main>

<%@ include file="./include/footer.jsp"%>

