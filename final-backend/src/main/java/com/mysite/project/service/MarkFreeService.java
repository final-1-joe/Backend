package com.mysite.project.service;

import java.util.List;

import com.mysite.project.vo.MyMarkFreeVO;

public interface MarkFreeService {
	List<MyMarkFreeVO> selectMarkFree(String user_id);

}
