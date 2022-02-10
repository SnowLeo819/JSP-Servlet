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

@WebServlet("/DeleteProcess.do")
public class DeleteProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteProcessController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt( request.getParameter("no"));
		String user_pw = request.getParameter("user_pw");
		
		ReplyBoardDao replyBoardDao = new ReplyBoardDao();
		ReplyBoardDto replyBoardDto = new ReplyBoardDto();
		
		replyBoardDto.setNo(no);
		replyBoardDto.setPassword(user_pw);
		
		 int result = replyBoardDao.deleteBoard(replyBoardDto);
		 
		 if(result>0) {
			 ScriptWriter.alertAndNext(response, "글이 삭제되었습니다.", "BoardList.do");
		 } else {
			 ScriptWriter.alertAndBack(response, "비밀번호를 확인해 주세요.");
		 }
	}
}
