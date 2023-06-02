package com.mysite.project.service;

import java.util.List;

import com.mysite.project.vo.PjReviewVO;

public interface PjReviewService {
	
	public List<PjReviewVO> getReviewList(int pj_num); // 리뷰 리스트
	public int insertReview(PjReviewVO review); // 리뷰 등록
	public int updateReview(PjReviewVO review); // 리뷰 수정
	public int deleteReview(int pj_rv_num); // 리뷰 삭제
//	public double getAvgScore(int pj_rv_score); // 리뷰 평균 평점
	public int getCount(PjReviewVO review);
	public int getTotalScore(PjReviewVO review);
}
