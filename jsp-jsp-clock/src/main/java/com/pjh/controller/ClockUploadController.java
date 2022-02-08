package com.pjh.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.pjh.model.ClockDao;
import com.pjh.model.ClockDto;
import com.pjh.util.ScriptWriter;

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
		ServletContext context = this.getServletContext();
		String realPath = context.getRealPath(savePath);

		int fileSize = 1024*1024*50;
		String encoding = "UTF-8";
		
		File dir = new File(realPath);
		if(!dir.exists()) {
			dir.mkdir();
		}
		
		DefaultFileRenamePolicy renamePolicy = new DefaultFileRenamePolicy();
		
		MultipartRequest multipart = new MultipartRequest(request, realPath, fileSize, encoding, renamePolicy);
		//UUID 날짜 뽑아서 하는 경우도 있음
				
		ClockDao clockDao = new ClockDao();		
		ClockDto clockDto = new ClockDto();
		
		clockDto.setCategory(multipart.getParameter("category"));
		clockDto.setTitle(multipart.getParameter("title"));
		clockDto.setDepth(Integer.parseInt(multipart.getParameter("depth")));
		clockDto.setPrice(Integer.parseInt(multipart.getParameter("price")));
		clockDto.setLink(multipart.getParameter("link"));
		clockDto.setClockImg(multipart.getOriginalFileName("hublotFile"));
		clockDto.setClockRealImg(multipart.getFilesystemName("hublotFile"));
		
		int result = clockDao.insertClock(clockDto);
		
		if(result>0) {
			response.sendRedirect("Main.do");
		} else {
			ScriptWriter.alertAndBack(response, "DB오류입니다.");
		}
		
//		// model2 의 핵심!
//		RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
//		dispatcher.forward(request, response);
		
	}
}
