package com.mysite.project.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public List<PjReviewVO> getReviewList(@RequestParam("pj_num") int pj_num) {
		List<PjReviewVO> reviewList = reviewService.getReviewList(pj_num);
		return reviewList;
	}

	@RequestMapping(value = "/pjreview/insert", method = RequestMethod.POST)
	@ResponseBody
	public int insertReview(@RequestBody PjReviewVO review) {
		int res = reviewService.insertReview(review);
		return res;
	}

	@RequestMapping(value = "/pjreview/update", method = RequestMethod.POST)
	@ResponseBody
	public int updateReview(@RequestBody PjReviewVO review) {
		int res = reviewService.updateReview(review);
		return res;
	}

	@RequestMapping(value = "/pjreview/delete", method = RequestMethod.GET)
	@ResponseBody
	public int deleteReview(@RequestParam("pj_rv_num") int pj_rv_num) {
		int res = reviewService.deleteReview(pj_rv_num);
		return res;
	}
	
	@RequestMapping(value = "/pjreview/cnt", method = RequestMethod.GET)
	@ResponseBody
	public int getCount(PjReviewVO review) {
		int res = reviewService.getCount(review);
		return res;
	}
	
	@RequestMapping(value = "/pjreview/tot", method = RequestMethod.GET)
	@ResponseBody
	public int getTotalScore(PjReviewVO review) {
		int res = reviewService.getTotalScore(review);
		return res;
	}

}
