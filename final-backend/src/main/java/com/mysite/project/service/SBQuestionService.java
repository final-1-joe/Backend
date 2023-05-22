package com.mysite.project.service;

import java.util.List;

import com.mysite.project.vo.SBQuestionVO;

public interface SBQuestionService {
	public List<SBQuestionVO> getList(int page,int pageSize);
	public List<SBQuestionVO> getAdList(int page,int pageSize);
	public int getCount();
	public int getAdCount();
	public SBQuestionVO getQuestion(SBQuestionVO sbquesion);
	public SBQuestionVO getComment(SBQuestionVO sbquesion);
	public void insert(SBQuestionVO sbquesion);
	public void update(SBQuestionVO sbquesion);
	public void delete(SBQuestionVO sbquesion);
}
