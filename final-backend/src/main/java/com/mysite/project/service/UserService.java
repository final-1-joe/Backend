package com.mysite.project.service;

import java.util.ArrayList;
import com.mysite.project.vo.UserVO;

public interface UserService {
	public int insertUser(UserVO vo);
	boolean loginUser(String user_id, String user_pw);
    public UserVO getUserById(String user_id);
//	public int updateUser(UserVO userVO);
//	public int deleteUser(UserVO userVO);
}
