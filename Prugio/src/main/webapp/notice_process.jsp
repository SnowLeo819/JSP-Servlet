<<<<<<< HEAD:Prugio/src/main/webapp/notice_process.jsp
<%@page import="com.pjh.util.ScriptWriter"%>
=======
<%@page import="com.TISpjh.util.ScriptWriter"%>
<%@page import="java.sql.Connection"%>
>>>>>>> 9fdbedca618685e33e789e11fb94cacac1f454e2:jsp-prugio/src/main/webapp/notice_process.jsp
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.pjh.jdbc.JDBCConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%	
	String user_title = request.getParameter("user_title");
	String user_contents = request.getParameter("user_contents");

	System.out.println(user_title+"=="+user_contents);
	
	JDBCConnection jdbc = new JDBCConnection();
	
	PreparedStatement pstmt = jdbc.pstmt;
	Connection conn = jdbc.conn;
	
	String sql = "INSERT INT NOTICE VALUES(SEQ_NOTICE.NEXTVAL,?,?,SYSDATE)";
	
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, user_title);
	pstmt.setString(2, user_contents);
	
	int result = pstmt.executeUpdate();
	if(result>0){
		response.sendRedirect("/prugio");
	} else {
		ScriptWriter.alertAndBack(response, "db오류입니다. 다시 입력해주세요");
	}
	jdbc.close();
	
%>