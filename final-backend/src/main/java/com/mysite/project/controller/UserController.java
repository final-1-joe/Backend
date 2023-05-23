package com.mysite.project.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public Map<String, Object> userCheck(@RequestParam("user_id") String user_id, @RequestParam("user_pw") String user_pw) {
        Map<String, Object> result = new HashMap<>();

        UserVO data = userService.getUserInfo(user_id);

        if (data == null || !data.getUser_pw().equals(user_pw)) {
            result.put("success", false);
            result.put("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
        } else {
            result.put("success", true);
        }

        return result;
    }

    @PostMapping ("/Registerform_2")
    public int insertUser(@RequestBody UserVO vo) {
    	int res = userService.insertUser(vo);
    	return res;

        


    }

	
}
	

