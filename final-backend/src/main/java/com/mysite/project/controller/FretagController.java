package com.mysite.project.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysite.project.service.FretagService;
import com.mysite.project.vo.FretagVO;

@RequestMapping("/fretag")
@RestController
public class FretagController {
	private FretagService fretagService;
	
	public FretagController(FretagService fretagService) {
		this.fretagService = fretagService;
	}
	
	@RequestMapping("/select")
    public FretagVO getFT(@RequestBody FretagVO fretag) {
       return  this.fretagService.getFT(fretag);
    }

	@RequestMapping("/insert")
    public void insertFT(@RequestBody FretagVO fretag) {
        this.fretagService.insertFT(fretag);
    }
	
	@RequestMapping("/update")
	public void updateFT(@RequestBody FretagVO fretag) {
	    this.fretagService.updateFT(fretag);
	}
}
