package com.mysite.project.impl;

import org.springframework.stereotype.Service;

import com.mysite.project.mapper.CountMapper;
import com.mysite.project.service.CountService;
@Service
public class CountServiceImpl implements CountService{
	
	private CountMapper mapper;

	public CountServiceImpl(CountMapper mapper) {
		super();
		this.mapper = mapper;
	}

	@Override
	public int countPjStart(String pj_start) {
		int res = mapper.countPjStart(pj_start);
		return res;
	}

	@Override
	public int countPjEnd(String pj_end) {
		int res = mapper.countPjEnd(pj_end);
		return res;
	}

}
