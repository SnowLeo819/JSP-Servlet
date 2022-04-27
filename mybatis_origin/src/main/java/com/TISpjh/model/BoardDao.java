package com.TISpjh.model;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class BoardDao {

	public int insertBoard(BoardDto boardDto) {
		int result = 0;

		// 답글 표시를 위한 사전준비 선언..
		int reGroup = 0; // 부모글 묶음을 위한 그룹번호
		int reLevel = 1; // 글 정렬을 위한 번호
		int reStep = 1; // 답글 들여쓰기 표현을 위한 번호

		reGroup = getMaxReGroup() + 1; // 자동증가가 없어서 큰값 +1 로 처리
		
		System.out.println("reGroup=="+reGroup);
		
		boardDto.setReGroup(reGroup);
		boardDto.setReLevel(reLevel);
		boardDto.setReStep(reStep);

		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		result = sqlSession.insert("insertBoard", boardDto);

		if (result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return result;
	}

	// reGroup 최댓값
	public int getMaxReGroup() {
		int result = 0;
		// 1. 연결 2.mapper 에서 id 가져오기 3. return값 담기

		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		result = sqlSession.selectOne("getMaxReGroup"); 
		// select 는 resultType 존재.. 나머지는 x

		sqlSession.close();
		return result;
	}

	// 전체 리스트
	public List<BoardDto> getAllList(int start, int end,String search_select, String search_word) {
		List<BoardDto> boardList = null;
		
		HashMap<String, Object> pageMap = new HashMap<>();
		pageMap.put("start", start);
		pageMap.put("end", end);
		pageMap.put("searchSelect", search_select);
		pageMap.put("searchWord", search_word);
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		boardList = sqlSession.selectList("getAllList", pageMap); 
		// 마이바티스에서는 매서드는 매개변수 1개만 넘길 수 있음...
		// Dto 를 새로 만들던지 map을  구성 해서 넘기면 활용가능
		
		sqlSession.close();
		return boardList;
	}

	// 검색리스트 페이지.. 전체 페이지에 통합
//	public List<BoardDto> getSearchAllList(String search_select, String search_word){
//		HashMap<String, String> searchMap = new HashMap<String, String>();
//		searchMap.put("search_select", search_select);
//		searchMap.put("search_word", search_word);
//		
//		List<BoardDto> boardList = null;
//		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
//		boardList = sqlSession.selectList("getSearchAllList", searchMap); //마이바티스 메서드는 매개변수 하나밖에 못넘기...
//		sqlSession.close();
//		return boardList;
//	}

	// 전체 글 수
	public int getTotal(String search_select, String search_word) {
		int result = 0;

		HashMap<String, String> searchMap = new HashMap<>();
		searchMap.put("searchSelect", search_select);
		searchMap.put("searchWord", search_word); 
		
		SqlSession seqlSession = MyBatisConnectionFactory.getSqlSession();
		result = seqlSession.selectOne("getTotal",searchMap);
		seqlSession.close();
		
		return result;
	}
	
	public BoardDto getSelectOne(int no) {
		BoardDto boardDto = null;
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		boardDto = sqlSession.selectOne("getSelectOne",no);
		sqlSession.close();
		
		return boardDto;
	}
	
	public BoardDto getPNSelect (int num) {
		BoardDto boardDto = null;
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		boardDto = sqlSession.selectOne("getPNSelect",num);
		sqlSession.close();
		
		return boardDto;
	}
	
//	public BoardDto getPrevSelect (int num) {
//		BoardDto boardDto = null;
//		
//		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
//		boardDto = sqlSession.selectOne("getPrevSelect",num);
//		sqlSession.close();
//		
//		return boardDto;
//	}
	
//	public BoardDto getNextSelect (int num) {
//		BoardDto boardDto = null;
//		
//		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
//		boardDto = sqlSession.selectOne("getNextSelect",num);
//		sqlSession.close();
//		
//		return boardDto;
//	}
	
	// 조회수 추가ㅣ하기
	public int updateHit(int no) {
		int result = 0;
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		result = sqlSession.update("updateHit",no);
		sqlSession.commit();
		
		sqlSession.close();
		return result;
	}

	public int deleteBoard(BoardDto boardDto){
		int result = 0;
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		sqlSession.delete("deleteBoard",boardDto);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
	
//	// 답글 쓰기...
//	public int insertReplyBoard(BoardDto boardDto) {
//		int result = 0;
//		
//		try {
//			getConnection();
//
//			// 자동 커밋으로 인한 중간 오류 제거
//			conn.setAutoCommit(false);
//			
//			// 답글 표시를 위한 사전준비 선언..
//			int reGroup = boardDto.getReGroup();
//			int reLevel = boardDto.getReLevel();
//			int reStep = boardDto.getReStep();
//			
//			// level 추가 (이전글 밀어내기)  ... 그룹은 부모글과 동일하므로 변동 없음
//			// 답글은 최신글이 부모글 바로 밑에 위치.. 
//			// 부모글의 level 보다 높은(이전에 작성된 답글) 글을 level+1 로 밀어냄.. 
//			String levelAddSql = "UPDATE REPLY_BOARD SET RELEVEL = RELEVEL + 1 WHERE REGROUP = ? AND RELEVEL > ?";
//			pstmt = conn.prepareStatement(levelAddSql);
//			pstmt.setInt(1, reGroup);
//			pstmt.setInt(2, reLevel);
//			result = pstmt.executeUpdate();
//			
//			String insertSql = "INSERT INTO REPLY_BOARD VALUES (SEQ_REPLYBOARD.NEXTVAL, ?, ?, ?, ?, SYSDATE, ?, ?, ? , 0, ?)";
//			//(SEQ_REPLYBOARD.NEXTVAL, ?, ?, ?, ?, SYSDATE, ?, ?, ? , 0, ?)
//			
//			pstmt = conn.prepareStatement(insertSql);
//			pstmt.setString(1, boardDto.getSubject());
//			pstmt.setString(2, boardDto.getName());
//			pstmt.setString(3, boardDto.getEmail());
//			pstmt.setString(4, boardDto.getPassword());
//			pstmt.setInt(5, reGroup);
//			pstmt.setInt(6, reLevel + 1);
//			pstmt.setInt(7, reStep + 1);
//			pstmt.setString(8, boardDto.getContents());
//			result = pstmt.executeUpdate();
//			
//			conn.setAutoCommit(true);	
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			try {
//				conn.rollback();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//		}
//		
//		close();
//		return result;
//	}
//	
//	public BoardDto getSelectOne(int no) {
//		BoardDto boardDto = new BoardDto();
//
//		try {
//			getConnection();
//			
//			// 자동 커밋으로 인한 중간 오류 제거
//			conn.setAutoCommit(false);
//			
//			// HIT(조회수) ++
//			String addHitSql = "UPDATE REPLY_BOARD SET HIT = HIT + 1 WHERE NO = ?";
//			pstmt = conn.prepareCall(addHitSql);
//			pstmt.setInt(1, no);
//			pstmt.executeUpdate();
//			
//			// 글 내용 가져오기
//			String sql = "SELECT * FROM REPLY_BOARD WHERE NO = ?";
//			pstmt = conn.prepareCall(sql);
//			pstmt.setInt(1, no);
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) {
//				boardDto.setNo(rs.getInt("no"));
//				boardDto.setSubject(rs.getString("subject"));
//				boardDto.setName(rs.getString("name"));
//				boardDto.setEmail(rs.getString("email"));
//				boardDto.setPassword(rs.getString("password"));
//				boardDto.setContents(rs.getString("contents"));
//				boardDto.setRegDate(rs.getString("regDate"));
//				boardDto.setReGroup(rs.getInt("reGroup"));
//				boardDto.setReStep(rs.getInt("reStep"));
//				boardDto.setReLevel(rs.getInt("reLevel"));
//				boardDto.setHit(rs.getInt("hit"));
//			}
//			conn.setAutoCommit(true);	
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			try {
//				conn.rollback();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//		}
//		
//		close();
//		return boardDto;
//	}
//	
//	public int deleteBoard(BoardDto boardDto) {
//		int result = 0;
//		
//		try {
//			getConnection();
//			String sql = "DELETE FROM REPLY_BOARD WHERE NO =? AND PASSWORD = ?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, boardDto.getNo());
//			pstmt.setString(1, boardDto.getPassword());
//			result = pstmt.executeUpdate();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		close();
//		return result;
//	}
}
