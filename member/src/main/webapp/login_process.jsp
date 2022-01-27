<%@page import="java.sql.DriverManager"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%
	request.setCharacterEncoding("UTF-8");
	String user_id = request.getParameter("user_id");
	String user_pw = request.getParameter("user_pw");
	System.out.print(user_id+"==="+user_pw);

	//1. 드라이버 연결
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "TEST_USER";
	String pw = "1234";
	
	//2. Injection 
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PASSWORD = ?";
	
	try {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, id, pw);
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user_id);
		pstmt.setString(2, user_pw);
		rs = pstmt.executeQuery();
		if(rs.next()){
			// 성공
			session.setAttribute("name", rs.getString("name"));
			session.setAttribute("id", rs.getString("id"));
			response.sendRedirect("/member");
		} else {
			// 실패
			%>
			<script>
				alert("아이디 및 비밀번호를 확인해주세요.");
				history.back();				
			</script>
			<%
		}
	} catch(Exception e){
		e.printStackTrace();
	} finally {
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(conn!=null) conn.close();
	}
	
%>    