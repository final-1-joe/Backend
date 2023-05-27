package com.mysite.project.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping(value = "/pjlist/pjdetail", method = RequestMethod.GET)
	@ResponseBody
	public ProjectVO projectDetail(int pj_num) {
		ProjectVO vo = projectService.projectDetail(pj_num);
		return vo;
	}
	
	@RequestMapping(value = "/pjdetail/insert", method = RequestMethod.POST)
	@ResponseBody
	public int insertProject(@RequestBody ProjectVO project) {
		System.out.println("pj_title:" + project.getPj_title());
		System.out.println("pj_corpname:" + project.getPj_corpname());
		System.out.println("pj_content:" + project.getPj_content());
		System.out.println("pj_pay:" + project.getPj_pay());
		System.out.println("pj_start:" + project.getPj_start());
		System.out.println("pj_period:" + project.getPj_period());
		System.out.println("pj_day:" + project.getPj_day());
		System.out.println("pj_work_form:" + project.getPj_work_form());
		System.out.println("pj_place:" + project.getPj_place());
		System.out.println("pj_job:" + project.getPj_job());
		System.out.println("pj_skill:" + project.getPj_skill());
		System.out.println("pj_pick:" + project.getPj_pick());

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
