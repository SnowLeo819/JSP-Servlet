package com.jjang051.controller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jjang051.model.VisualDao;
import com.jjang051.model.VisualDto;
import com.jjang051.util.ScriptWriter;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/VisualUpload02.do")
public class VisualUploadController02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public VisualUploadController02() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String savePath = "upload_visual";
		ServletContext context = this.getServletContext();
		String realPath = context.getRealPath(savePath);
		int fileSize = 1024 * 1024 * 50;
		String encoding = "UTF-8";
		DefaultFileRenamePolicy filePolicy = new DefaultFileRenamePolicy();

		File dir = new File(realPath);
		if (!dir.exists())
			dir.mkdir();

		MultipartRequest multipart = new MultipartRequest(request, realPath, fileSize, encoding, filePolicy);
		
		//Iterator
		Enumeration files = multipart.getFileNames();  // 파일 여러개 한번에 받기.
		int count = 0; 
		
		while(files.hasMoreElements()) {
			count++;
			String visual = (String)files.nextElement();
			
			String slogan = multipart.getParameter("user_slogan"+count);
			String visualImg = multipart.getOriginalFileName(visual);
			String visualRealImg = multipart.getFilesystemName(visual);
			VisualDao visualDao = new VisualDao();
			VisualDto visualDto = new VisualDto();
			visualDto.setSlogan(slogan);
			visualDto.setVisualImg(visualImg);
			visualDto.setVisualRealImg(visualRealImg);
			
			int result = visualDao.insertVisual(visualDto);
		}
		
//		if (result > 0) {
//			response.sendRedirect("Index.do");
//		} else {
//			ScriptWriter.alertAndBack(response, "DB오류");
//		}
	}
}
