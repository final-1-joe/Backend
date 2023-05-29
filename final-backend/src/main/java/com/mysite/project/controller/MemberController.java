package com.mysite.project.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mysite.project.impl.MemberServiceImpl;
import com.mysite.project.vo.MemberVO;

@RestController
public class MemberController {

	MemberServiceImpl memberServiceImpl;
	
	public MemberController (MemberServiceImpl memberServiceImpl) {
		this.memberServiceImpl = memberServiceImpl;
	}
	
	@PostMapping("/join")
	public int insertMember(MemberVO memberVO) {
		int res = memberServiceImpl.insertMember(memberVO);
		return res;
	}
	
	@GetMapping("/auth/user_code")
	public String findCodeInfo(String user_id) {
		return memberServiceImpl.findCodeInfo(user_id);
	}
	
	@GetMapping("/auth/userinfo")
	public MemberVO findMemberInfo(@RequestParam String user_id) {
		MemberVO memberVO = memberServiceImpl.findMemberInfo(user_id);
		return memberVO;
	}
	
	@PutMapping("/auth/updateuser")
	public int modifyMemberInfo(MemberVO memberVO) {
		int res = memberServiceImpl.modifyMemberInfo(memberVO);
		return res;
	}
	
	@PostMapping("/auth/delete")
	public int deleteMember(@RequestParam("user_id") String user_id) {
		int res = memberServiceImpl.deleteMember(user_id);
		return res;
	}
}
