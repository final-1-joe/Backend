package com.mysite.project.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mysite.project.mapper.MarkPjMapper;
import com.mysite.project.service.MarkPjService;
import com.mysite.project.vo.MarkPjVO;
import com.mysite.project.vo.MyMarkPjVO;

@Service
public class MarkPjServiceImpl implements MarkPjService {

	MarkPjMapper mapper;
	
	public MarkPjServiceImpl (MarkPjMapper mapper) {
		this.mapper = mapper;
	}
	
	@Override
	public List<MyMarkPjVO> selectMarkPj(String user_id) {
		List<MyMarkPjVO> markPjList = mapper.selectMarkPj(user_id);
		return markPjList;
	}
	
	@Override
	public int registerMarkPj(MarkPjVO vo) {
		int res = mapper.registerMarkPj(vo);
		return res;
	}

}
