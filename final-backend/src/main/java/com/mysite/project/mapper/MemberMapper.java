package com.mysite.project.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mysite.project.vo.MemberVO;

@Mapper
public interface MemberMapper {
	
	@Insert("INSERT INTO user_db VALUES (#{user_id}, #{user_pw}, #{user_name}, #{user_email}, #{user_tel}, #{user_code})")
	public int insertMember(MemberVO memberVO);
	
	@Select("SELECT user_code FROM user_db WHERE user_id=#{user_id}")
	public String findCodeInfo(@Param("user_id")String user_id);
	//sidebar를 바꿔주기 위해 로그인한 아이디의 user_code값 조회
	
	@Select("SELECT user_id, user_name, user_email, user_tel, user_code FROM user_db WHERE user_id=#{user_id}")
	public MemberVO findMemberInfo(@Param("user_id")String user_id);
	//회원정보 불러오기(비밀번호 제외)
	
	@Update("UPDATE user_db SET user_pw=#{user_pw}, user_name=#{user_name}, user_email=#{user_email}, "
			+ "user_tel=#{user_tel} WHERE user_id=#{user_id}")
	public int modifyMemberInfo(MemberVO memberVO);
	//회원정보 변경
	
	@Delete("DELETE FROM user_db WHERE user_id=#{user_id}")
	public int deleteMember(@Param("user_id") String id);
	//회원탈퇴
}
