package com.TISpjh.model;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class BoardDao {
	public List<BoardDto> getAllList(int start, int end,String search_select, String search_word) {
		List<BoardDto> boardList = null;
		
		HashMap<String, Object> pageMap = new HashMap<>();
		pageMap.put("start", start);
		pageMap.put("end", end);
		pageMap.put("searchSelect", search_select);
		pageMap.put("searchWord", search_word);
		
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		boardList = sqlSession.selectList("getAllList", pageMap); 
		// 마이바티스에서는 매서드는 매개변수 1개만 넘길 수 있음...
		// Dto 를 새로 만들던지 map을  구성 해서 넘기면 활용가능
		
		sqlSession.close();
		return boardList;
	}
	
	public int allDeleteBoard(int no) {
		int result = 0;
		
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.delete("allDeleteBoard",no);
		sqlSession.commit();
		
		sqlSession.close();		
		return result;
	}
	
	public BoardDto getSelectOne(int no) {
		BoardDto boardDto = null;
		
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		boardDto = sqlSession.selectOne("getSelectOneBoard",no);
		
		sqlSession.close();		
		return boardDto;
	}

	public int deleteBoard(BoardDto boardDto) {
		int result = 0;
		
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.delete("deleteBoard",boardDto);
		sqlSession.commit();
		
		sqlSession.close();
		return result;
	}

	public int updateBoard(BoardDto boardDto) {
		int result = 0;
		
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.update("updateBoard",boardDto);
		sqlSession.commit();
		
		sqlSession.close();
		return result;
	}
	
	public int getTotal(String search_select, String search_word) {
		int result = 0;

		HashMap<String, String> searchMap = new HashMap<>();
		searchMap.put("searchSelect", search_select);
		searchMap.put("searchWord", search_word); 
		
		SqlSession seqlSession = MybatisConnectionFactory.getSqlSession();
		result = seqlSession.selectOne("getTotal",searchMap);
		seqlSession.close();
		
		return result;
	}
	
	public BoardDto getPrevBoard(int num) {
		BoardDto prevBoardDto = null;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		prevBoardDto = sqlSession.selectOne("getPrevBoard",num);
		sqlSession.close();
		return prevBoardDto;
	}
	
	public BoardDto getNextBoard(int num) {
		BoardDto nextBoardDto = null;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		nextBoardDto = sqlSession.selectOne("getNextBoard",num);
		sqlSession.close();
		return nextBoardDto;
	}
}
