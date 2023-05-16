package com.mysite.project.vo;

import java.time.LocalDate;

import lombok.Data;

@Data
public class SBAnswerVO {

    private int sbanum;
    private String sbaanswer;
    private String sbawriter;
    private LocalDate sbacreateDate;
    private int sbquestion_id;
}
