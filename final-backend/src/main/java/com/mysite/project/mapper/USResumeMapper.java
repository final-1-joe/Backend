package com.mysite.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mysite.project.vo.USResumeVO;

@Mapper
public interface USResumeMapper {
	
	public List<USResumeVO> USRList(USResumeVO usresume);
	
	public List<USResumeVO> USRTag(USResumeVO usresume);
	
	public USResumeVO getUSR(USResumeVO usresume);

    public void insertUSR(USResumeVO usresume);

    public void updateUSR(USResumeVO usresume);
    
    public void deleteUSR(USResumeVO usresume);
    
    public int usjgCount(USResumeVO usresume);

}
