package com.mysite.project.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysite.project.service.PjReviewService;
import com.mysite.project.vo.PjReviewVO;

@Controller
public class PjReviewController {
	
	private PjReviewService reviewService;
	
	public PjReviewController(PjReviewService reviewService) {
		this.reviewService = reviewService;
	}
	
	@RequestMapping(value = "/pjreview/list", method = RequestMethod.GET)
	@ResponseBody
	public List<PjReviewVO> getReviewList() {
		List<PjReviewVO> reviewList = reviewService.getReviewList();
		return reviewList;
	}


	@RequestMapping(value = "/pjreview/insert", method = RequestMethod.POST)
	@ResponseBody
	public int insertReview(PjReviewVO review) {
		int res = reviewService.insertReview(review);
		return res;
	}

	@RequestMapping(value = "/pjreview/update", method = RequestMethod.POST)
	@ResponseBody
	public int updateReview(PjReviewVO review) {
		int res = reviewService.updateReview(review);
		return res;
	}

	@RequestMapping(value = "/pjreview/delete", method = RequestMethod.GET)
	@ResponseBody
	public int deleteReview(PjReviewVO review) {
		int res = reviewService.deleteReview(review);
		return res;
	}

}
