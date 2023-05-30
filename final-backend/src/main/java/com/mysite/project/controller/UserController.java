package com.mysite.project.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysite.project.service.UserService;
import com.mysite.project.vo.UserVO;


@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    
    public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

    @PostMapping("/Loginform")
    public int login(@RequestBody UserVO vo) {
        String user_id = vo.getUser_id();
        String user_pw = vo.getUser_pw();
        boolean loginResult = userService.loginUser(user_id, user_pw);
        if (loginResult) {
            return 1; // 로그인 성공
        } else {
            return 0; // 로그인 실패
        }
    }

    @PostMapping ("/Registerform_1")
    public int insertUser1(@RequestBody UserVO vo) {
    	int res = userService.insertUser(vo);
    	return res;
    }	
    @PostMapping ("/Registerform_2")
    public int insertUser2(@RequestBody UserVO vo) {
    	int res = userService.insertUser(vo);
    	return res;
    		
    }	
}

	

