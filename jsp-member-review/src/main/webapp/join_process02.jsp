<%@page import="com.TISpjh.util.ScriptWriter"%>
<%@page import="com.jjang051.jdbc.JDBCConnection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 
	1. 데이터받아야 한다.
	2. db연결을 한다.
	3. sql을 sqldeveloper에서 테스트 후 가져온다.
	4. pstmt에 ?에 대응하는 값을 세팅한다.
	5. db에 값을 던지고 결과를 받는다.
--%>
<%
	request.setCharacterEncoding("UTF-8");	

	String user_id = request.getParameter("user_id");
	String user_pw = request.getParameter("user_pw");
	String user_name = request.getParameter("user_name");
	String user_email = request.getParameter("user_email");
	String user_phone = "";
	String user_phone_first = request.getParameter("user_phone_first");
	String user_phone_middle = request.getParameter("user_phone_middle");
	String user_phone_last = request.getParameter("user_phone_last");
	user_phone = user_phone_first+"-"+user_phone_middle+"-"+user_phone_last;
	int user_zipcode = Integer.parseInt( request.getParameter("zipcode") );
	String user_address = "";
	String address01 = request.getParameter("address01");
	String address02 = request.getParameter("address02");
	user_address = address01+address02;
	// 여기까지 넘어온 값 처리.....
	JDBCConnection jdbcConnection = new JDBCConnection();
	PreparedStatement pstmt = jdbcConnection.pstmt;
	Connection conn = jdbcConnection.conn;
	String sql = "INSERT INTO MEMBER VALUES (SEQ_MEMBER.NEXTVAL,?,?,?,?,?,?,?,SYSDATE)";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, user_id);
	pstmt.setString(2, user_pw);
	pstmt.setString(3, user_name);
	pstmt.setString(4, user_email);
	pstmt.setString(5, user_phone);
	pstmt.setInt(6, user_zipcode);
	pstmt.setString(7, user_address);
	int result = pstmt.executeUpdate();
	if(result>0) {
		//response.sendRedirect("/member_review");
		ScriptWriter.alertAndNext(response, "회원가입이 완료되었습니다.","/member_review");
	} else {
		ScriptWriter.alertAndBack(response, "회원가입이 되지 않았습니다.");
	}
	jdbcConnection.close();
	
%>





<!-- 
${param.user_id } 
${param.user_pw } 
${param.user_name } 
${param.user_phone_first }
--> 

