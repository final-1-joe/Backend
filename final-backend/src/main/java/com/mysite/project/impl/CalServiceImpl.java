package com.mysite.project.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mysite.project.mapper.CalMapper;
import com.mysite.project.service.CalService;
import com.mysite.project.vo.CalVo;

@Service
public class CalServiceImpl implements CalService {
	
	private CalMapper mapper;

	public CalServiceImpl(CalMapper mapper) {
		super();
		this.mapper = mapper;
	}

	@Override
	public void insertSchedule(CalVo vo) {
		mapper.insertSchedule(vo);
	}

	@Override
	public List<CalVo> getScheduleList(CalVo vo) {
		List<CalVo> Vo = mapper.getScheduleList(vo);
		return Vo;
	}

	@Override
	public void updateSchedule(CalVo vo) {
		mapper.updateSchedule(vo);
	}

	@Override
	public void deleteSchedule(CalVo vo) {
		mapper.deleteSchedule(vo);
	}

}
