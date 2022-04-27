package com.pjh.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pjh.model.MemberDao;
import com.pjh.model.MemberDto;

@WebServlet("/MemberInfo.do")
public class MemberInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberInfoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		MemberDao memberDao = new MemberDao();
		MemberDto memberDto = new MemberDto();
		
		memberDto = memberDao.getSelectOne(id);
		
		request.setAttribute("memberInfo", memberDto);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/member/member_info.jsp");
		dispatcher.forward(request, response);
	}
}
