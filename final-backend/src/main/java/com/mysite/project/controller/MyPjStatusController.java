package com.mysite.project.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/auth/freeongoingpj")
	public List<MyPjStatusVO> selectFreeOngoingPj(String user_id) {
		List<MyPjStatusVO> freeongoinglist = myPjStatusServiceImpl.selectFreeOngoingPj(user_id);
		return freeongoinglist;
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
	
	@GetMapping("/auth/pjlistClient")
	public List<MyPjStatusVO> selectPjByClient(String user_id) {
		List<MyPjStatusVO> pjListByClient = myPjStatusServiceImpl.selectPjByClient(user_id);
		return pjListByClient;
	}
	
	@PutMapping("/auth/updatecompleted")
	public int updateCompletedPj(@RequestBody MyPjStatusVO vo) {
		System.out.println("pj_num=>"+vo.getPj_num());
		int res = myPjStatusServiceImpl.updateCompletedPj(vo.getUser_id(), vo.getPj_num());
		return res;
	}

	@PostMapping("/auth/deleteinprogress")
	public int deleteInprogressPj(@RequestBody MyPjStatusVO vo) {
		int res = myPjStatusServiceImpl.deleteInprogressPj(vo.getUser_id(), vo.getPj_num());
		return res;
	}
	
	@GetMapping("/auth/connectdm")
	public ResponseEntity<HashMap<String, Object>> selectClient(@RequestParam("user_id")String user_id, @RequestParam("pj_num")int pj_num) {
		HashMap<String, Object> dmInfo = myPjStatusServiceImpl.selectClient(user_id, pj_num);
		return ResponseEntity.ok(dmInfo);
	}
	
	@GetMapping("/admin/countInprogress")
	public int countInprogress() {
		int res = myPjStatusServiceImpl.countInprogress();
		return res;
	}
	
	@GetMapping("/admin/countCompleted")
	public int countCompleted() {
		int res = myPjStatusServiceImpl.countCompleted();
		return res;
	}
	
	@GetMapping("/admin/countOngoing")
	public int countOngoing() {
		int res = myPjStatusServiceImpl.countOngoing();
		return res;
	}
	
	@GetMapping("/admin/countFinished")
	public int countFinished() {
		int res = myPjStatusServiceImpl.countFinished();
		return res;
	}
}
