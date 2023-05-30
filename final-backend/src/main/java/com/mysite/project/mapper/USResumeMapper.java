package com.mysite.project.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.mysite.project.vo.USResumeVO;

@Mapper
public interface USResumeMapper {
	
	public USResumeVO getUSR(USResumeVO usresume);

    public void insertUSR(USResumeVO usresume);

    public void updateUSR(USResumeVO usresume);

}
