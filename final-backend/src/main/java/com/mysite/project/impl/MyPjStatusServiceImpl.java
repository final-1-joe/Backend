package com.mysite.project.impl;

import java.util.List;

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
	public List<MyPjStatusVO> selectOngoingPj(String user_id) {
		List<MyPjStatusVO> ongoinglist = mapper.selectOngoingPj(user_id);
		return ongoinglist;
	}

	@Override
	public List<MyPjStatusVO> selectInprogressPj(String user_id) {
		List<MyPjStatusVO> inprogresslist = mapper.selectInprogressPj(user_id);
		return inprogresslist;
	}

	@Override
	public List<MyPjStatusVO> selectApplyPj(String user_id) {
		List<MyPjStatusVO> applylist = mapper.selectApplyPj(user_id);
		return applylist;
	}

	@Override
	public List<MyPjStatusVO> selectFinishedPj(String user_id) {
		List<MyPjStatusVO> finishedlist = mapper.selectFinishedPj(user_id);
		return finishedlist;
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

}
