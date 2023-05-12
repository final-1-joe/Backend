package com.mysite.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mysite.project.vo.CalVo;

@Mapper
public interface CalMapper {
	
	@Insert("insert into schedule(userid, schedule_title, schedule_content, schedule_start, schedule_end)"
			+ " values (#{userid}, #{schedule_title}, #{schedule_content}, #{schedule_start},"
			+ " #{schedule_end}")
	public void insertSchedule(CalVo vo);
	
	@Select("select * from schedule where userid=#{userid} order by schedule_start")
	List<CalVo> getScheduleList(CalVo vo);
	
	@Update("update schedule set schedule_title=#{schedule_title}, schedule_content=#{schedule_content}, "
			+ "schedule_start=#{schedule_start}, schedule_end=#{schedule_end} where userid=#{userid}"
			+ " and schedulekey=#{schedulekey}")
	public void updateSchedule(CalVo vo);
	
	@Delete("delete schedule where where userid=#{userid} and schedulekey=#{schedulekey}")
	public void deleteSchedule(CalVo vo);
	
	
	
	
	
	
	
	
}
