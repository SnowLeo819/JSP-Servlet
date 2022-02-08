<%@page import="com.pjh.jdbc.JDBCConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./include/header.jsp"%>
<%
	JDBCConnection jdbcConn = new JDBCConnection();
	Connection conn = jdbcConn.conn;
	PreparedStatement pstmt = jdbcConn.pstmt;
	ResultSet rs = null;
	
	String sql =  "SELECT * FROM MEMBER";
	
	pstmt = conn.prepareStatement(sql);
	rs = pstmt.executeQuery(); // 몇개에 영향을 미쳤는지.... 갯수 반환...
	
%>	

<main>
	<div class="container">
		<h2 class="subTitle">MEMBER LIST</h2>
		<div id="contents">
			<div class="tableBox">
				<table>
					<colgroup>
						<col style="width: 30px">
						<col style="width: 100px">
						<col style="width: 100px">
						<col style="width: 200px">
						<col style="width: 150px">
						<col style="width: 100px">
						<col>
						<col style="width: 200px">
					</colgroup>
					<thead>
						<tr>
							<th>NO</th>
							<th>ID</th>
							<th>NAME</th>
							<th>EMAIL</th>
							<th>PHONE</th>
							<th>우편번호</th>
							<th>주소</th>
							<th>DATE</th>
						</tr>
					</thead>
					<tbody>
						<% while(rs.next()) { %>
							<tr>
								<td><%= rs.getString("no")%></td>
								<td><a href="member_info.jsp?user_id=<%=rs.getString("id")%>"><%=rs.getString("id") %></td>
								<td><%= rs.getString("name")%></td>
								<td><%= rs.getString("email")%></td>
								<td><%= rs.getString("phone")%></td>
								<td><%= rs.getString("zipcode")%></td>
								<td><%= rs.getString("address")%></td>
								<td><%= rs.getString("regdate")%></td>
							</tr>
						<% } %> 
					</tbody>
				</table>
			</div>
		</div>
	</div>
</main>

<%@ include file="./include/footer.jsp"%>

