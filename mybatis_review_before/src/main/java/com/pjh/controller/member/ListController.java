package com.pjh.controller.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pjh.model.MemberDao;
import com.pjh.model.MemberDto;

@WebServlet("/member/List.do")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. jsp에서 넘어온 데이터 처리
		// 2. 필요한 메서드 호출
		// 3. request 에 데이터 담기
		// 4. forward 데이터 넘기기..
		request.setCharacterEncoding("UTF-8");
		List<MemberDto> memberList = null;
		
		MemberDao memberDao = new MemberDao();
		memberList = memberDao.getMemberList();
		
		request.setAttribute("memberList", memberList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/member/list.jsp");
		dispatcher.forward(request, response);
	}
}
