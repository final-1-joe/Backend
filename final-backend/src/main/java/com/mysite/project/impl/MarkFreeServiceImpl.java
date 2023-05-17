package com.mysite.project.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mysite.project.mapper.MarkFreeMapper;
import com.mysite.project.service.MarkFreeService;
import com.mysite.project.vo.MarkFreeVO;

@Service
public class MarkFreeServiceImpl implements MarkFreeService {

	MarkFreeMapper mapper;
	
	public MarkFreeServiceImpl (MarkFreeMapper mapper) {
		this.mapper = mapper;
	}
	
	@Override
	public List<MarkFreeVO> selectMarkFree(String user_id) {
		List<MarkFreeVO> markFreeList = mapper.selectMarkFree(user_id);
		return markFreeList;
	}

}
