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
  
	@RequestMapping(value = "/pjlisttag")
	@ResponseBody
	public List<ProjectVO> projectListTag(@RequestBody ProjectVO project) {
	    List<ProjectVO> pjList = projectService.projectListTag(project);
	    return pjList;
	}
  
  @RequestMapping(value = "/pjtag")
	@ResponseBody
	public List<ProjectVO> projectTag(@RequestBody ProjectVO project) {
	    List<ProjectVO> pjList = projectService.projectTag(project);
	    return pjList;
	}
  
	@RequestMapping(value = "/pjjgcount")
	@ResponseBody
	public int pjjgCount(@RequestBody ProjectVO project) {
		System.out.print(project);
		return projectService.pjjgCount(project);
	}
	
	@RequestMapping(value = "/pjdetail/insert", method = RequestMethod.POST)
	@ResponseBody
	public int insertProject(@RequestBody ProjectVO project) {
		int res = projectService.insertProject(project);
		return res;
	}
	
	@RequestMapping(value = "/pjdetail/update", method = RequestMethod.POST)
	@ResponseBody
	public int updateProject(@RequestBody ProjectVO project) {
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
