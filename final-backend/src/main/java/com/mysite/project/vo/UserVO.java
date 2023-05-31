package com.mysite.project.vo;

import lombok.Data;

@Data
public class UserVO {
	private String user_id;
	private String user_pw;
	private String user_name;
	private String user_email;
	private String user_tel;
	private String user_code;
	private String user_orlicense;
	private String user_stlicense;
	private int user_resume;
	private int user_tag;
}