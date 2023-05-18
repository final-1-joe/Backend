package com.mysite.project.service;

import java.util.List;

import com.mysite.project.vo.MarkPjVO;

public interface MarkPjService {
	public List<MarkPjVO> selectMarkPj(String user_id);
}
