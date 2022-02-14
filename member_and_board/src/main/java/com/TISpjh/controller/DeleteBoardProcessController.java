package com.TISpjh.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.TISpjh.model.BoardDao;
import com.TISpjh.model.BoardDto;
import com.TISpjh.model.MemberDao;
import com.TISpjh.model.MemberDto;
import com.TISpjh.util.ScriptWriter;

@WebServlet("/DeleteBoardProcess.do")
public class DeleteBoardProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteBoardProcessController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		String pw = request.getParameter("user_pw");
		
		BoardDto boardDto = new BoardDto();
		BoardDao boardDao = new BoardDao();
		
		
	}
}
