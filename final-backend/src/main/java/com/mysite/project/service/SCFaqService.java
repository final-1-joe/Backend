package com.mysite.project.service;

import java.util.List;

import com.mysite.project.vo.SCFaqVO;

public interface SCFaqService {
	public List<SCFaqVO> getFAQ();
	public void insert(SCFaqVO faq);
	public void update(SCFaqVO faq);
	public void delete(SCFaqVO faq);
}
