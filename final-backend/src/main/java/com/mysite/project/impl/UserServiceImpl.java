package com.mysite.project.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.mysite.project.mapper.UserMapper;
import com.mysite.project.service.UserService;
import com.mysite.project.vo.UserVO;


@Service("userService")
public class UserServiceImpl implements UserService {

private UserMapper mapper;
	
	public UserServiceImpl(UserMapper mapper) {
		this.mapper = mapper;
	}
	
	@Override
	public int insertUser(UserVO vo) {
		int res = mapper.insertUser(vo);
		return res;
	}

	@Override
	public int userCheck(UserVO userVO) {
		int res = mapper.userCheck(userVO);
		return res;
	}

	@Override
	public ArrayList<UserVO> getUserlist() {
		ArrayList<UserVO> user_list = new ArrayList<UserVO>();
		user_list = mapper.getUserlist();
		return user_list;
	}


	@Override
	public UserVO selectUser(UserVO userVO) {
		UserVO vo = mapper.selectUser(userVO);
		return vo;
	}
	
	@Override
	public UserVO getUserInfo(String userId) {
		return mapper.getUserInfo(userId);
		    }
	}
//	}
//
//	@Override
//	public int updateMember(MemberVO memberVO) {
//		int res = mapper.updateMember(memberVO);
//		return res;
//	}
//
//	@Override
//	public int deleteMeber(MemberVO memberVO) {
//		int res = mapper.deleteMeber(memberVO);
//		return res;
//	}
