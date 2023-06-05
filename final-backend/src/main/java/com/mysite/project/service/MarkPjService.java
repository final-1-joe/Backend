package com.mysite.project.service;

import java.util.List;

import com.mysite.project.vo.MarkPjVO;
import com.mysite.project.vo.MyMarkPjVO;

public interface MarkPjService {
	public List<MyMarkPjVO> selectMarkPj(String user_id);
	public int registerMarkPj(MarkPjVO vo);
}
