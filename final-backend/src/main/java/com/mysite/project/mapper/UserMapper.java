package com.mysite.project.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mysite.project.vo.UserVO;

	@Mapper
	public interface UserMapper {
		
		@Insert("insert into user_db(user_id, user_pw, user_name, user_birth,user_email, user_tel, user_code,user_orlicense,user_stlicense)"
				+ " values (#{user_id},#{user_pw},#{user_name},#{user_birth},#{user_email},#{user_tel},#{user_code},#{user_orlicense},#{user_stlicense})")
		public int insertUser(UserVO vo);
		
		@Select("select * from user_db where user_id = #{user_id}")
		public UserVO getUserById(String user_id);
		
		@Select("select count(*) from user_db where user_id = #{user_id}")
		public int userCheck(String user_id);
		
		public UserVO getUserStartData(UserVO vo);
		
		public void updateUserRT(UserVO vo);
//
//		@Select("select * from user order by user_id")
//		public ArrayList<UserVO> getUserlist();
//		
//		@Select("select * from user where id = #{user_id}")
//		public UserVO selectUser(UserVO userVO);
//		
//		@Update("update smember set password=#{password}, name=#{name}, age=#{age}, gender=#{gender}, email=#{email} where id=#{id}")
//		public int updateMember(UserVO userVO);
//		
//		@Delete("delete from smember where id = #{id}")
//		public int deleteMeber(UserVO userVO);
		
	
	}

