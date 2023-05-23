package com.mysite.project.service;

import java.util.ArrayList;
import com.mysite.project.vo.UserVO;

public interface UserService {
	public int insertUser(UserVO vo);
	public int userCheck(UserVO userVO);
	public ArrayList<UserVO> getUserlist();
	public UserVO selectUser(UserVO userVO);
    public UserVO getUserInfo(String userId);
//	public int updateUser(UserVO userVO);
//	public int deleteUser(UserVO userVO);
}
