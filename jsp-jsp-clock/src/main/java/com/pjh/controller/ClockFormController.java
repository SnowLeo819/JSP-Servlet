package com.pjh.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ClockFormController.do")
public class ClockFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ClockFormController() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 파일 포워드
		request.setAttribute("test", "servlet에서 넘어온 데이터");
		RequestDispatcher dispatcher = request.getRequestDispatcher("hublot_form.jsp");
		dispatcher.forward(request, response);
	}
}
