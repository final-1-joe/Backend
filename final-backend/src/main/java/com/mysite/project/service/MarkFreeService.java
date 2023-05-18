package com.mysite.project.service;

import java.util.List;

import com.mysite.project.vo.MarkFreeVO;

public interface MarkFreeService {
	public List<MarkFreeVO> selectMarkFree(String user_id);

}
