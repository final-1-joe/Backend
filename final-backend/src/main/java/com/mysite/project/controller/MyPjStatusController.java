package com.mysite.project.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@PostMapping("/apply")
	public int applyPj(@RequestBody MyPjStatusVO vo) {
		int res = myPjStatusServiceImpl.applyPj(vo);
		return res;
	}
	//지원하기
	
	@PostMapping("/auth/modifycompleted")
	public int modifyCompletedPj(@RequestBody MyPjStatusVO vo) {
		int res = myPjStatusServiceImpl.modifyCompletedPj(vo.getPj_num());
		return res;
	}
	//status를 모집마감(completed)로 바꿈
	
	@PostMapping("/auth/modifyongoing")
	public int modifyOngoingPj(@RequestBody MyPjStatusVO vo) {
		int res = myPjStatusServiceImpl.modifyOngoingPj(vo.getPj_num());
		return res;
	}
	//status를 진행중(ongoing)으로 바꿈
	
	@PostMapping("/auth/modifyfinished")
	public int modifyFinishedPj(@RequestBody MyPjStatusVO vo) {
		int res = myPjStatusServiceImpl.modifyFinishedPj(vo.getPj_num());
		return res;
	}
	//status를 완료(finished)로 바꿈, completed(모집완료)는 하단에 있음
	
	@PostMapping("/auth/modifycompletedfree")
	public int updateCompletedFree(@RequestBody MyPjStatusVO vo) {
		int res = myPjStatusServiceImpl.updateCompletedFree(vo.getUser_id(), vo.getPj_num());
		return res;
	}
	
	@PostMapping("/auth/deletedfree")
	public int deletedFree(@RequestBody MyPjStatusVO vo) {
		int res = myPjStatusServiceImpl.deletedFree(vo.getUser_id(), vo.getPj_num());
		return res;
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
	
	@RequestMapping(value="/auth/freelistClient")
	public List<MyPjStatusVO> selectFreeByClient(@RequestBody MyPjStatusVO vo) {
		List<MyPjStatusVO> freeListByClient = myPjStatusServiceImpl.selectFreeByClient(vo.getUser_id(), vo.getPj_num());
		return freeListByClient;
	}
	
	@PutMapping("/auth/updatecompleted")
	public int updateCompletedPj(@RequestBody MyPjStatusVO vo) {
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
