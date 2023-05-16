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
		@Insert("insert into fre_tag (user_id, fre_jg, fre_job, fre_ws,fre_wt,fre_pay,fre_stdy,fre_mth) "
				+ "values (#{user_id}, #{fre_jg}, #{fre_job},#{fre_ws},#{fre_wt},#{fre_pay},#{fre_stdy},#{fre_mth})")
	    public void insertFT(FretagVO fretag);
		@Update("update fre_tag set fre_jg=#{fre_jg}, fre_job=#{fre_job}, fre_ws=#{fre_ws}, fre_wt=#{fre_wt}, fre_pay=#{fre_pay}, fre_stdy=#{fre_stdy}, fre_mth=#{fre_mth} "
				+ "where user_id=#{user_id}")
	    public void updateFT(FretagVO fretag);
}
