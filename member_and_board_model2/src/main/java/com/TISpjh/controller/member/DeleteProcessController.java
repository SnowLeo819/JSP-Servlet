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

@WebServlet("/DeleteProcess.do")
public class DeleteProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteProcessController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		MemberDto memberDto = new MemberDto();
		MemberDao memberDao = new MemberDao();
		memberDto.setId(user_id);
		memberDto.setPassword(user_pw);
		
		int result = memberDao.deleteMember(memberDto);
		HttpSession session = request.getSession();
		if(result>0) {
			ScriptWriter.alertAndNext(response, "회원탈되 되었습니다.", "/Index.do");
			session.invalidate();
		} else {
			ScriptWriter.alertAndBack(response, "아이디 패스워드 확인 해주세요");
		}
	}
}
