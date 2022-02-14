package com.TISpjh.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.TISpjh.util.ScriptWriter;

@WebServlet("/Logout.do")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LogoutController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션 선언
		HttpSession session = request.getSession();
		
		// 이름 가져오기
		String loggedName = (String)session.getAttribute("loggedName");

		ScriptWriter.alertAndNext(response, loggedName+"님 로그아웃", "Index.do");
		session.invalidate();
	}

}
