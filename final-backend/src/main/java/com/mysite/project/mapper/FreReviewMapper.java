package com.mysite.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mysite.project.vo.FreReviewVO;

@Mapper
public interface FreReviewMapper {

	@Select("select fre_rv_num, user_id, fre_rv_target, fre_rv_score, fre_rv_content, "
			+ "date_format(fre_rv_date, '%y-%m-%d') as fre_rv_date from fre_review_db")
	public List<FreReviewVO> getReviewList(); // 리뷰 리스트
	
	@Insert("insert into fre_review_db (user_id, fre_rv_score, fre_rv_content) "
			+ "values (#{user_id}, #{fre_rv_score}, #{fre_rv_content})")
	public int insertReview(FreReviewVO review); // 리뷰 등록
	
	@Update("update fre_review_db set fre_rv_score=#{fre_rv_score}, fre_rv_content=#{fre_rv_content}, "
			+ "fre_rv_date=now() where fre_rv_num=#{fre_rv_num}")
	public int updateReview(FreReviewVO review); // 리뷰 수정
	
	@Delete("delete from fre_review_db where fre_rv_num=#{fre_rv_num}")
	public int deleteReview(FreReviewVO review); // 리뷰 삭제
}
