package com.mysite.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.mysite.project.vo.MarkFreeVO;

@Mapper
public interface MarkFreeMapper {
	
	@Select("SELECT * FROM mark_fre_db WHERE user_id=#{user_id}")
	public List<MarkFreeVO> selectMarkFree(@Param("user_id") String user_id);
	//클라이언트 마이페이지에서 북마크한 프리랜서 목록 출력
}
