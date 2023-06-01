package com.mysite.project.service;

import java.util.List;

import com.mysite.project.vo.ProjectVO;

public interface ProjectService {

	public List<ProjectVO> projectList();
	public List<ProjectVO> projectListTag(ProjectVO project);
	public ProjectVO projectDetail(int pj_num);
	public int insertProject(ProjectVO project);
	public int updateProject(ProjectVO project);
	public int deleteProject(ProjectVO project);
	
}
