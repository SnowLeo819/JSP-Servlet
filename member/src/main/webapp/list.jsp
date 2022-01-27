<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./include/header.jsp"%>
<%
	//1. 드라이버 연결
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "TEST_USER";
	String pw = "1234";
	
	//2. Injection 
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
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
					<%
						String sql =  "SELECT * FROM MEMBER";
						try {
							Class.forName(driver);
							conn = DriverManager.getConnection(url,id,pw);
							pstmt = conn.prepareStatement(sql);
							rs = pstmt.executeQuery(); // 몇개에 영향을 미쳤는지.... 갯수 반환...
							while(rs.next()) {
								out.print("<tr>");
									out.print("<td>"+rs.getString("no")+"</td>");
									out.print("<td><a href='member_info.jsp?user_id="+rs.getString("id")+"'>"+rs.getString("id")+"</td>");
									out.print("<td>"+rs.getString("name")+"</td>");
									out.print("<td>"+rs.getString("email")+"</td>");
									out.print("<td>"+rs.getString("phone")+"</td>");
									out.print("<td>"+rs.getString("zipcode")+"</td>");
									out.print("<td>"+rs.getString("address")+"</td>");
									out.print("<td>"+rs.getString("regdate")+"</td>");
								out.print("</tr>");
							}
						} catch (Exception e) {
							e.printStackTrace();
						} finally {
							if(pstmt!=null) pstmt.close();
							if(conn!=null) conn.close();
						}
					%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</main>

<%@ include file="./include/footer.jsp"%>

