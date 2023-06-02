package com.mysite.project.impl;

import org.springframework.stereotype.Service;

import com.mysite.project.mapper.UserMapper;
import com.mysite.project.service.UserService;
import com.mysite.project.vo.UserDateVO;
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
	

	@Override
	public int userCheck(String user_id) {
		int res = userMapper.userCheck(user_id);
		return res;
	}

	@Override
	public int getUserStartData(UserVO vo) {
		return userMapper.getUserStartData(vo);
	}
	
	@Override
	public int getUserStartDataRe(UserVO vo) {
		return userMapper.getUserStartDataRe(vo);
	}

	@Override
	public void updateUserR(UserVO vo) {
		userMapper.updateUserR(vo);
	}
	
	@Override
	public void updateUserT(UserVO vo) {
		userMapper.updateUserT(vo);
	}

	@Override
	public int Userdate(UserDateVO vo) {
		return userMapper.Userdate(vo);
	}

}
