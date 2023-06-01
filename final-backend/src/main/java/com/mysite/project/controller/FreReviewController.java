package com.mysite.project.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public List<FreReviewVO> getReviewList(@RequestParam("fre_rv_target") String fre_rv_target) {
		List<FreReviewVO> reviewList = reviewService.getReviewList(fre_rv_target);
		return reviewList;
	}

	@RequestMapping(value = "/frereview/write", method = RequestMethod.POST)
	@ResponseBody
	public int insertReview(@RequestBody FreReviewVO review) {
		int res = reviewService.insertReview(review);
		return res;
	}

	@RequestMapping(value = "/frereview/update", method = RequestMethod.POST)
	@ResponseBody
	public int updateReview(@RequestBody FreReviewVO review) {
		int res = reviewService.updateReview(review);
		return res;
	}

	@RequestMapping(value = "/frereview/delete", method = RequestMethod.GET)
	@ResponseBody
	public int deleteReview(@RequestParam("fre_rv_num") int fre_rv_num) {
		int res = reviewService.deleteReview(fre_rv_num);
		return res;
	}
	
	@RequestMapping(value = "/frereview/cnt", method = RequestMethod.GET)
	@ResponseBody
	public int getCount(FreReviewVO review) {
		int res = reviewService.getCount(review);
		return res;
	}

	@RequestMapping(value = "/frereview/tot", method = RequestMethod.GET)
	@ResponseBody
	public int getTotalScore(FreReviewVO review) {
		int res = reviewService.getTotalScore(review);
		return res;
	}
}
