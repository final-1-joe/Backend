package com.mysite.project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mysite.project.impl.CalServiceImpl;
import com.mysite.project.vo.CalVo;

@RestController
@RequestMapping("/schedule")
public class Calcontroller {
	
	private CalServiceImpl impl;

	public Calcontroller(CalServiceImpl impl) {
		super();
		this.impl = impl;
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insertSchedule(CalVo vo) {
		impl.insertSchedule(vo);
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public List<CalVo> getScheduleList(CalVo vo) {
		List<CalVo> Vo = impl.getScheduleList(vo);
		return Vo;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void updateSchedule(CalVo vo) {
		impl.updateSchedule(vo);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void deleteSchedule(CalVo vo) {
		impl.deleteSchedule(vo);
	}

}
