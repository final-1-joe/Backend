package com.mysite.project.service;

import java.util.List;

import com.mysite.project.vo.USResumeVO;
import com.mysite.project.vo.UserTagVO;

public interface USResumeService {
	public List<USResumeVO> USRList(USResumeVO usresume);
	public List<USResumeVO> USRTag(USResumeVO usresume);
	public USResumeVO getUSR(USResumeVO usresume);
	public void insert(USResumeVO usresume);
	public void update(USResumeVO usresume);
	public int usjgCount(USResumeVO usresume);
}
