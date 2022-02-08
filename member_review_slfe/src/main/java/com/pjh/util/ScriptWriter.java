package com.pjh.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletResponse;

public class ScriptWriter {
	public static void init(HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
	}
	
	public static void alert(HttpServletResponse response, String alertMgs) throws IOException {
		init(response);
		PrintWriter out = response.getWriter();
		out.print("<script>");
		out.print("alert('"+alertMgs+"');");
		out.print("</script>");
	}
	
	public static void alertAndBack(HttpServletResponse response, String alertMgs) throws IOException {
		init(response);
		PrintWriter out = response.getWriter();
		
		out.print("<script>");
		out.print("alert('"+alertMgs+"');");
		out.print("history.back();");
		out.print("</script>");
	}
	
	public static void alertAndNext(HttpServletResponse response, String alertMgs, String nextURL) throws IOException {
		init(response);
		PrintWriter out = response.getWriter();
		
		out.print("<script>");
		out.print("alert('"+alertMgs+"');");
		out.print("location.href='"+nextURL+"');");
		out.print("</script>");
		
	}
}
