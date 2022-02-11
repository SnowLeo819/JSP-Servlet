package com.TISpjh.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TISpjh.model.ReplyBoardDao;
import com.TISpjh.model.ReplyBoardDto;
import com.TISpjh.util.ScriptWriter;

@WebServlet("/BoardSearchList.do")
public class BoardSearchListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardSearchListController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String search_select = request.getParameter("search_select");
		String search_word = request.getParameter("search_word");
		
		if(search_word==null || search_word.equals("")) {
			ScriptWriter.alertAndBack(response, "검색어를 입력해주세요");
		} else {
			
			ReplyBoardDao replyBoardDao = new ReplyBoardDao();
			ArrayList<ReplyBoardDto> boardList =  replyBoardDao.getSearchAllList(search_select, search_word);
			
//			System.out.println(boardList);
			
			request.setAttribute("boardList", boardList);
			RequestDispatcher dipatcher = request.getRequestDispatcher("search_list.jsp");
			dipatcher.forward(request, response);
		}
	}
}
