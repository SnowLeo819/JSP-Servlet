<%@page import="com.jjang051.model.MemberDao"%>
<%@page import="com.jjang051.model.MemberDto"%>
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

	MemberDto memberDto = new MemberDto();
	MemberDao memberDao = new MemberDao();
	memberDto.setId(user_id);
	memberDto.setName(user_name);
	memberDto.setZipCode(zipcode);
	memberDto.setAddress(address);
	memberDto.setPhone(user_phone);
	memberDto.setPassword(password);
	memberDto.setEmail(user_email);
	
	memberdao.updateMember(memberDto);
	
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













