package com.TISpjh.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TISpjh.model.ReplyBoardDao;
import com.TISpjh.model.ReplyBoardDto;

@WebServlet("/View.do")
public class ViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		ReplyBoardDao replyBoardDao = new ReplyBoardDao();
		ReplyBoardDto replyBoardDto = replyBoardDao.getSelectOne(no);
		request.setAttribute("replyBoardDto", replyBoardDto);
		
		// 이전 글 보기
		// no는 seq 이기 때문에 다음글 이전글 연결이 안됨..
		// rownum. 을 이용해서 연결
		ReplyBoardDto prevReplyBoardDto = null;
		prevReplyBoardDto = ReplyBoardDao.getprevSelect(num);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("view.jsp");
		dispatcher.forward(request, response);
	}
}
