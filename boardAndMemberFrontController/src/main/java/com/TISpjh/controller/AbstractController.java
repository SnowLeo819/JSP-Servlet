package com.TISpjh.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TISpjh.front.ModelAndView;

public interface AbstractController {

	// 인터페이스는 정의만..
	// 구현할 controller 에서 메서드 구현
	public ModelAndView requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;
}
