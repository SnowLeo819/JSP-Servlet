<%@page import="com.pjh.jdbc.JDBCConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./include/header.jsp"%>
<%
	String user_id = request.getParameter("user_id");

	JDBCConnection jdbcConn = new JDBCConnection();
	Connection conn = jdbcConn.conn;
	PreparedStatement pstmt = jdbcConn.pstmt;
	ResultSet rs = null;
	String sql = "SELECT * FROM MEMBER WHERE ID = ?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, user_id);
	rs = pstmt.executeQuery();
%>	

<main>
	<div class="container">
		<h2 class="subTitle">MEMBER LIST</h2>
		<div id="contents">
			<div class="tableBox">
				<table>
					<colgroup>
						<col style="width: 150px">
						<col>
					</colgroup>
					<tbody>
						<% while(rs.next()) { %>
								<tr>
									<th>ID</th>
									<td><%=rs.getString("id") %></td>
								</tr>
								<tr>
									<th>NAME</th>
									<td><%=rs.getString("name")%></td>
								</tr>
								<tr>
									<th>EMAIL</th>
									<td><%=rs.getString("email")%></td>
								</tr>
								<tr>
									<th>PHONE</th>
									<td><%=rs.getString("phone") %></td>
								</tr>
								<tr>
									<th>ZIP-CODE</th>
									<td><%= rs.getString("zipcode")%></td>
								</tr>
								<tr>
									<th>ADDRESS</th>
									<td><%= rs.getString("address")%></td>
								</tr>
								<tr>
									<th>SINCE</th>
									<td><%= rs.getString("regdate")%></td>
								</tr>
							<% } %>
					</tbody>
				</table>
				<div class="btns">
					<a href="update.jsp?user_id=<%=user_id%>" class="btn btnConfirm"> 회원정보 수정</a>
					<a href="delete.jsp?user_id=<%=user_id%>" class="btn btnCancel"> 회원탈퇴</a>
				</div>
				
			</div>
		</div>
	</div>
</main>

<%@ include file="./include/footer.jsp"%>

