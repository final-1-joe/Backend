package com.mysite.project.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.mysite.project.dto.schedule.Schedule_deleteDTO;
import com.mysite.project.dto.schedule.Schedule_insertDTO;
import com.mysite.project.dto.schedule.Schedule_updateDTO;
import com.mysite.project.vo.schedule.CalVo;

public interface CalService {
	public void insertSchedule(Schedule_insertDTO insertdto);
	List<CalVo> getScheduleList(CalVo vo);
	public void updateSchedule(Schedule_updateDTO updatedto);
	public void deleteSchedule(Schedule_deleteDTO deletedto);
}
