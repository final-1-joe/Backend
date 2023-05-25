package com.mysite.project.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysite.project.service.ProjectService;
import com.mysite.project.vo.ProjectVO;

@Controller
public class ProjectController {
	
	private ProjectService projectService;
	
	public ProjectController(ProjectService projectService) {
		this.projectService = projectService;
	}
	
	@RequestMapping(value = "/pjlist", method = RequestMethod.GET)
	@ResponseBody
	public List<ProjectVO> projectList() {
		List<ProjectVO> pjList = projectService.projectList();
		return pjList;
	}
	
	@RequestMapping(value = "/pjdetail", method = RequestMethod.GET)
	@ResponseBody
	public ProjectVO projectDetail(int pj_num) {
		ProjectVO vo = projectService.projectDetail(pj_num);
		return vo;
	}
	
	@RequestMapping(value = "/pjdetail/insert", method = RequestMethod.POST)
	@ResponseBody
	public int insertProject(ProjectVO project) {
		int res = projectService.insertProject(project);
		return res;
	}
	
	@RequestMapping(value = "/pjdetail/update", method = RequestMethod.POST)
	@ResponseBody
	public int updateProject(ProjectVO project) {
		int res = projectService.updateProject(project);
		return res;
	}
	
	@RequestMapping(value = "/pjdetail/delete", method = RequestMethod.GET)
	@ResponseBody
	public int deleteProject(ProjectVO project) {
		int res = projectService.deleteProject(project);
		return res;
	}

}
