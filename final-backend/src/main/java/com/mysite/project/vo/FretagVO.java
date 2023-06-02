package com.mysite.project.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class FretagVO {
	private String user_id;
    private String pj_job;
    private String pj_jobs;
    private String pj_work_form;
    private String pj_place;
    private int pj_pay;
    private Date pj_start;
    private int pj_day;
}
