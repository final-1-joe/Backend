package com.mysite.project.vo;

import lombok.Data;

@Data
public class PjReviewVO {
	private int pj_rv_num;
	private String user_id;
	private int pj_num;
	private int pj_rv_score;
	private String pj_rv_content;
	private String pj_rv_date;
}
