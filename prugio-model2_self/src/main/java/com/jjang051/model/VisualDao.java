package com.jjang051.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VisualDao {
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	//String id = "TIS";
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
	public int insertVisual(VisualDto visualDto) {
		int result=0;
		try {
			getConnection();
			String sql = "INSERT INTO VISUAL VALUES (SEQ_VISUAL.NEXTVAL,?,?,?,sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, visualDto.getVisualImg());
			pstmt.setString(2, visualDto.getVisualRealImg());
			pstmt.setString(3, visualDto.getSlogan());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return result;
	}
	public ArrayList<VisualDto> getAllVisual() {
		ArrayList<VisualDto> visualList = new ArrayList<>();
		try {
			getConnection();
			String sql = "SELECT * FROM VISUAL";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				VisualDto visualDto = new VisualDto();
				visualDto.setNo(rs.getInt("no"));
				visualDto.setSlogan(rs.getString("slogan"));
				visualDto.setVisualImg(rs.getString("visual_img"));
				visualDto.setVisualRealImg(rs.getString("visual_real_img"));
				visualDto.setRegDate(rs.getString("regDate"));
				visualList.add(visualDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return visualList;
	}
}






