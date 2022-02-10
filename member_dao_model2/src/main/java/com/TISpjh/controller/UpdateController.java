package com.TISpjh.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.TISpjh.model.MemberDao;
import com.TISpjh.model.MemberDto;

@WebServlet("/Update.do")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");  // 글자 깨짐 방지..

		//선언..
		MemberDao memberDao = new MemberDao();
		MemberDto memberDto = new MemberDto();
		
		//세션
		HttpSession session = request.getSession();
		String loggedId = (String)session.getAttribute("loggedId");
		
		// DB에서 값 가져오기
		memberDto = memberDao.getSelectOne(loggedId);
		request.setAttribute("memberDto", memberDto);
		
		
		// 전달
		RequestDispatcher dispatcher = request.getRequestDispatcher("update.jsp");
		dispatcher.forward(request, response);
	}
}
