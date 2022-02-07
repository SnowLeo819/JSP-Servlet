package com.jjang051.model;

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
	public int insertBoard(BoardDto boardDto) {
		int result = 0;
		getConnection();
		String sql = "INSERT INTO BOARD VALUES (SEQ_BOARD.NEXTVAL,?,?,?,?,?,SYSDATE,0)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardDto.getName());
			pstmt.setString(2, boardDto.getSubject());
			pstmt.setString(3, boardDto.getEmail());
			pstmt.setString(4, boardDto.getPassword());
			pstmt.setString(5, boardDto.getContents());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return result;
	}
	
	public ArrayList<BoardDto> showAllBoard() {
		ArrayList<BoardDto> boardList = new ArrayList<>();
		getConnection();
		String sql =  "SELECT * FROM BOARD";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setNo(rs.getInt("no"));
				boardDto.setName(rs.getString("name"));
				boardDto.setSubject(rs.getString("subject"));
				boardDto.setPassword(rs.getString("password"));
				boardDto.setEmail(rs.getString("email"));
				boardDto.setContents(rs.getString("contents"));
				boardDto.setRegDate(rs.getString("regDate"));
				boardDto.setHit(rs.getInt("hit"));
				boardList.add(boardDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return boardList;
	}
	
	public BoardDto getSelectOne(int no) {
		BoardDto boardDto = new BoardDto();
		
		getConnection();
		String hitUpdateSql = "UPDATE BOARD SET HIT = HIT + 1 WHERE NO = ?";
		
		try {
			pstmt = conn.prepareStatement(hitUpdateSql);
			pstmt.setInt(1, no);
			int result = pstmt.executeUpdate();
			
			String readSql = "SELECT * FROM BOARD WHERE NO = ?";
			pstmt = conn.prepareStatement(readSql);
			pstmt.setInt(1, no);;
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				boardDto.setNo(rs.getInt("no"));
				boardDto.setName(rs.getString("name"));
				boardDto.setSubject(rs.getString("subject"));
				boardDto.setEmail(rs.getString("email"));
				boardDto.setContents(rs.getString("contents"));
				boardDto.setRegDate(rs.getString("regdate"));
				boardDto.setHit(rs.getInt("hit"));
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return boardDto;
	}
}






