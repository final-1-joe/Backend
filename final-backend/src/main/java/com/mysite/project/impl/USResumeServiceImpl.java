package com.mysite.project.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mysite.project.mapper.USResumeMapper;
import com.mysite.project.service.USResumeService;
import com.mysite.project.vo.USResumeVO;

@Service("usresumeService")
public class USResumeServiceImpl implements USResumeService {
	
	private USResumeMapper usrmapper;
	
	public USResumeServiceImpl(USResumeMapper usrmapper) {
		this.usrmapper = usrmapper;
	}
	
	@Override
	public USResumeVO getUSR(USResumeVO usresume) {
		return usrmapper.getUSR(usresume);
	}

	@Override
	public void insert(USResumeVO usresume) {
		usrmapper.insertUSR(usresume);
	}

	@Override
	public void update(USResumeVO usresume) {
		usrmapper.updateUSR(usresume);
	}

	@Override
	public List<USResumeVO> USRList(USResumeVO usresume) {
		return usrmapper.USRList(usresume);
	}
	


	@Override
	public int usjgCount(USResumeVO usresume) {
		
		return usrmapper.usjgCount(usresume);
	}

	@Override
	public List<USResumeVO> USRTag(USResumeVO usresume) {
		return usrmapper.USRTag(usresume);
	}

	@Override
	public void delete(USResumeVO usresume) {
		usrmapper.deleteUSR(usresume);
		
	}

}
