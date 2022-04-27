package com.TISpjh.controller.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TISpjh.controller.AbstractController;
import com.TISpjh.front.ModelAndView;
import com.TISpjh.model.BoardDao;
import com.TISpjh.model.BoardDto;
import com.TISpjh.util.PageWriter;

public class BoardListController implements AbstractController {

	@Override
	public ModelAndView requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nextPage = "board/list";
		ModelAndView mav = new ModelAndView(nextPage);

		BoardDao BoardDao = new BoardDao();
		String search_select = request.getParameter("search_select");
		String search_word = request.getParameter("search_word");

		// 페이지 지정 없이 들어오는 경우.. 지정
		String tempClickPage = request.getParameter("clickPage");
		if (tempClickPage == null) {
			tempClickPage = "1";
		}
		int clickPage = Integer.parseInt(tempClickPage);

		int totalPage = BoardDao.getTotal(search_select, search_word); // 전체.. 12 페이지
		int listPerPage = 5; // 한번에 뿌릴 수 5개
		int pageBlock = 3; // pagination에 보여질 목록수 < 1/2/3 >

		// 정수로 떨어질 때 빈 페이지 생성되는 부분 수정
		int lastPage = 0;
		if (totalPage % listPerPage == 0) {
			lastPage = (int) (Math.ceil(totalPage / listPerPage));
		} else {
			lastPage = (int) (Math.ceil(totalPage / listPerPage)) + 1; // 마지막 페이지 번호
		}

		int startPage = (int) ((clickPage - 1) / pageBlock) * pageBlock + 1; // pagination 의 첫번호
		int endPage = startPage + pageBlock - 1; // pagination 의 마지막 번호

		// endPage > lastPage 인 경우 허수값의 페이지 버튼이 생기지 않도록 조건 추가
		if (endPage > lastPage)
			endPage = lastPage;

		// 페이지에 표현할 게시글의 데이터.. 시작 끝.. 선언
		int start = (clickPage - 1) * listPerPage + 1; // dao 전달 변수.. 페이지에서 첫 글 번호
		int end = start + listPerPage - 1; // dao 전달 변수.. 페이지에서 마지막 글 번호

		// 데이터 담기
		List<BoardDto> boardList = BoardDao.getAllList(start, end, search_select, search_word);
		request.setAttribute("boardList", boardList);

		String page = "";

		if (search_word != null && search_word != "") {
			page = PageWriter.pageWrite(totalPage, listPerPage, pageBlock, clickPage, "../board/BoardList.do?search_select="+search_select+"&search_word="+search_word);
		} else {
			page = PageWriter.pageWrite(totalPage, listPerPage, pageBlock, clickPage, "../board/BoardList.do");

		}

		mav.addObject("page", page);
		mav.addObject("totalPage", totalPage);

		return mav;
	}
}
