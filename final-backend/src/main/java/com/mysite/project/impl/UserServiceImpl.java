package com.mysite.project.impl;

import org.springframework.stereotype.Service;

import com.mysite.project.mapper.UserMapper;
import com.mysite.project.service.UserService;
import com.mysite.project.vo.UserVO;


@Service("userService")
public class UserServiceImpl implements UserService {

	private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
	
	@Override
	public int insertUser(UserVO vo) {
		int res = userMapper.insertUser(vo);
		return res;
	}

	 @Override
	    public boolean loginUser(String user_id, String user_pw) {
		 UserVO user = userMapper.getUserById(user_id);
	        if (user != null && user.getUser_pw().equals(user_pw)) {
	            return true; // 로그인 성공
	        }
	        return false; // 로그인 실패
	    }
	
	@Override
	public UserVO getUserById(String user_id) {
		return userMapper.getUserById(user_id);
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
