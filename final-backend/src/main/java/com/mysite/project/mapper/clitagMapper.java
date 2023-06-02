package com.mysite.project.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mysite.project.vo.ClitagVO;

@Mapper
public interface clitagMapper {
	@Select("select * from cli_tag where user_id=#{user_id} ")
	public ClitagVO getCT(ClitagVO clitag);
	
	@Insert("insert into cli_tag (user_id, user_jg, user_job, user_skill,user_career,user_js,user_ws,user_wt,user_pay) "
			+ "values (#{user_id}, #{user_jg}, #{user_job},#{user_skill},#{user_career},#{user_js},#{user_ws},#{user_wt},#{user_pay})")
    public void insertCT(ClitagVO clitag);
	
	@Update("update cli_tag set user_jg=#{user_jg}, user_job=#{user_job}, user_skill=#{user_skill},user_career=#{user_career}, user_js=#{user_js}, user_ws=#{user_ws}, user_wt=#{user_wt}, user_pay=#{user_pay} "
			+ "where user_id=#{user_id}")
    public void updateCT(ClitagVO clitag);
}
