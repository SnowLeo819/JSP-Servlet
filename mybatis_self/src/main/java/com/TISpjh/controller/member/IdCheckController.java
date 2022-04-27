package com.TISpjh.controller.member;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TISpjh.model.MemberDao;
import com.google.gson.Gson;

@WebServlet("/IdCheck.do")
public class IdCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IdCheckController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_id = request.getParameter("user_id");
		MemberDao memberDao = new MemberDao();
		
		int result = memberDao.idCheck(user_id);
		
		Map<String, Integer> resultMap = new HashMap<>();
		resultMap.put("count", result);
		Gson gson = new Gson();
		String json =  gson.toJson(resultMap);
		request.setAttribute("json", json);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("id_check.jsp");
		dispatcher.forward(request, response);
	}
}
