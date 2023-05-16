package com.mysite.project.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysite.project.service.SBAnswerService;
import com.mysite.project.vo.SBAnswerVO;


@RequestMapping("/support/answer")
@RestController
public class SBAnswerController {
	
	private SBAnswerService sbanswerService;
	
	public SBAnswerController(SBAnswerService sbanswerService) {
		this.sbanswerService = sbanswerService;
	}

	
	@RequestMapping("/insert")
    public void questionCreate(@RequestBody SBAnswerVO sba) {
        this.sbanswerService.insert(sba);

    }
	
	@RequestMapping("/update")
	public void update(@RequestBody SBAnswerVO sba) {
	    this.sbanswerService.update(sba);
	}
	
	@RequestMapping("/delete")
    public void delete(@RequestBody SBAnswerVO sba) {
        this.sbanswerService.delete(sba);

    }


}
