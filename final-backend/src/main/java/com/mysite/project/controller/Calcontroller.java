package com.mysite.project.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mysite.project.dto.schedule.Schedule_deleteDTO;
import com.mysite.project.dto.schedule.Schedule_insertDTO;
import com.mysite.project.dto.schedule.Schedule_updateDTO;
import com.mysite.project.impl.CalServiceImpl;
import com.mysite.project.vo.schedule.CalVo;

@RestController
@RequestMapping("/schedule")
public class Calcontroller {
	
	private CalServiceImpl impl;

	public Calcontroller(CalServiceImpl impl) {
		super();
		this.impl = impl;
	}
	
	@PostMapping("/insert")
	public void insertSchedule(@RequestBody Schedule_insertDTO insertdto) {
		impl.insertSchedule(insertdto);
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public List<CalVo> getScheduleList(CalVo vo) {
		List<CalVo> Vo = impl.getScheduleList(vo);
		return Vo;
	}

	@PatchMapping("/update")
	public void updateSchedule(@RequestBody Schedule_updateDTO updatedto) {
	    impl.updateSchedule(updatedto);
	    System.out.print(updatedto);
	}

	@DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") String scheduleKey) {
		  Schedule_deleteDTO deletedto = new Schedule_deleteDTO();
		    deletedto.setSchedule_key(scheduleKey);
        impl.deleteSchedule(deletedto);
    }

}
