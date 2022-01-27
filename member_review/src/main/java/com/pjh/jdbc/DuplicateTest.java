package com.pjh.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DuplicateTest {
	private JDBCConnection jdbcConn = new JDBCConnection();
	private Connection conn = jdbcConn.conn;
	private PreparedStatement pstmt = jdbcConn.pstmt;
	
	public DuplicateTest() {

		String sql = "SELECT * FROM MEMBER WHERE ID = ?";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user_id);
		
	}

	
}
