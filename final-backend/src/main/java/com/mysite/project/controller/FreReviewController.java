package com.mysite.project.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysite.project.service.FreReviewService;
import com.mysite.project.vo.FreReviewVO;

@Controller
public class FreReviewController {

	private FreReviewService reviewService;
	
	public FreReviewController(FreReviewService reviewService) {
		this.reviewService = reviewService;
	}
	
	@RequestMapping(value = "/frereview/list", method = RequestMethod.GET)
	@ResponseBody
	public List<FreReviewVO> getReviewList() {
		List<FreReviewVO> reviewList = reviewService.getReviewList();
		return reviewList;
	}

	@RequestMapping(value = "/frereview/insert", method = RequestMethod.POST)
	@ResponseBody
	public int insertReview(FreReviewVO review) {
		int res = reviewService.insertReview(review);
		return res;
	}

	@RequestMapping(value = "/frereview/update", method = RequestMethod.POST)
	@ResponseBody
	public int updateReview(FreReviewVO review) {
		int res = reviewService.updateReview(review);
		return res;
	}

	@RequestMapping(value = "/frereview/delete", method = RequestMethod.GET)
	@ResponseBody
	public int deleteReview(FreReviewVO review) {
		int res = reviewService.deleteReview(review);
		return res;
	}
}
