package com.cos.apple.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cos.apple.db.DBConn;

public class PostDao {
		private Connection conn;
		private PreparedStatement pstmt;
		private ResultSet rs;
	
		public int 글쓰기(int memberId, String title, String content) {
	
			try {
				String SQL = "INSERT INTO post(memberId, title, content) VALUES(?, ?, ?)";
				conn = DBConn.getConnection(); // DB 연결
				pstmt = conn.prepareStatement(SQL); // 버퍼 달기
				pstmt.setInt(1, memberId);
				pstmt.setString(2, title);
				pstmt.setString(3, content);
				return pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return -1;
		}

}
