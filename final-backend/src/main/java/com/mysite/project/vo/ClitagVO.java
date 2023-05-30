package com.mysite.project.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class ClitagVO {
	private String user_id;
    private String cli_jg;
    private String cli_job;
    private String cli_skill;
    private String cli_js;
    private String cli_ws;
    private String cli_wt;
    private int cli_pay;
}
