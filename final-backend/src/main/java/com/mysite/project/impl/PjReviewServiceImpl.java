package com.mysite.project.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mysite.project.mapper.PjReviewMapper;
import com.mysite.project.service.PjReviewService;
import com.mysite.project.vo.PjReviewVO;

@Service
public class PjReviewServiceImpl implements PjReviewService {
	
	private PjReviewMapper mapper;
	
	public PjReviewServiceImpl(PjReviewMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public List<PjReviewVO> getReviewList(int pj_num) {
		List<PjReviewVO> reviewList = mapper.getReviewList(pj_num);
		return reviewList;
	}

	@Override
	public int insertReview(PjReviewVO review) {
		int res = mapper.insertReview(review);
		return res;
	}

	@Override
	public int updateReview(PjReviewVO review) {
		int res = mapper.updateReview(review);
		return res;
	}

	@Override
	public int deleteReview(int pj_rv_num) {
		int res = mapper.deleteReview(pj_rv_num);
		return res;
	}

//	@Override
//	public double getAvgScore(int pj_rv_score) {
//		double res = mapper.getAvgScore(pj_rv_score);
//		return res;
//	}
	
	@Override
	public int getCount(PjReviewVO review) {
		int res = mapper.getCount(review);
		return res;
	}
	
	@Override
	public int getTotalScore(PjReviewVO review) {
		int res = mapper.getTotalScore(review);
		return res;
	}
}
