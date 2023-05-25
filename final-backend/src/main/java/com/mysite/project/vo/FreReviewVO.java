package com.mysite.project.vo;

import lombok.Data;

@Data
public class FreReviewVO {
	private int fre_rv_num;
	private String user_id;
	private int fre_rv_score;
	private String fre_rv_content;
	private String fre_rv_date;
	private String fre_rv_target;
}
