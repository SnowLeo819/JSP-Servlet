package com.TISpjh.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.TISpjh.controller.AbstractController;
import com.TISpjh.front.ModelAndView;
import com.TISpjh.model.MemberDao;
import com.TISpjh.model.MemberDto;
import com.TISpjh.util.ScriptWriter;

public class LoginPorcessController implements AbstractController{
	// 연결만... 자바스크립트 못씀
	@Override
	public ModelAndView requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nextPage = "BoardList.do";
		ModelAndView mav = null;
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		MemberDao memberDao = new MemberDao();
		MemberDto memberDto	= new MemberDto();
		memberDto.setId(user_id);
		memberDto.setPassword(user_pw);
		
		// 데이트 싣고 nextpage 결정해주면 fornt에서 처리해줌
		
		MemberDto loggedMember = memberDao.getLoggedMember(memberDto);
		if(loggedMember!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("loggedMember", loggedMember);
			session.setAttribute("loggedId", loggedMember.getId());
			session.setAttribute("loggedName", loggedMember.getName());
			session.setAttribute("isManager", "true");
			mav = new ModelAndView(nextPage, "alertMsg", loggedMember.getName()+"님 로그인");
		} else {
			mav = new ModelAndView(nextPage, "backMsg", "아이디 & 패스워드 확인 ㅋㅋ");
		}
		
		return mav;
	}
}
