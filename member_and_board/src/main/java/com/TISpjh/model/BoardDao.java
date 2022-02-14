package com.TISpjh.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDao {
	// 여기서 db에 값을 전달하고 출력하는거 여기에 다있음....
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "TIS";
//	String id = "TEST_USER";
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
	
	
	// 새글 쓰기...
	public int insertBoard(BoardDto boardDto) {
		int result = 0;
		
		try {
			getConnection();

			// 자동 커밋으로 인한 중간 오류 제거
			conn.setAutoCommit(false);
			
			// 답글 표시를 위한 사전준비 선언..
			int reGroup = 0;	// 부모글 묶음을 위한 그룹번호
			int reLevel = 1;	// 글 정렬을 위한 번호
			int reStep = 1;		// 답글 들여쓰기 표현을 위한 번호
			
			// group 값을 위한 GROUP 수 가져오기
			String reGroupSql = "SELECT MAX(REGROUP) AS REGROUPMAX FROM REPLY_BOARD";
			pstmt = conn.prepareStatement(reGroupSql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				reGroup = rs.getInt("REGROUPMAX")+1;
			}
			
			String insertSql = "INSERT INTO REPLY_BOARD VALUES (SEQ_REPLYBOARD.NEXTVAL, ?, ?, ?, ?, SYSDATE, ?, ?, ? , 0, ?)";
			//(SEQ_REPLYBOARD.NEXTVAL, ?, ?, ?, ?, SYSDATE, ?, ?, ? , 0, ?)
			
			pstmt = conn.prepareStatement(insertSql);
			pstmt.setString(1, boardDto.getSubject());
			pstmt.setString(2, boardDto.getName());
			pstmt.setString(3, boardDto.getEmail());
			pstmt.setString(4, boardDto.getPassword());
			pstmt.setInt(5, reGroup);
			pstmt.setInt(6, reLevel);
			pstmt.setInt(7, reStep);
			pstmt.setString(8, boardDto.getContents());
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
	
	// 전체 리스트 가져오기
	public ArrayList<BoardDto> getAllBoard(){
		ArrayList<BoardDto> boardList = new ArrayList<>();
		
		try {
			getConnection();
			String sql = "SELECT * FROM REPLY_BOARD ORDER BY REGROUP DESC, RELEVEL ASC";
//			String sql = "SELECT * FROM"
//					+ "(SELECT ROWNUM AS NUM, B.*  FROM"
//					+ "( SELECT * FROM REPLY_BOARD ORDER BY REGROUP DESC, RELEVEL ASC ) B"
//					+ ") WHERE NUM >= ? AND NUM <= ?";
			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, start);
//			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setNo(rs.getInt("no"));
				boardDto.setSubject(rs.getString("subject"));
				boardDto.setName(rs.getString("name"));
				boardDto.setEmail(rs.getString("email"));
				boardDto.setPassword(rs.getString("password"));
				boardDto.setContents(rs.getString("contents"));
				boardDto.setRegDate(rs.getString("regDate"));
				boardDto.setReGroup(rs.getInt("reGroup"));
				boardDto.setReStep(rs.getInt("reStep"));
				boardDto.setReLevel(rs.getInt("reLevel"));
				boardDto.setHit(rs.getInt("hit"));
				boardList.add(boardDto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		close();
		return boardList;
	}
	
	// 답글 쓰기...
	public int insertReplyBoard(BoardDto boardDto) {
		int result = 0;
		
		try {
			getConnection();

			// 자동 커밋으로 인한 중간 오류 제거
			conn.setAutoCommit(false);
			
			// 답글 표시를 위한 사전준비 선언..
			int reGroup = boardDto.getReGroup();
			int reLevel = boardDto.getReLevel();
			int reStep = boardDto.getReStep();
			
			// level 추가 (이전글 밀어내기)  ... 그룹은 부모글과 동일하므로 변동 없음
			// 답글은 최신글이 부모글 바로 밑에 위치.. 
			// 부모글의 level 보다 높은(이전에 작성된 답글) 글을 level+1 로 밀어냄.. 
			String levelAddSql = "UPDATE REPLY_BOARD SET RELEVEL = RELEVEL + 1 WHERE REGROUP = ? AND RELEVEL > ?";
			pstmt = conn.prepareStatement(levelAddSql);
			pstmt.setInt(1, reGroup);
			pstmt.setInt(2, reLevel);
			result = pstmt.executeUpdate();
			
			String insertSql = "INSERT INTO REPLY_BOARD VALUES (SEQ_REPLYBOARD.NEXTVAL, ?, ?, ?, ?, SYSDATE, ?, ?, ? , 0, ?)";
			//(SEQ_REPLYBOARD.NEXTVAL, ?, ?, ?, ?, SYSDATE, ?, ?, ? , 0, ?)
			
			pstmt = conn.prepareStatement(insertSql);
			pstmt.setString(1, boardDto.getSubject());
			pstmt.setString(2, boardDto.getName());
			pstmt.setString(3, boardDto.getEmail());
			pstmt.setString(4, boardDto.getPassword());
			pstmt.setInt(5, reGroup);
			pstmt.setInt(6, reLevel + 1);
			pstmt.setInt(7, reStep + 1);
			pstmt.setString(8, boardDto.getContents());
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
	
	public BoardDto getSelectOne(int no) {
		BoardDto boardDto = new BoardDto();

		try {
			getConnection();
			
			// 자동 커밋으로 인한 중간 오류 제거
			conn.setAutoCommit(false);
			
			// HIT(조회수) ++
			String addHitSql = "UPDATE REPLY_BOARD SET HIT = HIT + 1 WHERE NO = ?";
			pstmt = conn.prepareCall(addHitSql);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
			
			// 글 내용 가져오기
			String sql = "SELECT * FROM REPLY_BOARD WHERE NO = ?";
			pstmt = conn.prepareCall(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				boardDto.setNo(rs.getInt("no"));
				boardDto.setSubject(rs.getString("subject"));
				boardDto.setName(rs.getString("name"));
				boardDto.setEmail(rs.getString("email"));
				boardDto.setPassword(rs.getString("password"));
				boardDto.setContents(rs.getString("contents"));
				boardDto.setRegDate(rs.getString("regDate"));
				boardDto.setReGroup(rs.getInt("reGroup"));
				boardDto.setReStep(rs.getInt("reStep"));
				boardDto.setReLevel(rs.getInt("reLevel"));
				boardDto.setHit(rs.getInt("hit"));
			}
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
		return boardDto;
	}
	
	public int deleteBoard(BoardDto boardDto) {
		int result = 0;
		
		try {
			getConnection();
			String sql = "DELETE FROM REPLY_BOARD WHERE NO =? AND PASSWORD = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardDto.getNo());
			pstmt.setString(1, boardDto.getPassword());
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		close();
		return result;
	}
}





