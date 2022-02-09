<%@page import="com.TISpjh.util.ScriptWriter"%>
<%@page import="com.TISpjh.model.BoardDao"%>
<%@page import="com.TISpjh.model.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//넘어오는 값 받아서 boardDto에 값을 실어보기
	request.setCharacterEncoding("UTF-8");
	String user_name = request.getParameter("user_name");
	String user_subject = request.getParameter("user_subject");
	String user_pw = request.getParameter("user_pw");
	String user_email = request.getParameter("user_email");
	String user_contents = request.getParameter("user_contents");
	
	BoardDto boardDto = new BoardDto();
	boardDto.setName(user_name);
	boardDto.setSubject(user_subject);
	boardDto.setEmail(user_email);
	boardDto.setPassword(user_pw);
	boardDto.setContents(user_contents);
	
	BoardDao boardDao = new BoardDao();
	int result = boardDao.insertBoard(boardDto);
	if(result>0) {
		response.sendRedirect("./list.jsp");
	} else {
		ScriptWriter.alertAndBack(response, "데이터 베이스 오류입니다.");
	}
%>




