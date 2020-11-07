package com.cos.apple.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cos.apple.db.DBConn;

public class MemberDao {
			
			private Connection conn;
			private PreparedStatement pstmt;
			private ResultSet rs;
		
			public int 회원가입(String username, String password, String email) {
		 
				try {
					String SQL = "INSERT INTO member(username, password, email, createDate) VALUES(?, ?, ?, now())";
					conn = DBConn.getConnection(); // DB 연결
					pstmt = conn.prepareStatement(SQL); // 버퍼 달기
					pstmt.setString(1, username);
					pstmt.setString(2, password);
					pstmt.setString(3, email);
					return pstmt.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				}
				return -1;
			}
}

