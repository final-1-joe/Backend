package com.mysite.project.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import com.mysite.project.vo.SBAnswerVO;

@Mapper
public interface SBAnswerMapper {
	
	@Insert("insert into sbanswer (sbanum, sbaanswer,sbawriter,sbacreateDate,sbquestion_id) "
			+ "values (#{sbanum}, #{sbaanswer},#{sbawriter},now(),#{sbquestion_id})")
	public int insertSBA(SBAnswerVO sba);
	
	@Update("update sbanswer set sbaanswer=#{sbaanswer}, sbacreateDate=now() "
			+ "where sbanum=#{sbanum}")
	public int updateSBA(SBAnswerVO sba);
	
	@Delete("delete from sbanswer where sbanum=#{sbanum}")
	public int deleteSBA(SBAnswerVO sba);


}
