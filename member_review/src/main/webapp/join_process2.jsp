<%@page import="com.pjh.jdbc.JDBCConnection"%>
<%@page import="com.pjh.util.ScriptWriter"%>
<%@page import="oracle.sql.converter.JdbcCharacterConverters"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!--     
1. 데이터 받기
2. DB연결
3. sql 을 developer에서 테스트 후 가져옴
4. pstmt 의 ? 값 세팅..
5. DB에 값을 던지고 결과 받기..
 -->
 
<% 
	// 1. 데이터 받기
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
	int user_zipcode = Integer.parseInt(request.getParameter("zipcode"));
	String user_address = "";
	String address01 = request.getParameter("address01");
	String address02 = request.getParameter("address02");
	user_address = address01+" "+address02;
	
	// 2. DB 연결
	JDBCConnection jdbcConnection = new JDBCConnection();
	Connection conn = jdbcConnection.conn;
	PreparedStatement pstmt = jdbcConnection.pstmt;
	
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
	
	if(result>0){
		//정상입력 로직
		ScriptWriter.alertAndNext(response, "회원가입에 성공했습니다.","/member_review");
	} else {
		ScriptWriter.alertAndBack(response, "회원가입에 실패했습니다.");
	}
	jdbcConnection.close();
%>


