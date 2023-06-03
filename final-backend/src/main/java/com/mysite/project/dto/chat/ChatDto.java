package com.mysite.project.dto.chat;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ChatDto {
	private int message_id;
	private int chatroom_id;
	private String user_id;
	private String user_name;
	private String message_content;
	private Timestamp message_date;	
	private String img_code; // 이미지 송수신 시 String 으로 받음
	private String file_code; // 이미지 송수신 시 String 으로 받음
}
