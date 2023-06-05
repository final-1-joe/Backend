package com.mysite.project.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mysite.project.mapper.MarkFreeMapper;
import com.mysite.project.service.MarkFreeService;
import com.mysite.project.vo.MarkFreeVO;
import com.mysite.project.vo.MyMarkFreeVO;

@Service
public class MarkFreeServiceImpl implements MarkFreeService {

	MarkFreeMapper mapper;
	
	public MarkFreeServiceImpl (MarkFreeMapper mapper) {
		this.mapper = mapper;
	}
	
	@Override
	public List<MyMarkFreeVO> selectMarkFree(String user_id) {
		List<MyMarkFreeVO> markFreeList = mapper.selectMarkFree(user_id);
		return markFreeList;
	}

	@Override
	public int registerMarkFree(MarkFreeVO vo) {
		int res = mapper.registerMarkFree(vo);
		return res;
	}
}
