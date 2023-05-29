package com.mysite.project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysite.project.impl.MyPjStatusServiceImpl;
import com.mysite.project.vo.MyPjStatusVO;

@RestController
public class MyPjStatusController {

	MyPjStatusServiceImpl myPjStatusServiceImpl;
	
	public MyPjStatusController (MyPjStatusServiceImpl myPjStatusServiceImpl) {
		this.myPjStatusServiceImpl = myPjStatusServiceImpl;
	}
	
	@GetMapping("/auth/ongoingpj")
	public List<MyPjStatusVO> selectOngoingPj(String user_id) {
		List<MyPjStatusVO> ongoinglist = myPjStatusServiceImpl.selectOngoingPj(user_id);
		return ongoinglist;
	}

	@GetMapping("/auth/inprogresspj")
	public List<MyPjStatusVO> selectInprogressPj(String user_id) {
		List<MyPjStatusVO> inprogresslist = myPjStatusServiceImpl.selectInprogressPj(user_id);
		return inprogresslist;
	}

	@GetMapping("/auth/applypj")
	public List<MyPjStatusVO> selectApplyPj(String user_id) {
		List<MyPjStatusVO> applylist = myPjStatusServiceImpl.selectApplyPj(user_id);
		return applylist;
	}

	@GetMapping("/auth/finishedpj")
	public List<MyPjStatusVO> selectFinishedPj(String user_id) {
		List<MyPjStatusVO> finishedlist = myPjStatusServiceImpl.selectFinishedPj(user_id);
		return finishedlist;
	}

	@PutMapping("/auth/updatecompleted")
	public int updateCompletedPj(String user_id, int pj_num) {
		int res = myPjStatusServiceImpl.updateCompletedPj(user_id, pj_num);
		return res;
	}

	@PostMapping("/auth/deleteinprogress")
	public int deleteInprogressPj(String user_id, int pj_num) {
		int res = myPjStatusServiceImpl.deleteInprogressPj(user_id, pj_num);
		return res;
	}
}
