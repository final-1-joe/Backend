package com.mysite.project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mysite.project.impl.MarkPjServiceImpl;
import com.mysite.project.vo.MarkPjVO;

@RestController
public class MarkPjController {

	MarkPjServiceImpl markPjServiceImpl;
	
	public MarkPjController (MarkPjServiceImpl markPjServiceImpl) {
		this.markPjServiceImpl = markPjServiceImpl;
	}
	
	@GetMapping("/auth/markpjlist")
	public List<MarkPjVO> selectMarkPj(@RequestParam("user_id")String user_id) {
		List<MarkPjVO> markPjList = markPjServiceImpl.selectMarkPj(user_id);
		return markPjList;
	}
}
