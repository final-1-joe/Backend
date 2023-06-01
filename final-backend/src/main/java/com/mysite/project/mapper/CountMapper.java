package com.mysite.project.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CountMapper {
	
	@Select("select count(*) from project_db where pj_start like concat ('%', #{pj_start}, '%')")
	public int countPjStart(@Param("pj_start")String pj_start);
	
	@Select("select count(*) from project_db where pj_end like concat ('%', #{pj_end}, '%')")
	public int countPjEnd(@Param("pj_end")String pj_end);
}
