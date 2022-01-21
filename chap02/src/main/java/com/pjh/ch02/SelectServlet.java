package com.pjh.ch02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String job = request.getParameter("job");
		
		out.println("<html>");
		out.println("<body>");
		out.println("<p>");
		
		out.println("당신의 직업은 "+job+" 입니다.");
		
		out.println("</p>");
		
		out.println("<a href='javascript:history.back();'> 돌아가기 </a>");
		
		out.println("</body>");
		out.println("</html>");
		
		
	
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
