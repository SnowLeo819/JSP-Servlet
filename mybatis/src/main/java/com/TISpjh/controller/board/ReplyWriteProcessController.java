package com.TISpjh.controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TISpjh.model.BoardDao;
import com.TISpjh.model.BoardDto;
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
		response.setContentType("text/html;charset=UTF-8");
		
		// 선언
		BoardDto boardDto = new BoardDto();
		
		// dto 값 입력..
		boardDto.setName(request.getParameter("user_name"));
		boardDto.setSubject(request.getParameter("user_subject"));
		boardDto.setContents(request.getParameter("user_contents"));
		boardDto.setPassword(request.getParameter("user_pw"));
		boardDto.setEmail(request.getParameter("user_email"));
		
		//dto...답글 형태를 위한 설정
		boardDto.setReGroup(Integer.parseInt(request.getParameter("reGroup")));
		boardDto.setReLevel(Integer.parseInt(request.getParameter("reLevel")));
		boardDto.setReStep(Integer.parseInt(request.getParameter("reStep")));
		
		//dto 값으로 insertboard 실행
		BoardDao boardDao = new BoardDao();
		int result = boardDao.insertReplyBoard(boardDto);
		if(result > 0)  {
			ScriptWriter.alertAndNext(response, "저장되었습니다.", "BoardList.do");
		} else {
			ScriptWriter.alertAndBack(response, "DB오류입니다.");
		}
	}
}
