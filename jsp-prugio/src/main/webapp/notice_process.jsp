<%@page import="com.TISpjh.util.ScriptWriter"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.jjang051.jdbc.JDBCConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String user_title = request.getParameter("user_title");
	String user_contents = request.getParameter("user_contents").replaceAll("\r\n", "<br>");
	System.out.println(user_title);
	System.out.println(user_contents);
	
	JDBCConnection jdbc = new JDBCConnection();
	Connection conn = jdbc.conn;
	PreparedStatement pstmt = jdbc.pstmt;
	String sql =  "INSERT INTO NOTICE VALUES (SEQ_NOTICE.NEXTVAL,?,?,SYSDATE)";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, user_title);
	pstmt.setString(2, user_contents);
	int result = pstmt.executeUpdate();
	if(result>0) {
		response.sendRedirect("/prugio");
	} else {
		ScriptWriter.alertAndBack(response, "DB오류 입니다. 다시 입력해 주세요.");
	}
	jdbc.close();
%>



