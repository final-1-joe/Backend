package com.mysite.project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysite.project.service.SCFaqService;
import com.mysite.project.vo.SCFaqVO;

@RequestMapping("/support/faq")
@RestController
public class SCFaqController {
	
	private SCFaqService scfaqService;

	
	public SCFaqController(SCFaqService scfaqService) {
		this.scfaqService = scfaqService;
	}
	
	@RequestMapping("/select")
    public List<SCFaqVO> getFAQ() {
		List<SCFaqVO> faq =this.scfaqService.getFAQ();
       return faq;
    }

	
	@RequestMapping("/insert")
    public void questionCreate(@RequestBody SCFaqVO faq) {
        this.scfaqService.insert(faq);

    }
	
	@RequestMapping("/update")
	public void update(@RequestBody SCFaqVO faq) {
	    this.scfaqService.update(faq);
	}
	
	@RequestMapping("/delete")
    public void delete(@RequestBody SCFaqVO faq) {
        this.scfaqService.delete(faq);

    }


}
