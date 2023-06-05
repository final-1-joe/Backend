package com.mysite.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mysite.project.vo.PjReviewVO;

@Mapper
public interface PjReviewMapper {
	
	@Select("select * from pj_review_db where pj_num=#{pj_num}")
	public List<PjReviewVO> getReviewList(@Param("pj_num") int pj_num); // 리뷰 리스트
	
	@Insert("insert into pj_review_db (user_id, pj_num, pj_rv_score, pj_rv_content) "
			+ "values (#{user_id}, #{pj_num}, #{pj_rv_score}, #{pj_rv_content})")
	public int insertReview(PjReviewVO review); // 리뷰 등록
	
	@Update("update pj_review_db set pj_rv_score=#{pj_rv_score}, pj_rv_content=#{pj_rv_content}, "
			+ "pj_rv_date=now() where pj_rv_num=#{pj_rv_num}")
	public int updateReview(PjReviewVO review); // 리뷰 수정
	
	@Delete("delete from pj_review_db where pj_rv_num=#{pj_rv_num}")
	public int deleteReview(@Param("pj_rv_num") int pj_rv_num); // 리뷰 삭제
	
//	@Select("select avg(pj_rv_score) from pj_review_db")
//	public double getAvgScore(@Param("pj_rv_score") int pj_rv_score); // 리뷰 평균 평점
	
	@Select("select count(pj_rv_num) from pj_review_db where pj_num=#{pj_num}")
	public int getCount(PjReviewVO review); // 전체 리뷰의 수
	
	@Select("select sum(pj_rv_score) from pj_review_db where pj_num=#{pj_num}")
	public int getTotalScore(PjReviewVO review); // 전체 리뷰 평점의 합
}
