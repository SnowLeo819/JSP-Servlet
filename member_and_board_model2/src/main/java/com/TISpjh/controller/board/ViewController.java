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

@WebServlet("/View.do")
public class ViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	BoardDao boardDao = new BoardDao();
    	BoardDto boardDto = new BoardDto();
    	
    	boardDto = boardDao.getSelectOne(Integer.parseInt(request.getParameter("no")));
    	request.setAttribute("boardDto", boardDto);
    	
    	RequestDispatcher dispatcher =request.getRequestDispatcher("view.jsp");
    	dispatcher.forward(request, response);
    }
}
