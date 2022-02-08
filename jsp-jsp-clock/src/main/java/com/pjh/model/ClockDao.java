package com.pjh.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClockDao {
	// 여기서 db에 값을 전달하고 출력하는거 여기에 다있음....
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "TIS";
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
	
	public int insertClock(ClockDto clockDto) {
		int result = 0;
		
		try {
			getConnection();
			String sql = "INSERT INTO CLOCK VALUES(SEQ_CLOCK.NEXTVAL,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, clockDto.getCategory());
			pstmt.setString(2, clockDto.getTitle());
			pstmt.setInt(3, clockDto.getDepth());
			pstmt.setInt(4, clockDto.getPrice());
			pstmt.setString(5, clockDto.getLink());
			pstmt.setString(6, clockDto.getClockImg());
			pstmt.setString(7, clockDto.getClockRealImg());

			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return result;
	}
	
	public ArrayList<ClockDto> getAllList() {
		ArrayList<ClockDto> clockList = new ArrayList<>();
		
		try {
			getConnection();
			String sql =" SELECT * FROM CLOCK";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ClockDto clockDto = new ClockDto();
				clockDto.setNo(rs.getInt("no"));
				clockDto.setCategory(rs.getString("category"));
				clockDto.setTitle(rs.getString("title"));
				clockDto.setDepth(rs.getInt("depth"));
				clockDto.setPrice(rs.getInt("price"));
				clockDto.setLink(rs.getString("link"));
				clockDto.setClockImg(rs.getString("clock_Img"));
				clockDto.setClockRealImg(rs.getString("clock_Real_Img"));
				
				
				clockList.add(clockDto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return clockList;
	}
	
}
