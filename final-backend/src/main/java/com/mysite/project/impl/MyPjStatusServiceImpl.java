package com.mysite.project.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.mysite.project.mapper.MyPjStatusMapper;
import com.mysite.project.service.MyPjStatusService;
import com.mysite.project.vo.MyPjStatusVO;

@Service
public class MyPjStatusServiceImpl implements MyPjStatusService {

	MyPjStatusMapper mapper;
	
	public MyPjStatusServiceImpl (MyPjStatusMapper mapper) {
		this.mapper = mapper;
	}
	
	@Override
	public int applyPj(MyPjStatusVO vo) {
		int res = mapper.applyPj(vo);
		return res;
	}
	
	@Override
	public int modifyCompletedPj(int pj_num) {
		int res = mapper.modifyCompletedPj(pj_num);
		return res;
	}
	
	@Override
	public int modifyOngoingPj(int pj_num) {
		int res = mapper.modifyOngoingPj(pj_num);
		return res;
	}
	
	@Override
	public int modifyFinishedPj(int pj_num) {
		int res = mapper.modifyFinishedPj(pj_num);
		return res;
	}
	
	@Override
	public int updateCompletedFree(String user_id, int pj_num) {
		int res = mapper.updateCompletedFree(user_id, pj_num);
		return res;
	}
	
	@Override
	public int deletedFree(String user_id, int pj_num) {
		int res = mapper.deletedFree(user_id, pj_num);
		return res;
	}
	
	@Override
	public List<MyPjStatusVO> selectOngoingPj(String user_id) {
		List<MyPjStatusVO> ongoinglist = mapper.selectOngoingPj(user_id);
		return ongoinglist;
	}
	
	@Override
	public List<MyPjStatusVO> selectFreeOngoingPj(String user_id) {
		List<MyPjStatusVO> freeongoinglist = mapper.selectFreeOngoingPj(user_id);
		return freeongoinglist;
	}

	@Override
	public List<MyPjStatusVO> selectInprogressPj(String user_id) {
		List<MyPjStatusVO> inprogresslist = mapper.selectInprogressPj(user_id);
		return inprogresslist;
	}

	@Override
	public List<MyPjStatusVO> selectFinishedPj(String user_id) {
		List<MyPjStatusVO> finishedlist = mapper.selectFinishedPj(user_id);
		return finishedlist;
	}
	
	@Override
	public List<MyPjStatusVO> selectPjByClient(String user_id) {
		List<MyPjStatusVO> pjListByClient = mapper.selectPjByClient(user_id);
		return pjListByClient;
	}
	
	@Override
	public List<MyPjStatusVO> selectFreeByClient(String user_id, int pj_num) {
		List<MyPjStatusVO> freeListByClient = mapper.selectFreeByClient(user_id, pj_num);
		return freeListByClient;
	}

	@Override
	public int updateCompletedPj(String user_id, int pj_num) {
		int res = mapper.updateCompletedPj(user_id, pj_num);
		return res;
	}

	@Override
	public int deleteInprogressPj(String user_id, int pj_num) {
		int res = mapper.deleteInprogressPj(user_id, pj_num);
		return res;
	}
	
	@Override
	public HashMap<String, Object> selectClient(String user_id, int pj_num) {
		return mapper.selectClient(user_id, pj_num);
	}
	
	@Override
	public int countInprogress() {
		int res = mapper.countInprogress();
		return res;
	}
	
	@Override
	public int countCompleted() {
		int res = mapper.countCompleted();
		return res;
	}
	
	@Override
	public int countOngoing() {
		int res = mapper.countOngoing();
		return res;
	}
	
	@Override
	public int countFinished() {
		int res = mapper.countFinished();
		return res;
	}
}
