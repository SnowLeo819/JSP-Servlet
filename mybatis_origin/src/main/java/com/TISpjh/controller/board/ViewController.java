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

@WebServlet("/board/View.do")
public class ViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int no = Integer.parseInt(request.getParameter("no"));
		int num = Integer.parseInt(request.getParameter("num"));
    	
		BoardDao boardDao = new BoardDao();

		// 업데이트 바로 적용되므로 다른페이지 전달 x
		int result = boardDao.updateHit(no);
    	
		BoardDto boardDto = boardDao.getSelectOne(no);
		request.setAttribute("boardDto", boardDto);
		
		// 이전, 다음글
		BoardDto prevBoardDto = null;
		prevBoardDto = boardDao.getSelectOne(num - 1);
		request.setAttribute("prevBoardDto", prevBoardDto);
		
		BoardDto nextBoardDto = null;
		nextBoardDto = boardDao.getSelectOne(num + 1);
		request.setAttribute("nextBoardDto", nextBoardDto);
    	
    	RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/board/view.jsp");
    	dispatcher.forward(request, response);
    }
}
