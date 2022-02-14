package com.TISpjh.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReplyBoardDao {
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
//	String id = "TIS";
	String id = "TEST_USER";
	String pw = "1234";

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public void getConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("DB 연결 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 새글 쓰기 group 증가  게시물 하나 추가
	public int insertBoard(ReplyBoardDto replyBoardDto) {
		int result = 0;

		try {
			getConnection();
			
			int reGroup = 0;
			int reLevel = 1;
			int reStep = 1;
			
			String reGroupSql = "SELECT MAX(REGROUP) AS REGROUPMAX FROM REPLY_BOARD";
			pstmt = conn.prepareStatement(reGroupSql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				reGroup = rs.getInt("reGroupMax")+1;
			}
			
			String sql = "INSERT INTO REPLY_BOARD VALUES (SEQ_REPLYBOARD.NEXTVAL, ?, ?, ?, ?, SYSDATE, ?, ?, ? , 0, ?)";
			//(SEQ_REPLYBOARD.NEXTVAL, ?, ?, ?, ?, SYSDATE, ?, ?, ? , 0, ?)
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, replyBoardDto.getSubject());
			pstmt.setString(2, replyBoardDto.getName());
			pstmt.setString(3, replyBoardDto.getEmail());
			pstmt.setString(4, replyBoardDto.getPassword());
			pstmt.setInt(5, reGroup);
			pstmt.setInt(6, reLevel);
			pstmt.setInt(7, reStep);
			pstmt.setString(8, replyBoardDto.getContents());
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		close();
		return result;
	}
	
	// 답글 추가
	public int insertReplyBoard(ReplyBoardDto replyBoardDto) {
		int result = 0;

		try {
			getConnection();
			
			// java 는 autocommit 값 true 가 기본
			conn.setAutoCommit(false);			
			
			int reGroup = replyBoardDto.getReGroup();
			int reLevel = replyBoardDto.getReLevel();
			int reStep = replyBoardDto.getReStep();
			
			// level 추가 (이전글 밀어내기)
			String levelAddSql = "UPDATE REPLY_BOARD SET RELEVEL = RELEVEL + 1 WHERE REGROUP = ? AND RELEVEL > ?";
			pstmt = conn.prepareStatement(levelAddSql);
			pstmt.setInt(1, reGroup);
			pstmt.setInt(2, reLevel);
			result = pstmt.executeUpdate();
			
			// 답글 입력하기
			String sql = "INSERT INTO REPLY_BOARD VALUES (SEQ_REPLYBOARD.NEXTVAL, ?, ?, ?, ?, SYSDATE, ?, ?, ? , 0, ?)";
			//(SEQ_REPLYBOARD.NEXTVAL, ?, ?, ?, ?, SYSDATE, ?, ?, ? , 0, ?)
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, replyBoardDto.getSubject());
			pstmt.setString(2, replyBoardDto.getName());
			pstmt.setString(3, replyBoardDto.getEmail());
			pstmt.setString(4, replyBoardDto.getPassword());
			pstmt.setInt(5, reGroup);
			pstmt.setInt(6, reLevel + 1);
			pstmt.setInt(7, reStep + 1);
			pstmt.setString(8, replyBoardDto.getContents());
			result = pstmt.executeUpdate();
			
			conn.setAutoCommit(true);		

		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		close();
		return result;
	}
	
	// 전체 리스트
	public ArrayList<ReplyBoardDto> getAllList(int start, int end){
		ArrayList<ReplyBoardDto> boardList = new ArrayList<>();
		
		try {
			getConnection();
//			String sql = "SELECT * FROM REPLY_BOARD ORDER BY REGROUP DESC, RELEVEL ASC";
			String sql = "SELECT * FROM"
					+ "(SELECT ROWNUM AS NUM, B.*  FROM"
					+ "( SELECT * FROM REPLY_BOARD ORDER BY REGROUP DESC, RELEVEL ASC ) B"
					+ ") WHERE NUM >= ? AND NUM <= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ReplyBoardDto replyBoardDto = new ReplyBoardDto();
				replyBoardDto.setNo(rs.getInt("no"));
				replyBoardDto.setSubject(rs.getString("subject"));
				replyBoardDto.setName(rs.getString("name"));
				replyBoardDto.setEmail(rs.getString("email"));
				replyBoardDto.setPassword(rs.getString("password"));
				replyBoardDto.setContents(rs.getString("contents"));
				replyBoardDto.setRegDate(rs.getString("regDate"));
				replyBoardDto.setReGroup(rs.getInt("reGroup"));
				replyBoardDto.setReStep(rs.getInt("reStep"));
				replyBoardDto.setReLevel(rs.getInt("reLevel"));
				replyBoardDto.setHit(rs.getInt("hit"));
				boardList.add(replyBoardDto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		close();
		return boardList;
	}
	
	public ReplyBoardDto getSelectOne(int no) {
		ReplyBoardDto replyBoardDto = new ReplyBoardDto();
		
		try {
			getConnection();
			
			// java 는 autocommit 값 true 가 기본
			conn.setAutoCommit(false);	
			
			// hit 수 증가
			String addHitSql = "UPDATE REPLY_BOARD SET HIT = HIT + 1 WHERE NO = ?";
			pstmt = conn.prepareCall(addHitSql);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
			
			// 글내용 읽어오기
			String sql = "SELECT * FROM REPLY_BOARD WHERE NO = ?";
			pstmt = conn.prepareCall(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				replyBoardDto.setNo(rs.getInt("no"));
				replyBoardDto.setSubject(rs.getString("subject"));
				replyBoardDto.setName(rs.getString("name"));
				replyBoardDto.setEmail(rs.getString("email"));
				replyBoardDto.setPassword(rs.getString("password"));
				replyBoardDto.setContents(rs.getString("contents"));
				replyBoardDto.setRegDate(rs.getString("regDate"));
				replyBoardDto.setReGroup(rs.getInt("reGroup"));
				replyBoardDto.setReStep(rs.getInt("reStep"));
				replyBoardDto.setReLevel(rs.getInt("reLevel"));
				replyBoardDto.setHit(rs.getInt("hit"));
			}

			conn.setAutoCommit(true);	
			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		close();
		return replyBoardDto;
	}
	
	public int deleteBoard(ReplyBoardDto replyBoardDto) {
		int result = 0;
		
		try {
			getConnection();
			String sql = "DELETE FROM REPLY_BOARD WHERE NO = ? AND PASSWORD = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, replyBoardDto.getNo());
			pstmt.setString(2, replyBoardDto.getPassword());
			result = pstmt.executeUpdate();
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		close();
		return result;
		
	}
	
	// 검색한 내용 리스트
	public ArrayList<ReplyBoardDto> getSearchAllList(String searchField, String searchWord){
		ArrayList<ReplyBoardDto> boardList = new ArrayList<>();
		
		try {
			getConnection();
//			기존... String sql = "SELECT * FROM REPLY_BOARD ORDER BY REGROUP DESC, RELEVEL ASC";
			// SELECT * FROM REPLY_BOARD WHERE ? LIKE '%%' ORDER BY REGREOUP DESC, RELEVEL ASC
			// field 는 바인딩 안됨.. 
			String sql = "SELECT * FROM REPLY_BOARD WHERE "+searchField+" LIKE ? ORDER BY REGROUP DESC, RELEVEL ASC";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+searchWord+"%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ReplyBoardDto replyBoardDto = new ReplyBoardDto();
				replyBoardDto.setNo(rs.getInt("no"));
				replyBoardDto.setSubject(rs.getString("subject"));
				replyBoardDto.setName(rs.getString("name"));
				replyBoardDto.setEmail(rs.getString("email"));
				replyBoardDto.setPassword(rs.getString("password"));
				replyBoardDto.setContents(rs.getString("contents"));
				replyBoardDto.setRegDate(rs.getString("regDate"));
				replyBoardDto.setReGroup(rs.getInt("reGroup"));
				replyBoardDto.setReStep(rs.getInt("reStep"));
				replyBoardDto.setReLevel(rs.getInt("reLevel"));
				replyBoardDto.setHit(rs.getInt("hit"));
				boardList.add(replyBoardDto);
			}
//			System.out.println("size=="+boardList.size());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		close();
		return boardList;
	}

	// 글 수 가져오기
	public int getTotal() {
		int total = 0;
		
		try {
			getConnection();
			String sql = "SELECT COUNT(*) AS TOTAL FROM REPLY_BOARD";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				total = rs.getInt("total");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return total;
	}
	
//	// 글 수정
//	public int updateReplyBoard(ReplyBoardDto replyBoardDto) {
//		int result = 0;
//
//		try {
//			getConnection();
//			
//			// java 는 autocommit 값 true 가 기본
//			conn.setAutoCommit(false);	
//			
////			// level 추가 (이전글 밀어내기)
////			String levelAddSql = "UPDATE REPLY_BOARD SET RELEVEL = RELEVEL + 1 WHERE REGROUP = ? AND RELEVEL > ?";
////			pstmt = conn.prepareStatement(levelAddSql);
////			pstmt.setInt(1, reGroup);
////			pstmt.setInt(2, reLevel);
////			result = pstmt.executeUpdate();
//			
//			// 답글 입력하기
//			String sql = "UPDATE REPLY_BOARD SET (SEQ_REPLYBOARD.NEXTVAL, ?, ?, ?, ?, SYSDATE, ?, ?, ? , 0, ?)";
//			//SUBJECT = ?, NAME= ?, EMAIL = ?, CONTENTS =?  WHERE NO = ? AND PASSWORD = ?)
//			
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, replyBoardDto.getSubject());
//			pstmt.setString(2, replyBoardDto.getName());
//			pstmt.setString(3, replyBoardDto.getEmail());
//			pstmt.setString(4, replyBoardDto.getContents());
//			pstmt.setInt(5, replyBoardDto.getNo());
//			pstmt.setString(6, replyBoardDto.getPassword());
//			result = pstmt.executeUpdate();
//
//			conn.setAutoCommit(true);	
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			conn.rollback();
//		}
//
//		close();
//		return result;
//	}
//	
	// 이전글 
	public ReplyBoardDto getprevSelect(int num) {
		ReplyBoardDto replyBoardDto = new ReplyBoardDto();
		
		try {
			getConnection();
			String sql = "SELECT * FROM"
					+ "(SELECT ROWNUM AS NUM, B.* FROM"
					+ "(SELECT * FORM REPLY_BOARD ORDER BY REGROUP DESC, RElEVEL ASC) B)"
					+ "WHERE NUM = ? -1";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				replyBoardDto.setNo(rs.getInt("no"));
				replyBoardDto.setSubject(rs.getString("subject"));
				replyBoardDto.setName(rs.getString("name"));
				replyBoardDto.setEmail(rs.getString("email"));
				replyBoardDto.setPassword(rs.getString("password"));
				replyBoardDto.setContents(rs.getString("contents"));
				replyBoardDto.setRegDate(rs.getString("regDate"));
				replyBoardDto.setReGroup(rs.getInt("reGroup"));
				replyBoardDto.setReStep(rs.getInt("reStep"));
				replyBoardDto.setReLevel(rs.getInt("reLevel"));
				replyBoardDto.setHit(rs.getInt("hit"));
				replyBoardDto.setNum(rs.getInt("num"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		close();
		return replyBoardDto;
	}
	
}
