package com.mysite.project.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class ChatDto {
	private int message_id;
	private int chatroom_id;
	private String user_id;
	private String message_content;
	private Date message_date;	
}
