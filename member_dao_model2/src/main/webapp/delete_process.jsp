<%@page import="com.TISpjh.model.MemberDao"%>
<%@page import="com.TISpjh.model.MemberDto"%>
<%@page import="com.TISpjh.util.ScriptWriter"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String user_id = request.getParameter("user_id");
	String user_pw = request.getParameter("user_pw");
	System.out.println(user_id+"==="+user_pw);
	MemberDto memberDto = new MemberDto();
	MemberDao memberDao = new MemberDao();
	memberDto.setId(user_id);
	memberDto.setPassword(user_pw);
	int result = memberDao.deleteMember(memberDto);
	if(result>0) {
		ScriptWriter.alertAndNext(response, "회원탈되 되었습니다.", "/member_dao");
		session.invalidate();
	} else {
		ScriptWriter.alertAndBack(response, "아이디 패스워드 확인 해주세요");
	}
%>



