package com.mysite.project.vo;

import java.time.LocalDate;

import lombok.Data;

@Data
public class SCFaqVO {

    private int scnum;
    private String scquestion;
    private String scanswer;
    private String scwriter;
    private LocalDate sccreateDate;
}
