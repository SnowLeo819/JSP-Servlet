package com.pjh.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jjang051.model.BoardDao;
import com.jjang051.model.BoardDto;
import com.jjang051.util.ScriptWriter;

@WebServlet("/UpdateProcess.do")
public class UpdateProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateProcessController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF8");
		
		BoardDao boardDao = new BoardDao();
		BoardDto boardDto = new BoardDto();
		
		boardDto.setNo(Integer.parseInt(request.getParameter("no")));
		boardDto.setName(request.getParameter("user_name"));
		boardDto.setSubject(request.getParameter("user_subject"));
		boardDto.setEmail(request.getParameter("user_email"));
		boardDto.setPassword(request.getParameter("user_pw"));
		boardDto.setContents(request.getParameter("user_contents"));
		
		int result = boardDao.updateBoard(boardDto);
		if(result > 0) {
			ScriptWriter.alertAndNext(response, "글이 수정되었습니다.", "List.do");
		} else {
			ScriptWriter.alertAndBack(response, "수정 실패하였습니다.");
		}
	}
}
