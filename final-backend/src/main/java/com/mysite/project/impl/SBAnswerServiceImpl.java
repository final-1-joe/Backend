package com.mysite.project.impl;

import org.springframework.stereotype.Service;

import com.mysite.project.mapper.SBAnswerMapper;
import com.mysite.project.service.SBAnswerService;
import com.mysite.project.vo.SBAnswerVO;

@Service("sbanswerService")
public class SBAnswerServiceImpl implements SBAnswerService {
	
	private SBAnswerMapper mapper;
	
	public SBAnswerServiceImpl(SBAnswerMapper mapper) {
		this.mapper = mapper;
	}
	
	@Override
    public void insert(SBAnswerVO sba) {
		mapper.insertSBA(sba);
    }
	
	@Override
    public void update(SBAnswerVO sba) {
		mapper.updateSBA(sba);
    }
	@Override
    public void delete(SBAnswerVO sba) {
		mapper.deleteSBA(sba);
    }



}
