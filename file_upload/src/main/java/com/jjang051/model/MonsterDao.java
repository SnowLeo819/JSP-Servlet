package com.jjang051.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MonsterDao {	// 여기서 db에 값을 전달하고 출력하는거 여기에 다있음....
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
	
	public int insertMonster(MonsterDto monsterDto) {
		int result = 0;
		try {
			getConnection();
			String sql = "INSERT INTO MONSTER VALUES (SEQ_MARIO.NEXTVAL,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			System.out.println(monsterDto.toString());
			pstmt.setString(1, monsterDto.getTitle());
			pstmt.setString(2, monsterDto.getContents());
			pstmt.setString(3, monsterDto.getLink());
			pstmt.setString(4, monsterDto.getBg());
			pstmt.setString(5, monsterDto.getMonsterImg());
			pstmt.setString(6, monsterDto.getMonsterRealImg());
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return result;
	}
	
	public ArrayList<MonsterDto> getAllList(){
		ArrayList<MonsterDto> monsterList = new ArrayList<>();
		
		try {
			getConnection();
			String sql = "SELECT * FROM MARIO";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MonsterDto monsterDto = new MonsterDto();
				monsterDto.setNo(rs.getInt("no"));
				monsterDto.setTitle(rs.getString("title"));
				monsterDto.setLink(rs.getString("link"));
				monsterDto.setBg(rs.getString("bg"));
				monsterDto.setContents(rs.getString("contents"));
				monsterDto.setMonsterImg(rs.getString("mario_img"));
				monsterDto.setMonsterRealImg(rs.getString("mario_real_img"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return monsterList;
		
	}
}
