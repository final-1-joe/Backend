package com.mysite.project.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mysite.project.vo.FretagVO;

@Mapper
public interface FretagMapper {
	
		@Select("select * from fre_tag where user_id=#{user_id} ")
		public FretagVO getFT(FretagVO fretag);
		@Insert("insert into fre_tag (user_id, pj_job, pj_jobs, pj_work_form,pj_place,pj_pay,pj_start,pj_day) "
				+ "values (#{user_id}, #{pj_job}, #{pj_jobs},#{pj_work_form},#{pj_place},#{pj_pay},#{pj_start},#{pj_day})")
	    public void insertFT(FretagVO fretag);
		@Update("update fre_tag set pj_job=#{pj_job}, pj_jobs=#{pj_jobs}, pj_work_form=#{pj_work_form}, pj_place=#{pj_place}, pj_pay=#{pj_pay}, pj_start=#{pj_start}, pj_day=#{pj_day} "
				+ "where user_id=#{user_id}")
	    public void updateFT(FretagVO fretag);
}
