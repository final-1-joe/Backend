package com.mysite.project.service;

import com.mysite.project.vo.USResumeVO;

public interface USResumeService {
	public USResumeVO getUSR(USResumeVO usresume);
	public void insert(USResumeVO usresume);
	public void update(USResumeVO usresume);
}
