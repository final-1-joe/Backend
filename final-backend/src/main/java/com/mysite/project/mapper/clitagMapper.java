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
	@Insert("insert into cli_tag (user_id, cli_jg, cli_job, cli_skill,cli_js,cli_ws,cli_wt,cli_pay) "
			+ "values (#{user_id}, #{cli_jg}, #{cli_job},#{cli_skill},#{cli_js},#{cli_ws},#{cli_wt},#{cli_pay})")
    public void insertCT(ClitagVO clitag);
	@Update("update cli_tag set cli_jg=#{cli_jg}, cli_job=#{cli_job}, cli_skill=#{cli_skill}, cli_js=#{cli_js}, cli_ws=#{cli_ws}, cli_wt=#{cli_wt}, cli_pay=#{cli_pay} "
			+ "where user_id=#{user_id}")
    public void updateCT(ClitagVO clitag);
}
