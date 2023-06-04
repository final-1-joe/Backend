package com.mysite.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.mysite.project.vo.MarkFreeVO;
import com.mysite.project.vo.MyMarkFreeVO;

@Mapper
public interface MarkFreeMapper {
	
	@Select("SELECT m.mark_fre_id, r.user_nm, r.user_skill FROM mark_fre_db m JOIN us_resume r "
			+ "ON m.mark_fre_id = r.user_id WHERE m.user_id = #{user_id}")
	List<MyMarkFreeVO> selectMarkFree(@Param("user_id") String user_id);
	//클라이언트 마이페이지에서 북마크한 프리랜서 목록을 이력서 DB의 이름과 스킬을 가져와서 출력
	
	@Insert("insert into mark_fre_db(user_id, mark_fre_id) values(#{user_id}, #{mark_fre_id})")
	public int registerMarkFree(MarkFreeVO vo);
	
}
