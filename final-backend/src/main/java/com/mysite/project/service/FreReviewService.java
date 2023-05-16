package com.mysite.project.service;

import java.util.List;

import com.mysite.project.vo.FreReviewVO;

public interface FreReviewService {
	
	public List<FreReviewVO> getReviewList(); // 리뷰 리스트
	public int insertReview(FreReviewVO review); // 리뷰 등록
	public int updateReview(FreReviewVO review); // 리뷰 수정
	public int deleteReview(FreReviewVO review); // 리뷰 삭제
}
