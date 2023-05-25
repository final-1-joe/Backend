package com.mysite.project.service;

import java.util.List;

import com.mysite.project.vo.PjReviewVO;

public interface PjReviewService {
	
	public List<PjReviewVO> getReviewList(); // 리뷰 리스트
	public int insertReview(PjReviewVO review); // 리뷰 등록
	public int updateReview(PjReviewVO review); // 리뷰 수정
	public int deleteReview(PjReviewVO review); // 리뷰 삭제

}
