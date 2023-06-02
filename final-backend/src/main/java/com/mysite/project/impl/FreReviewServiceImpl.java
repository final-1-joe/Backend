package com.mysite.project.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mysite.project.mapper.FreReviewMapper;
import com.mysite.project.service.FreReviewService;
import com.mysite.project.vo.FreReviewVO;

@Service
public class FreReviewServiceImpl implements FreReviewService {
	
	private FreReviewMapper mapper;
	
	public FreReviewServiceImpl(FreReviewMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public List<FreReviewVO> getReviewList(String fre_rv_target) {
		List<FreReviewVO> reviewList = mapper.getReviewList(fre_rv_target);
		return reviewList;
	}

	@Override
	public int insertReview(FreReviewVO review) {
		int res = mapper.insertReview(review);
		return res;
	}

	@Override
	public int updateReview(FreReviewVO review) {
		int res = mapper.updateReview(review);
		return res;
	}

	@Override
	public int deleteReview(int fre_rv_num) {
		int res = mapper.deleteReview(fre_rv_num);
		return res;
	}
	
	@Override
	public int getCount(FreReviewVO review) {
		int res = mapper.getCount(review);
		return res;
	}

	@Override
	public int getTotalScore(FreReviewVO review) {
		int res = mapper.getTotalScore(review);
		return res;
	}
}
