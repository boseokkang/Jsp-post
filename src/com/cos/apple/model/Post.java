package com.cos.apple.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Post {
			private int id;
			private int member;
			private String title;
			private String content;
			private Timestamp createDate;
}
