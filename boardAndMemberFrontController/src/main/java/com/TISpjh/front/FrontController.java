package com.TISpjh.front;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TISpjh.controller.AbstractController;
import com.TISpjh.util.ScriptWriter;

@WebServlet("*.do") // .do로 들어오는 url을 모두 받아 처리하겠다.
public class FrontController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// ModelAndView 선언
		ModelAndView mav = null;

		// command 얻기위한 작업 (board/list)
		String context = request.getContextPath();
		String url = request.getRequestURL().toString(); // 전체 요청주소(지금은필요x) -> http://localhost:8090/mybatis_review/board/List.do
		String uri = request.getRequestURI();              
		String command = uri.substring(context.length());
		
		// test출력
//		System.out.println("url(전체주소)=="+url);
//		System.out.println("uri(http 제외전체)=="+uri);
//		System.out.println("context(실행중)=="+context);
//		System.out.println("command(나머지주소)=="+command);
//		System.out.println();
		
		// View 를 맵핑  / 접두, 접미어 설정
		ViewResolver viewResolver = new ViewResolver();
		viewResolver.setPrefix("WEB-INF/"); // 접두어
		viewResolver.setSuffix(".jsp");     // 접미어
		
//		String nextPage = viewResolver.getViewPage(command); 아래 에서 정의
		
		// 명령어에 해당되는 controller mapping > HandlerMappin
		//Mappinds  에서 controller 가져오기
		HandlerMapping mappings = new HandlerMapping();  // mappings 선언
		AbstractController controller = null;            // controller 선언
		controller = mappings.getController(command);    // controller 값받기
		
		mav = controller.requestHandler(request, response);
		
		// 데이터를 싣기
		Map<String, Object> model = mav.getModel();
		for(String key : model.keySet()) {
			request.setAttribute(key, model.get(key));
//			System.out.println("key=="+key+" : "+model.get(key));
		}
		
		String nextPage = null;
		String tempPage = mav.getNextPage();
		// tempPage 형태에 따라 조정,...  
		if(tempPage.contains(".do")){
			nextPage = tempPage;
		} else {
			nextPage = viewResolver.getViewPage(tempPage);
		}
		
		//test출력
//		System.out.println("tempPage==="+tempPage);
//		System.out.println("nextPage==="+nextPage);
		
		String alertMsg = (String) model.get("alertMsg");
		String backMsg = (String) model.get("backMsg");
	
		//test출력
//		System.out.println("alertMsg=="+alertMsg);
//		System.out.println("backMsg=="+backMsg);
		
		if(alertMsg!=null) {
			ScriptWriter.alertAndNext(response, alertMsg, nextPage);
		} else if (backMsg!=null) {
			ScriptWriter.alertAndBack(response, backMsg);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
			dispatcher.forward(request, response);
		}
	}
}
