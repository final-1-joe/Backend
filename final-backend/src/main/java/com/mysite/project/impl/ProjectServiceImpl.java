package com.mysite.project.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mysite.project.mapper.ProjectMapper;
import com.mysite.project.service.ProjectService;
import com.mysite.project.vo.ProjectVO;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	private ProjectMapper mapper;
	
	public ProjectServiceImpl(ProjectMapper mapper) {
		this.mapper = mapper;
	}
	
	@Override
	public List<ProjectVO> projectList() {
		List<ProjectVO> pjList = mapper.projectList();
		return pjList;
	}
	
	@Override
	public List<ProjectVO> projectListTag(ProjectVO project) {
		return mapper.projectListTag(project);
	}
	
	@Override
	public List<ProjectVO> projectTag(ProjectVO project) {
		return mapper.projectTag(project);
	}
	
	@Override
	public ProjectVO projectDetail(int pj_num) {
		ProjectVO vo = mapper.projectDetail(pj_num);
		return vo;
	}

	@Override
	public int insertProject(ProjectVO project) {
		int res = mapper.insertProject(project);
		return res;
	}

	@Override
	public int updateProject(ProjectVO project) {
		int res = mapper.updateProject(project);
		return res;
	}

	@Override
	public int deleteProject(ProjectVO project) {
		int res = mapper.deleteProject(project);
		return res;
	}

	@Override
	public int pjjgCount(ProjectVO project) {
		return mapper.pjjgCount(project);
	}

}
