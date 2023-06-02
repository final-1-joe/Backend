package com.mysite.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mysite.project.vo.ProjectVO;

@Mapper
public interface ProjectMapper {
	// CRUD: CREATE, READ, UPDATE, DELETE
	// projectList: 프로젝트 리스트 페이지에서 보여줄 리스트
	// projectDetail: 프로젝트 상세 페이지에서 보여줄 각 프로젝트의 상세 정보
	// insertProject: 프로젝트 등록
	// updateProject: 프로젝트 수정
	// deleteProject: 프로젝트 삭제
	
	@Select("select * from project_db")
//	@Select("select p.pj_num, p.pj_corpname, p.pj_title, p.pj_content, p.pj_date, p.pj_pay, p.pj_start, "
//			+ "p.pj_day, p.pj_place, p.pj_work_form, p.pj_job, p.pj_skill, p.pj_pick, p.pj_period, p.user_id "
//			+ "from project_db p join user_db u on u.user_id = p.user_id;")
	public List<ProjectVO> projectList();
	
	@Select("select * from project_db where pj_num=#{pj_num}")
	public ProjectVO projectDetail(@Param("pj_num") int pj_num);
	
	@Select("SELECT count(*) FROM project_db WHERE pj_job = #{pj_job}")
	public int pjjgCount(ProjectVO project);
	
	public List<ProjectVO> projectListTag(ProjectVO project);
	
	public List<ProjectVO> projectTag(ProjectVO project);
	
	@Insert("insert into project_db(pj_title, pj_corpname, pj_work_form, pj_place, pj_start, pj_period, "
			+ "pj_job, pj_pay, pj_end, pj_day, pj_pick, pj_skill, pj_content, pj_date, user_id) "
			+ "values(#{pj_title}, #{pj_corpname}, #{pj_work_form},  #{pj_place}, #{pj_start}, #{pj_period}, "
			+ "#{pj_job}, #{pj_pay}, #{pj_end}, #{pj_day}, #{pj_pick}, #{pj_skill}, #{pj_content}, now(), #{user_id})")
	public int insertProject(ProjectVO project);
	
	@Update("update project_db set pj_title=#{pj_title}, pj_content=#{pj_content}, pj_date=now(), "
			+ "pj_pay=#{pj_pay}, pj_start=#{pj_start}, pj_end=#{pj_end}, pj_day=#{pj_day}, pj_place=#{pj_place}, pj_work_form=#{pj_work_form}, "
			+ "pj_job=#{pj_job}, pj_skill=#{pj_skill}, pj_pick=#{pj_pick}, pj_period=#{pj_period} where pj_num=#{pj_num}")
	public int updateProject(ProjectVO project);
	
	@Delete("delete from project_db where pj_num=#{pj_num}")
	public int deleteProject(ProjectVO project);	
	
}
