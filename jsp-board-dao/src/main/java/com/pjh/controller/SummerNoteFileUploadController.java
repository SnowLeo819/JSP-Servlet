package com.pjh.controller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

// 파일 받아서

@WebServlet("/SummerNoteFileUpload.do")
public class SummerNoteFileUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SummerNoteFileUploadController() {
        super();
    }
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String savePath = "summernote_upload";
		ServletContext context = this.getServletContext();
		String realPath = context.getRealPath(savePath);
		
		// realPath 에는 context 에 들어갈 이미지의 실제 경로
		
		File dir = new File(realPath);
		if(!dir.exists()) dir.mkdir();
		
		int fileSize = 1024*1024*100;
		String encoding = "UTF-8";
		DefaultFileRenamePolicy filePolicy = new DefaultFileRenamePolicy();
		
		MultipartRequest multipart = new MultipartRequest(request, realPath, fileSize, encoding, filePolicy);
		//multipart 데이터는 post 로만 넘길 수 있다.
		
		/*
		Enumeration files = multipart.getFileNames();
		String file = (String) files.nextElement();
		String fileRealName = multipart.getFilesystemName(file);
		*/
		
		String fileRealName = multipart.getFilesystemName("uploadFile");
		
		String uploadPath = savePath+"/"+fileRealName;
		// 파일이 바라보는 ( write.jsp 에서 보는) 경로..//상대경로     summernote_upload/visual_01.jpg...
		
		HashMap<String,String> fileURLMap = new HashMap<>();
		Gson gson = new Gson();
		fileURLMap.put("url", uploadPath);
		String fileUrl = gson.toJson(fileURLMap);
		request.setAttribute("fileUrl", fileUrl);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("summernote_file_upload.jsp");
		dispatcher.forward(request, response);
		
	}
}
