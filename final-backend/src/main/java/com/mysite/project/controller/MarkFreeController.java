package com.mysite.project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mysite.project.impl.MarkFreeServiceImpl;
import com.mysite.project.vo.MarkFreeVO;

@RestController
public class MarkFreeController {

	MarkFreeServiceImpl markFreeServiceImpl;
	
	public MarkFreeController (MarkFreeServiceImpl markFreeServiceImpl) {
		this.markFreeServiceImpl = markFreeServiceImpl;
	}
	
	@GetMapping("/api/markfreelist")
	public List<MarkFreeVO> selectMarkFree(@RequestParam("user_id") String user_id) {
		List<MarkFreeVO> markFreeList = markFreeServiceImpl.selectMarkFree(user_id);
		return markFreeList;
	}
}
