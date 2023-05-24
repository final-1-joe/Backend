package com.mysite.project.service;

import java.util.List;

import com.mysite.project.vo.SBQuestionVO;

public interface SBQuestionService {
	public List<SBQuestionVO> getList(int page,int pageSize);
	public List<SBQuestionVO> getNAList(int page,int pageSize);
	public List<SBQuestionVO> getAList(int page,int pageSize);
	public int getCount();
	public int getNACount();
	public int getACount();
	public SBQuestionVO getQuestion(SBQuestionVO sbquesion);
	public SBQuestionVO getComment(SBQuestionVO sbquesion);
	public void insert(SBQuestionVO sbquesion);
	public void update(SBQuestionVO sbquesion);
	public void delete(SBQuestionVO sbquesion);
	public List<SBQuestionVO> searchSubject(SBQuestionVO sbquesion);
	public List<SBQuestionVO> searchContent(SBQuestionVO sbquesion);
}
