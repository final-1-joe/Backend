package com.mysite.project.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class FretagVO {
	private String user_id;
    private String fre_jg;
    private String fre_job;
    private String fre_ws;
    private String fre_wt;
    private int fre_pay;
    private Date fre_stdy;
    private int fre_mth;
}
