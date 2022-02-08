package com.pjh.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Servlet 은 자바에 html..
// jsp 는 html 에 자바..

@WebServlet("/ClockUploadController.do")
public class ClockUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ClockUploadController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// do get , do post 를 포함하는 것! (action에서 넘어오는 내용 모두 받음)
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String savePath = "upload_clock";
//		ServeltContext context = this.gets
				
		
		int fileSize = 1024*1024*50;
		String encoding = "UTF-8";

		defaultfiilerenamepolicy rename = new de;
		
		MultipartRequest multipart = new MultipartRequest(request, 저장경로, 업로드파일, )

				
		request.setAttribute("test", "servlet 에서 넘어온 텍스트 입니다.");
		
		// model2 의 핵심!
		RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
		dispatcher.forward(request, response);
		
	}
}
