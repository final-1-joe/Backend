package com.mysite.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mysite.project.vo.USResumeVO;

@Mapper
public interface USResumeMapper {
	
	public List<USResumeVO> USRList(USResumeVO usresume);
	
	public USResumeVO getUSR(USResumeVO usresume);

    public void insertUSR(USResumeVO usresume);

    public void updateUSR(USResumeVO usresume);
    
    public int usjgCount(USResumeVO usresume);

}
