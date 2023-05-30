package com.mysite.project.service;

import java.util.HashMap;
import java.util.List;
import com.mysite.project.vo.MyPjStatusVO;

public interface MyPjStatusService {
	public List<MyPjStatusVO> selectOngoingPj(String user_id);
	public List<MyPjStatusVO> selectFreeOngoingPj(String user_id);
	public List<MyPjStatusVO> selectInprogressPj(String user_id);
	public List<MyPjStatusVO> selectApplyPj(String user_id);
	public List<MyPjStatusVO> selectFinishedPj(String user_id);
	public int updateCompletedPj(String user_id, int pj_num);
	public int deleteInprogressPj(String user_id, int pj_num);
	public HashMap<String, Object> selectClient(String user_id, int pj_num);
}
