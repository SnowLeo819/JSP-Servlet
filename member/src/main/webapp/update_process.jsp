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
	String user_name =  request.getParameter("user_name");
	String user_email =  request.getParameter("user_email");
	String user_phone = "";
	String user_phone_first = request.getParameter("user_phone_first");
	String user_phone_middle = request.getParameter("user_phone_middle");
	String user_phone_last = request.getParameter("user_phone_last");
	user_phone = user_phone_first+user_phone_middle+user_phone_last;
	String address = "";
	int zipcode =  Integer.parseInt(request.getParameter("zipcode"));
	String address01 =  request.getParameter("address01");
	String address02 =  request.getParameter("address02");
	address = address01+" "+address02;
	
	//1. 드라이버 연결
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "TEST_USER";
	String pw = "1234";
	
	//2. Injection 
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	String sql =  "UPDAYE MEMBER SET NAME = ? AND PASSWORD = ?";
	
	//3. 클래스 찾아서 연결
	//System.out.println(address);
	
	try {
		Class.forName(driver);
		conn = DriverManager.getConnection(url,id,pw);
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user_name);
		pstmt.setString(2,user_pw);
		pstmt.setString(3,user_name);
		pstmt.setString(4,user_email);
		pstmt.setString(5,user_phone);
		pstmt.setString(6,user_id);
		pstmt.setInt(7,user_pw);
		int result = pstmt.executeUpdate(); // 몇개에 영향을 미쳤는지.... 갯수 반환...
		if(result > 0) {   // 입력이 하나 이상 되었다..
			session.getAttribute(name);
			response.sendRedirect("/member");
		} else { 
%>		
			<script>
				alert("회원가입에 실패하였습니다.");
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













