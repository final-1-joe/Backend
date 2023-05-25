package com.mysite.project.mapper;

import java.util.ArrayList;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mysite.project.vo.UserVO;

	@Mapper
	public interface UserMapper {
		
		@Insert("insert into user_db(user_id, user_pw, user_name,  user_email, user_tel, user_code)"
				+ " values (#{user_id},#{user_pw},#{user_name},#{user_email},#{user_tel},#{user_code})")
		public int insertUser(UserVO vo);
		
		@Select("select * from user_db where user_id = #{user_id}")
		public UserVO getUserById(String user_id);
		
//		@Select("select count(*) from user where id = #{user_id} and password = #{user_pw}")
//		public int userCheck(UserVO userVO);
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

