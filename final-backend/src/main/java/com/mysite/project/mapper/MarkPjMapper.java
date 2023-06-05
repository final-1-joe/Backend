package com.mysite.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.mysite.project.vo.MarkPjVO;
import com.mysite.project.vo.MyMarkPjVO;

@Mapper
public interface MarkPjMapper {
	
	@Select("SELECT p.pj_num, p.pj_title, p.pj_corpname FROM mark_pj_db m JOIN project_db p "
			+ "ON m.mark_pj_pjnum = p.pj_num WHERE m.user_id=#{user_id}")
	public List<MyMarkPjVO> selectMarkPj(@Param("user_id") String user_id);
	//프리랜서 마이페이지 메인에서 관심 프로젝트 목록 프로젝트DB에서 제목, 내용 받아와서 출력
	
	@Insert("insert into mark_pj_db(user_id, mark_pj_pjnum) values(#{user_id}, #{mark_pj_pjnum})")
	public int registerMarkPj(MarkPjVO vo);
}
