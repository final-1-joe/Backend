package com.mysite.project.service;

import com.mysite.project.vo.UserDateVO;
import com.mysite.project.vo.UserVO;

public interface UserService {
	public int insertUser(UserVO vo);
	boolean loginUser(String user_id, String user_pw);
    public UserVO getUserById(String user_id);
    public int getUserStartData(UserVO vo);
    public int getUserStartDataRe(UserVO vo);
    public void updateUserR(UserVO vo);
    public void updateUserT(UserVO vo);
    public int userCheck(String user_id);
    public int Userdate(UserDateVO vo);
//	public int updateUser(UserVO userVO);
//	public int deleteUser(UserVO userVO);
}
