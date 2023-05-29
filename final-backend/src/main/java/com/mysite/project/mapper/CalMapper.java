package com.mysite.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mysite.project.dto.schedule.Schedule_deleteDTO;
import com.mysite.project.dto.schedule.Schedule_insertDTO;
import com.mysite.project.dto.schedule.Schedule_updateDTO;
import com.mysite.project.vo.schedule.CalVo;

@Mapper
public interface CalMapper {
	
	@Insert("insert into schedule_db(user_id, schedule_title, schedule_content, schedule_start, schedule_end, schedule_color)"
			+ " values (#{user_id}, #{schedule_title}, #{schedule_content}, #{schedule_start},"
			+ " #{schedule_end}, #{schedule_color})")
	public void insertSchedule(Schedule_insertDTO insertdto);
	
	@Select("select * from schedule_db where user_id=#{user_id} order by schedule_start")
	List<CalVo> getScheduleList(CalVo vo);
	
	@Update("update schedule_db set schedule_title=#{schedule_title}, schedule_content=#{schedule_content}, "
			+ "schedule_start=#{schedule_start}, schedule_end=#{schedule_end}, schedule_color=#{schedule_color} "
			+ "where schedule_key=#{schedule_key}")
	public void updateSchedule(Schedule_updateDTO updatedto);
	
	@Delete("delete from schedule_db where schedule_key=#{schedule_key}")
	public void deleteSchedule(Schedule_deleteDTO deletedto);
	
	
	
	
	
	
	
	
}
