package com.mysite.project.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mysite.project.dto.schedule.Schedule_deleteDTO;
import com.mysite.project.dto.schedule.Schedule_insertDTO;
import com.mysite.project.dto.schedule.Schedule_updateDTO;
import com.mysite.project.mapper.CalMapper;
import com.mysite.project.service.CalService;
import com.mysite.project.vo.schedule.CalVo;

@Service
public class CalServiceImpl implements CalService {
	
	private CalMapper mapper;

	public CalServiceImpl(CalMapper mapper) {
		super();
		this.mapper = mapper;
	}

	@Override
	public void insertSchedule(Schedule_insertDTO insertdto) {
		mapper.insertSchedule(insertdto);
	}

	@Override
	public List<CalVo> getScheduleList(CalVo vo) {
		List<CalVo> Vo = mapper.getScheduleList(vo);
		return Vo;
	}

	@Override
	public void updateSchedule(Schedule_updateDTO updatedto) {
		mapper.updateSchedule(updatedto);
	}

	@Override
	public void deleteSchedule(Schedule_deleteDTO deletedto) {
		mapper.deleteSchedule(deletedto);
	}

}
