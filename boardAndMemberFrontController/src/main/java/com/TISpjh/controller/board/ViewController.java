package com.TISpjh.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TISpjh.controller.AbstractController;
import com.TISpjh.front.ModelAndView;
import com.TISpjh.model.BoardDao;
import com.TISpjh.model.BoardDto;

public class ViewController implements AbstractController{

	@Override
	public ModelAndView requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nextPage = "board/view";
		ModelAndView mav = new ModelAndView(nextPage);
		
		int no = Integer.parseInt(request.getParameter("no"));
		BoardDao boardDao = new BoardDao();
		
		BoardDto boardDto = boardDao.getSelectOne(no);
		mav.addObject("boardDto", boardDto);

		int num = boardDto.getNum();
		BoardDto prevBoardDto = null;
		prevBoardDto = boardDao.getPrevBoard(num);
		mav.addObject("prevBoardDto", prevBoardDto);
		
		BoardDto nextBoardDto = null;
		nextBoardDto = boardDao.getNextBoard(num);
		mav.addObject("nextBoardDto", nextBoardDto);
		
		return mav;
	}

}
