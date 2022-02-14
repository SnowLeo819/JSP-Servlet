package com.TISpjh.controller.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TISpjh.model.MemberDao;
import com.TISpjh.model.MemberDto;

@WebServlet("/member/MemberList.do")
public class MemberListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberListController() {
        super();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	MemberDao memberDao = new MemberDao();    	
    	List<MemberDto> memberList = memberDao.getAllMemberList();
    	
    	request.setAttribute("memberList", memberList);
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/member/list.jsp");
    	dispatcher.forward(request, response);
    	
    }
}
