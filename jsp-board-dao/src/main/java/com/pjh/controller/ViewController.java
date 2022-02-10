package com.pjh.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jjang051.model.BoardDao;
import com.jjang051.model.BoardDto;

@WebServlet("/View.do")
public class ViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int no = Integer.parseInt(request.getParameter("no"));	
		BoardDao boardDao = new BoardDao();
		BoardDto boardDto = boardDao.getSelectOne(no); // hit에  증가와 나머지 컬럼에 값을 다 뽑아서 BoardDto
		request.setAttribute("boardDto", boardDto);// boardDto  컨테이너 역할(매개변수를 너무 많이 쓰면 오타, 빠트릴 경우가 생기니까)
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("view.jsp");
		dispatcher.forward(request, response);
		
	}
}
