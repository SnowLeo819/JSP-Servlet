<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.pjh.jdbc.JDBCConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	JDBCConnection jdbcConn	= new JDBCConnection();
	Connection conn	= jdbcConn.conn;
	PreparedStatement pstmt = jdbcConn.pstmt;
	ResultSet rs = jdbcConn.rs;
	
	String user_id = request.getParameter("user_id");
	System.out.print(user_id);
	
	String sql = "SELECT COUNT(*) AS COUNT FROM MEMBER WHERE ID = ?";

	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, user_id);
	rs = pstmt.executeQuery();
	
	int result = 0;
	if(rs.next()){
		result = rs.getInt("count"); //중복 없으면 0 있으면 1~
	}
	
	// json으로 결과 던지기
	// response.setContentType("text/html;charset=UTF8"); html로 보내기 
	
	// 자바 파일을 json으로 바꾸는 라이브러리 필요..
	response.setContentType("application/json; charset=UTF-8");	
 	Map<String, Integer> resultMap = new HashMap<>();
 	resultMap.put("count",result);
	Gson gson = new Gson();
	//gson.toJson(resultMap);
	out.print(gson.toJson(resultMap));
		
	
%>