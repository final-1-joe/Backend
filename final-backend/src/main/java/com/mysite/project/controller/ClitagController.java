package com.mysite.project.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysite.project.service.ClitagService;
import com.mysite.project.vo.ClitagVO;

@RequestMapping("/clitag")
@RestController
public class ClitagController {
	private ClitagService clitagService;
	
	public ClitagController(ClitagService clitagService) {
		this.clitagService = clitagService;
	}
	
	@RequestMapping("/select")
    public ClitagVO getFT(@RequestBody ClitagVO clitag) {
       return  this.clitagService.getCT(clitag);
    }

	@RequestMapping("/insert")
    public void insertFT(@RequestBody ClitagVO clitag) {
        this.clitagService.insertCT(clitag);
    }
	
	@RequestMapping("/update")
	public void updateFT(@RequestBody ClitagVO clitag) {
	    this.clitagService.updateCT(clitag);
	}
}
