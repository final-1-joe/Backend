package com.mysite.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mysite.project.vo.SBQuestionVO;

@Mapper
public interface SBQuestionMapper {
	
	//@Select("select * from sbquestion order by id desc limit #{start}, #{pageSize}")
	//public List<SBQuestionVO> getSBQList(@Param("start") int start, @Param("pageSize") int pageSize);
	List<SBQuestionVO> getSBQList(@Param("start") int start, @Param("pageSize") int pageSize);
	


	@Select("select count(*) as count from sbquestion")
	public int getCount();
	
	
	@Insert("insert into sbquestion (sbqnum, sbqsubject, sbqcontent, sbqwriter,sbqcreateDate) "
			+ "values (#{sbqnum}, #{sbqsubject}, #{sbqcontent},#{sbqwriter},now())")
	public int insertSBQ(SBQuestionVO sbquesion);
	
	@Select("select * from sbquestion where sbqnum=#{sbqnum} ")
	public SBQuestionVO getSBQ(SBQuestionVO sbquesion);
	
	SBQuestionVO getSBA(SBQuestionVO sbquesion);
	
	@Update("update sbquestion set sbqsubject=#{sbqsubject}, sbqcontent=#{sbqcontent}, sbqcreateDate=now() "
			+ "where sbqnum=#{sbqnum}")
	public int updateSBQ(SBQuestionVO sbquesion);
	
	@Delete("delete from sbquestion where sbqnum=#{sbqnum}")
	public int deleteSBQ(SBQuestionVO sbquesion);

}