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
	public List<PjReviewVO> getReviewList() {
		List<PjReviewVO> reviewList = mapper.getReviewList();
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
	public int deleteReview(PjReviewVO review) {
		int res = mapper.deleteReview(review);
		return res;
	}

}
