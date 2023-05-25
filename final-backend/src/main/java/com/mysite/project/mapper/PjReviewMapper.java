package com.mysite.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mysite.project.vo.PjReviewVO;

@Mapper
public interface PjReviewMapper {
	// CRUD: CREATE, READ, UPDATE, DELETE
	
	@Select("select pj_rv_num, user_id, pj_num, pj_rv_score, pj_rv_content, "
			+ "date_format(pj_rv_date, '%y-%m-%d') as pj_rv_date from pj_review_db")
	public List<PjReviewVO> getReviewList(); // 리뷰 리스트
	
	@Insert("insert into pj_review_db (user_id, pj_rv_score, pj_rv_content) "
			+ "values (#{user_id}, #{pj_rv_score}, #{pj_rv_content})")
	public int insertReview(PjReviewVO review); // 리뷰 등록
	
	@Update("update pj_review_db set pj_rv_score=#{pj_rv_score}, pj_rv_content=#{pj_rv_content}, "
			+ "pj_rv_date=now() where pj_rv_num=#{pj_rv_num}")
	public int updateReview(PjReviewVO review); // 리뷰 수정
	
	@Delete("delete from pj_review_db where pj_rv_num=#{pj_rv_num}")
	public int deleteReview(PjReviewVO review); // 리뷰 삭제
}
