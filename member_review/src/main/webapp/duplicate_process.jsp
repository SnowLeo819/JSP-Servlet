<%@page import="com.pjh.util.ScriptWriter"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.pjh.jdbc.JDBCConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String user_id = request.getParameter("user_id");
	String id_duplicate = request.getParameter("id_duplicate");

	JDBCConnection jdbcConn = new JDBCConnection();
	Connection conn = jdbcConn.conn;
	PreparedStatement pstmt = jdbcConn.pstmt;
	ResultSet rs = pstmt.executeQuery();
	
	String sql = "SELECT * FROM MEMBER WHERE ID = ?";
	
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, user_id);
	rs = pstmt.executeQuery();
	
	if(rs.next()) ScriptWriter.alertAndBack(response, "중복된 아이디 입니다.");

%>    
