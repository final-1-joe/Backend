package com.mysite.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mysite.project.vo.FreReviewVO;

@Mapper
public interface FreReviewMapper {

	@Select("select * from fre_review_db where fre_rv_target=#{fre_rv_target}")
	public List<FreReviewVO> getReviewList(@Param("fre_rv_target") String fre_rv_target); // 리뷰 리스트
	
	@Insert("insert into fre_review_db (user_id, fre_rv_target, fre_rv_score, fre_rv_content) "
			+ "values (#{user_id}, #{fre_rv_target}, #{fre_rv_score}, #{fre_rv_content})")
	public int insertReview(FreReviewVO review); // 리뷰 등록
	
	@Update("update fre_review_db set fre_rv_score=#{fre_rv_score}, fre_rv_content=#{fre_rv_content}, "
			+ "fre_rv_date=now() where fre_rv_num=#{fre_rv_num}")
	public int updateReview(FreReviewVO review); // 리뷰 수정
	
	@Delete("delete from fre_review_db where fre_rv_num=#{fre_rv_num}")
	public int deleteReview(@Param("fre_rv_num") int fre_rv_num); // 리뷰 삭제
	
	@Select("select count(fre_rv_num) from fre_review_db where fre_rv_target=#{fre_rv_target}")
	public int getCount(FreReviewVO review); // 전체 리뷰의 수
	
	@Select("select sum(fre_rv_score) from fre_review_db where fre_rv_target=#{fre_rv_target}")
	public int getTotalScore(FreReviewVO review); // 전체 리뷰 평점의 합
}
