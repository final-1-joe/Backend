package com.mysite.project.vo;

import java.util.List;

import lombok.Data;

@Data
public class UserTagVO {
	private String user_id;
    private String user_js;
    private String user_jg;
    private String user_job;
    private List<String> user_skill;
    private String user_ws;
    private String user_wt;
    private int user_pay;
    private int user_career;

}
