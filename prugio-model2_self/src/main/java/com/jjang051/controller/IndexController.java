package com.jjang051.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jjang051.model.VisualDao;
import com.jjang051.model.VisualDto;

@WebServlet("/Index.do")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public IndexController() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VisualDao visualDao = new VisualDao();
		ArrayList<VisualDto> visualList = visualDao.getAllVisual();
		request.setAttribute("visualList", visualList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
}





