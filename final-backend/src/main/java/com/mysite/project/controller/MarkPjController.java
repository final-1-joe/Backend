package com.mysite.project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mysite.project.impl.MarkPjServiceImpl;
import com.mysite.project.vo.MarkPjVO;
import com.mysite.project.vo.MyMarkPjVO;

@RestController
public class MarkPjController {

	MarkPjServiceImpl markPjServiceImpl;
	
	public MarkPjController (MarkPjServiceImpl markPjServiceImpl) {
		this.markPjServiceImpl = markPjServiceImpl;
	}
	
	@GetMapping("/auth/markpjlist")
	public List<MyMarkPjVO> selectMarkPj(@RequestParam("user_id") String user_id) {
		List<MyMarkPjVO> markPjList = markPjServiceImpl.selectMarkPj(user_id);
		return markPjList;
	}
	
	@PostMapping("/auth/register/pj")
	public int registerMarkPj(@RequestBody MarkPjVO vo) {
		int res = markPjServiceImpl.registerMarkPj(vo);
		return res;
	}
}
