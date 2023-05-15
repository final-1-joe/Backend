package com.mysite.project.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mysite.project.vo.USResumeVO;

@Mapper
public interface USResumeMapper {
	
	//@Select("SELECT * FROM us_resume WHERE user_id = #{user_id}")
	public USResumeVO getUSR(USResumeVO usresume);

    //@Insert("INSERT INTO us_resume (user_id, user_nm, user_js, user_bd, user_gen, user_email, user_tel, user_jg, user_job, user_skill, user_ws, user_wt, user_pay, user_career, user_file, user_github) " +
    //       "VALUES (#{user_id}, #{user_nm}, #{user_js}, #{user_bd}, #{user_gen}, #{user_email}, #{user_tel}, #{user_jg}, #{user_job}, #{user_skill}, #{user_ws}, #{user_wt}, #{user_pay}, #{user_career}, #{user_file}, #{user_github})")
    public void insertUSR(USResumeVO usresume);

    //@Update("UPDATE us_resume SET user_nm = #{user_nm}, user_js = #{user_js}, user_bd = #{user_bd}, user_gen = #{user_gen}, user_email = #{user_email}, user_tel = #{user_tel}, user_jg = #{user_jg}, user_job = #{user_job}, user_skill = #{user_skill}, user_ws = #{user_ws}, user_wt = #{user_wt}, user_pay = #{user_pay}, user_career = #{user_career}, user_file = #{user_file}, user_github = #{user_github} WHERE user_id = #{user_id}")
    public void updateUSR(USResumeVO usresume);

}
