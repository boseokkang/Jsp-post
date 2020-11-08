package com.cos.apple.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cos.apple.db.DBConn;
import com.cos.apple.model.Member;

public class MemberDao {
			
			private Connection conn;
			private PreparedStatement pstmt;
			private ResultSet rs;
		
			public Member 회원찾기(int id) {

				try {
					String SQL = "SELECT * FROM member WHERE id = ?";
					conn = DBConn.getConnection(); // DB 연결
					pstmt = conn.prepareStatement(SQL); // 버퍼 달기
					pstmt.setInt(1, id);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						Member member = new Member();
						member.setId(rs.getInt("id"));
						member.setUsername(rs.getString("username"));
						member.setEmail(rs.getString("email"));
						member.setCreateDate(rs.getTimestamp("createDate"));
						return member;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}

			public int 회원수정(int id, String username, String password, String email) {

				try {
					String SQL = "UPDATE member SET username = ?, password = ?, email = ? WHERE id = ?";
					conn = DBConn.getConnection(); // DB 연결
					pstmt = conn.prepareStatement(SQL); // 버퍼 달기
					pstmt.setString(1, username);
					pstmt.setString(2, password);
					pstmt.setString(3, email);
					pstmt.setInt(4, id);
					return pstmt.executeUpdate();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				return -1;
			}
			
			
			public Member 로그인(String username, String password) {

				try {
					String SQL = "SELECT * FROM member WHERE username = ? AND password = ?";
					conn = DBConn.getConnection(); // DB 연결
					pstmt = conn.prepareStatement(SQL); // 버퍼 달기
					pstmt.setString(1, username);
					pstmt.setString(2, password);
					
					rs = pstmt.executeQuery();
					if(rs.next()) {
						Member member = new Member();
						member.setId(rs.getInt("id"));
						member.setUsername(rs.getString("password"));
						member.setEmail(rs.getString("email"));
						member.setCreateDate(rs.getTimestamp("createDate"));
						return member;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}

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

