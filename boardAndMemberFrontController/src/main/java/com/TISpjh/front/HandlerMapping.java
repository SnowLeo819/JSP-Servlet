package com.TISpjh.front;

import java.util.HashMap;

import com.TISpjh.controller.AbstractController;
import com.TISpjh.controller.board.*;
import com.TISpjh.controller.member.*;

// 넘어오는 주소...   command 에 실려 넘어오는 주소를 Controller에 맵핑
public class HandlerMapping {
	private HashMap<String, AbstractController> mappings;
	public HandlerMapping() {
		mappings = new HashMap<String, AbstractController>();

		//board
		mappings.put("/BoardList.do", new BoardListController());
		mappings.put("/View.do", new ViewController());
		
		//member
		mappings.put("/Login.do", new LoginController());
		mappings.put("/LoginProcess.do", new LoginPorcessController());
		mappings.put("/LogOut.do", new LogOutController());
	}
	public AbstractController getController(String key) {
		return mappings.get(key);
	}
}
