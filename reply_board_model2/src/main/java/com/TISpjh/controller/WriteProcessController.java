package com.TISpjh.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TISpjh.model.ReplyBoardDao;
import com.TISpjh.model.ReplyBoardDto;
import com.TISpjh.util.ScriptWriter;

@WebServlet("/WriteProcess.do")
public class WriteProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WriteProcessController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
			
		//선언
		ReplyBoardDto replyBoardDto = new ReplyBoardDto();
		ReplyBoardDao replyBoardDao = new ReplyBoardDao();
		
		//미리 dto값 지정
		replyBoardDto.setName(request.getParameter("user_name"));		
		replyBoardDto.setSubject(request.getParameter("user_subject"));		
		replyBoardDto.setContents(request.getParameter("user_contents"));		
		replyBoardDto.setPassword(request.getParameter("user_pw"));		
		replyBoardDto.setEmail(request.getParameter("user_email"));		
		
		//dto 값으로 insertboard 실행
		int result = replyBoardDao.insertBoard(replyBoardDto);
		if(result >0) {
			ScriptWriter.alertAndNext(response, "저장되었습니다.", "BoardList.do");
		} else {
			ScriptWriter.alertAndBack(response, "DB오류입니다.");
		}
	}
}
