<%@page import="com.pjh.util.ScriptWriter"%>
<%@page import="com.pjh.jdbc.JDBCConnection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");              // 들어오는 데이터 한글 깨짐 방지..
	response.setContentType("text/html; charset=UTF-8");// 나가는 데이터 한글 깨짐 방지..
	
	String user_id =  request.getParameter("user_id");
	String user_pw =  request.getParameter("user_pw");
	
	System.out.println(user_id+"==="+user_pw);

	//1. 드라이버 연결
	JDBCConnection jdbcConn = new JDBCConnection();
	PreparedStatement pstmt = jdbcConn.pstmt;
	Connection conn = jdbcConn.conn;
	String sql =  "DELETE FROM MEMBER WHERE ID = ? AND PASSWORD = ?";
	
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, user_id);
	pstmt.setString(2, user_pw);
	
	int result = pstmt.executeUpdate();
	if(result > 0) {
		ScriptWriter.alertAndNext(response, "회원탈퇴 되었습니다.", "/member_review");
		session.invalidate();
	} else {
		ScriptWriter.alertAndBack(response, "아이디 패스워드 확인 해주세요");
	}
	
%>




