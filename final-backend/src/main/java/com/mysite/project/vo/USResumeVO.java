package com.mysite.project.vo;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class USResumeVO {
	private String user_id;
	private String user_nm;
    private String user_js;
    private Date user_bd;
    private String user_gen;
    private String user_email;
    private String user_tel;
    private String user_jg;
    private String user_job;
    private String user_skill;
    private String user_ws;
    private String user_wt;
    private int user_pay;
    private int user_career;
    private String user_orfile;
    private String user_stfile;
    private String user_github;
    private String user_intro;
}
