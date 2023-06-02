package com.mysite.project.service;

import java.util.List;

import com.mysite.project.vo.FreReviewVO;

public interface FreReviewService {
	
	public List<FreReviewVO> getReviewList(String fre_rv_target); // 리뷰 리스트
	public int insertReview(FreReviewVO review); // 리뷰 등록
	public int updateReview(FreReviewVO review); // 리뷰 수정
	public int deleteReview(int fre_rv_num); // 리뷰 삭제
	public int getCount(FreReviewVO review);
	public int getTotalScore(FreReviewVO review);
}
