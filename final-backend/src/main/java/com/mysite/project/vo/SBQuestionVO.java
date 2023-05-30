package com.mysite.project.vo;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class SBQuestionVO {
	private int sbqnum;
    private String sbqsubject;
    private String sbqcontent;
    private String sbqwriter;
    private LocalDate sbqcreateDate;
    private List<SBAnswerVO> answerList;
}
