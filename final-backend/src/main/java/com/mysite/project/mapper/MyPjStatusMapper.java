package com.mysite.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mysite.project.vo.MyPjStatusVO;

@Mapper
public interface MyPjStatusMapper {
	
	@Select("SELECT p.pj_num, p.pj_title, p.pj_corpname FROM project_db p JOIN pj_status_db s "
			+ "ON s.pj_num=p.pj_num WHERE s.user_id=#{user_id} AND s.pj_status='ongoing'")
	public List<MyPjStatusVO> selectOngoingPj(@Param("user_id") String user_id);
	//진행중인 프로젝트 조회
	
	@Select("SELECT p.pj_num, p.pj_title, p.pj_corpname FROM pj_status_db s JOIN project_db p "
			+ "ON s.pj_num=p.pj_num WHERE s.user_id=#{user_id} AND s.pj_status='inprogress'")
	public List<MyPjStatusVO> selectInprogressPj(@Param("user_id") String user_id);
	//제안받은 프로젝트 조회
	
	@Select("SELECT p.pj_num, p.pj_title, p.pj_corpname FROM pj_status_db s JOIN project_db p "
			+ "ON s.pj_num=p.pj_num WHERE s.user_id=#{user_id} AND s.pj_status='apply'")
	public List<MyPjStatusVO> selectApplyPj(@Param("user_id") String user_id);
	//지원한 프로젝트 조회
	
	@Select("SELECT p.pj_num, p.pj_title, p.pj_corpname FROM pj_status_db s JOIN project_db p "
			+ "ON s.pj_num=p.pj_num WHERE s.user_id=#{user_id} AND s.pj_status='finished'")
	public List<MyPjStatusVO> selectFinishedPj(@Param("user_id") String user_id);
	//완료된 프로젝트 조회
	
	@Update("UPDATE pj_status_db SET pj_status='completed' WHERE user_id=#{user_id} AND pj_num=#{pj_num}")
	public int updateCompletedPj(@Param("user_id") String user_id, @Param("pj_num")int pj_num);
	//프리랜서가 승낙 버튼을 누르면 status가 모집완료인 completed로 변경되도록
	
	@Delete("DELETE FROM pj_status_db WHERE user_id=#{user_id} AND pj_num=#{pj_num}")
	public int deleteInprogressPj(@Param("user_id")String user_id, @Param("pj_num")int pj_num);
	//프리랜서가 거절 누르면 아예 제안 자체가 삭제되도록 구현
	
	@Select("SELECT p.user_id FROM pj_status_db s JOIN  project_db p "
			+ "ON s.pj_num=p.pj_num WHERE user_id=#{user_id}")
	public String selectClient(@Param("user_id")String user_id, @Param("pj_num")int pj_num);
	//dm보낼 때 쓸 클라이언트 아이디 뽑아오기
}
