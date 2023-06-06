package com.mysite.project.service;

import java.util.HashMap;
import java.util.List;

import com.mysite.project.vo.MyPjStatusVO;

public interface MyPjStatusService {
	public int applyPj(MyPjStatusVO vo);
	public int modifyCompletedPj(int pj_num);
	public int modifyOngoingPj(int pj_num);
	public int modifyFinishedPj(int pj_num);
	public int updateCompletedFree(String user_id, int pj_num);
	public int deletedFree(String user_id, int pj_num);
	public List<MyPjStatusVO> selectOngoingPj(String user_id);
	public List<MyPjStatusVO> selectFreeOngoingPj(String user_id);
	public List<MyPjStatusVO> selectInprogressPj(String user_id);
	public List<MyPjStatusVO> selectFinishedPj(String user_id);
	public List<MyPjStatusVO> selectPjByClient(String user_id);
	public List<MyPjStatusVO> selectFreeByClient(String user_id, int pj_num);
	public int updateCompletedPj(String user_id, int pj_num);
	public int deleteInprogressPj(String user_id, int pj_num);
	public HashMap<String, Object> selectClient(String user_id, int pj_num);
	public int countInprogress();
	public int countCompleted();
	public int countOngoing();
	public int countFinished();
}
