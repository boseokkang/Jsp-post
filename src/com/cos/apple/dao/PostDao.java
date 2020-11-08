package com.cos.apple.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.apple.db.DBConn;
import com.cos.apple.model.Post;

public class PostDao {
		private Connection conn;
		private PreparedStatement pstmt;
		private ResultSet rs;
		
		public List<Post> 글목록() {

			try {
				String SQL = "SELECT * FROM post ORDER BY id DESC";
				conn = DBConn.getConnection(); // DB 연결
				pstmt = conn.prepareStatement(SQL); // 버퍼 달기
				rs = pstmt.executeQuery();

				List<Post> posts = new ArrayList<>();
				while (rs.next()) {
					Post post = new Post();
					post.setId(rs.getInt("id"));
					post.setMemberId(rs.getInt("memberId"));
					post.setTitle(rs.getString("title"));
					post.setContent(rs.getString("content"));
					post.setCreateDate(rs.getTimestamp("createDate"));
					posts.add(post);
				}
				return posts;
				// null 로 넘기면 jsp 가서 오류가 뜸 
				// 데이터가 없다고 해서 리스트 자체가 안뜨는 것은 이상함. 
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}

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
