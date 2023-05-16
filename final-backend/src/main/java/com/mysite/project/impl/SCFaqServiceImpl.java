package com.mysite.project.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mysite.project.mapper.SCFaqMapper;
import com.mysite.project.service.SCFaqService;
import com.mysite.project.vo.SCFaqVO;

@Service("scfaqService")
public class SCFaqServiceImpl implements SCFaqService {
	
	private SCFaqMapper mapper;
	
	public SCFaqServiceImpl(SCFaqMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public List<SCFaqVO> getFAQ() {
		List<SCFaqVO> faq = mapper.getFAQ();
		return faq;
	}

	@Override
    public void insert(SCFaqVO faq) {
		mapper.insertFAQ(faq);
    }
	
	@Override
    public void update(SCFaqVO faq) {
		mapper.updateFAQ(faq);
    }
	@Override
    public void delete(SCFaqVO faq) {
		mapper.deleteFAQ(faq);
    }

}
