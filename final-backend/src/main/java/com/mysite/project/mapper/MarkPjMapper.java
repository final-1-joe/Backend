package com.mysite.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.mysite.project.vo.MarkPjVO;

@Mapper
public interface MarkPjMapper {
	
	@Select("SELECT * FROM mark_pj_db WHERE user_id=#{user_id}")
	public List<MarkPjVO> selectMarkPj(@Param("user_id") String user_id);
	//프리랜서 마이페이지 메인에서 관심 프로젝트 목록 출력
}
