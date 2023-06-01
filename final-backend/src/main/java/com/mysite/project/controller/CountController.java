package com.mysite.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mysite.project.impl.CountServiceImpl;

@RestController
@RequestMapping("/count")
public class CountController {
	
	private CountServiceImpl impl;

	public CountController(CountServiceImpl impl) {
		super();
		this.impl = impl;
	}
	
	@GetMapping("/start")
	public int countPjStart(@RequestParam("pj_start") String pj_start) {
		int res = impl.countPjStart(pj_start);
		return res;
	}
	
	@GetMapping("/end")
	public int countPjEnd(@RequestParam("pj_end") String pj_end) {
		int res = impl.countPjEnd(pj_end);
		return res;
	}

}
