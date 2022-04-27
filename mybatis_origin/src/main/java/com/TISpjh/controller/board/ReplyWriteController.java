package com.TISpjh.controller.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TISpjh.model.BoardDao;
import com.TISpjh.model.BoardDto;

@WebServlet("/board/ReplyWrite.do")
public class ReplyWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReplyWriteController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		request.setAttribute("no", no); 
//		request.setAttribute("reGroup", request.getParameter("reGroup")); 
//		request.setAttribute("reStep", request.getParameter("reStep")); 
//		request.setAttribute("reLevel", request.getParameter("reLevel")); 
		
		BoardDao boardDao = new BoardDao();
		BoardDto boardDto = new BoardDto();
		
		boardDto = boardDao.getSelectOne(no);	
		request.setAttribute("boardDto", boardDto);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/board/reply_write.jsp");
		dispatcher.forward(request, response);
	}
}
