package com.TISpjh.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TISpjh.controller.AbstractController;
import com.TISpjh.front.ModelAndView;

public class LoginController implements AbstractController{

	@Override
	public ModelAndView requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nextPage = "member/login";
		ModelAndView mav = new ModelAndView(nextPage);
		
		return mav;
	}

}
