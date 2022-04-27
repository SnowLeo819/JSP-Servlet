package com.TISpjh.controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.TISpjh.model.MemberDao;
import com.TISpjh.model.MemberDto;
import com.TISpjh.util.ScriptWriter;

@WebServlet("/member/LoginProcess.do")
public class LoginProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginProcessController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");  // 글자 깨짐 방지..
		
		// 받아온 값 ...
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		// dto 에 받은 id,pw 넣기..
		MemberDto memberDto = new MemberDto();
		MemberDao memberDao = new MemberDao();
		memberDto.setId(user_id);
		memberDto.setPassword(user_pw);
		
		// login 정보 DB에서 받아오기..
		MemberDto loggedMember = memberDao.getLoggedMember(memberDto);
		
		//(JSP에서는(<% %>) 객체를 선언해주지 않아도 사용가능하지만 Servlet(JAVA파일)에서는 선언해줘야 사용가능하다.)
		HttpSession session = request.getSession();
		
		if(loggedMember!=null) {
			//로그인이 된경우( 로그인정보가 null 값 아닐 때 )
			session.setAttribute("loggedId", loggedMember.getId());
			session.setAttribute("loggedName", loggedMember.getName());
			session.setAttribute("loggedMember", loggedMember);
			
			ScriptWriter.alertAndNext(response, loggedMember.getName()+"님 안녕하세요.", "Index.do");
			
			System.out.println("loggedId == "+loggedMember.getId());
			System.out.println("loggedName == "+loggedMember.getName());
		} else {
			//로그인 실패... (로그인정보가 null)
			ScriptWriter.alertAndBack(response, "아이디&비밀번호 확인해 주세요.");
		}
	}
}
