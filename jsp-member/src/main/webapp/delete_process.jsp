<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8"); // 들어오는 데이터 한글 깨짐 방지...
	response.setContentType("text/html; charset=UTF-8");  // 나가는 데이터 한글 꺠짐 방지...
	
	String user_id =  request.getParameter("user_id");
	String user_pw =  request.getParameter("user_pw");
	
	System.out.print(user_id+"==="+user_pw);
	
	//1. 드라이버 연결
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "TIS002";
	String pw = "1234";
	
	//2. Injection 
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	String sql =  "DELETE FROM MEMBER WHERE ID = ? AND PASSWORD = ?";
	
	//3. 클래스 찾아서 연결
	//System.out.println(address);
	
	try {
		Class.forName(driver);
		conn = DriverManager.getConnection(url,id,pw);
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user_id);
		pstmt.setString(2,user_pw);
		int result = pstmt.executeUpdate(); // 몇개에 영향을 미쳤는지.... 갯수 반환...
		if(result > 0) {   // 입력이 하나 이상 되었다..
			response.sendRedirect("/member");
			session.invalidate();
		} else { 
%>		
			<script>
				alert("아이디 패스워드 확인해 주세요.");
				history.back();
			</script>
<%	
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		if(pstmt!=null) pstmt.close();
		if(conn!=null) conn.close();
	}
%>
    