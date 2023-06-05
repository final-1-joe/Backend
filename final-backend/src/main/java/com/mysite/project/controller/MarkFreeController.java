package com.mysite.project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mysite.project.impl.MarkFreeServiceImpl;
import com.mysite.project.vo.MarkFreeVO;
import com.mysite.project.vo.MyMarkFreeVO;

@RestController
public class MarkFreeController {

	MarkFreeServiceImpl markFreeServiceImpl;
	
	public MarkFreeController (MarkFreeServiceImpl markFreeServiceImpl) {
		this.markFreeServiceImpl = markFreeServiceImpl;
	}
	
	@GetMapping("/auth/markfreelist")
	public List<MyMarkFreeVO> selectMarkFree(@RequestParam("user_id") String user_id) {
		List<MyMarkFreeVO> markFreeList = markFreeServiceImpl.selectMarkFree(user_id);
		return markFreeList;
	}
	
	@PostMapping("/auth/register/free")
	public int registerMarkFree(@RequestBody MarkFreeVO vo) {
		int res = markFreeServiceImpl.registerMarkFree(vo);
		return res;
	}
}
