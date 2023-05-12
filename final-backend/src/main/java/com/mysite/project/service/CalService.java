package com.mysite.project.service;

import java.util.List;

import com.mysite.project.vo.CalVo;

public interface CalService {
	public void insertSchedule(CalVo vo);
	List<CalVo> getScheduleList(CalVo vo);
	public void updateSchedule(CalVo vo);
	public void deleteSchedule(CalVo vo);
}
