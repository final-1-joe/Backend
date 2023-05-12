package com.mysite.project.vo;

import lombok.Data;

@Data
public class CalVo {
	private String userid;
	private String schedule_title;
	private String schedule_content;
	private String schedule_start;
	private String schedule_end;
	private boolean schedule_open;
}
