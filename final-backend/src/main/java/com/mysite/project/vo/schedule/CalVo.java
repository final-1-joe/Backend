package com.mysite.project.vo.schedule;

import lombok.Data;

@Data
public class CalVo {
	private int schedule_key;
	private String user_id;
	private String schedule_title;
	private String schedule_content;
	private String schedule_start;
	private String schedule_end;
	private String schedule_color;
}
