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

@WebServlet("/ReplyWriteProcess.do")
public class ReplyWriteProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReplyWriteProcessController() {
        super();
        // TODO Auto-generated constructor stub
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
		
		// 답글 형태를 위한 설정
		replyBoardDto.setReGroup(Integer.parseInt(request.getParameter("reGroup")));		
		replyBoardDto.setReLevel(Integer.parseInt(request.getParameter("reLevel")));		
		replyBoardDto.setReStep(Integer.parseInt(request.getParameter("reStep")));		
		replyBoardDto.setNo(Integer.parseInt(request.getParameter("no")));		
		
//		System.out.println(request.getParameter("reGroup"));
//		System.out.println(request.getParameter("reLevel"));
//		System.out.println(request.getParameter("reStep"));
//		System.out.println(request.getParameter("no"));
		
		//dto 값으로 insertboard 실행
		int result = replyBoardDao.insertReplyBoard(replyBoardDto);
		if(result >0) {
			ScriptWriter.alertAndNext(response, "저장되었습니다.", "BoardList.do");
		} else {
			ScriptWriter.alertAndBack(response, "DB오류입니다.");
		}
	}
}
