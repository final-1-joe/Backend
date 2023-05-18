package com.mysite.project.service;

import com.mysite.project.vo.MemberVO;

public interface MemberService {

	public int insertMember(MemberVO memberVO);
	public MemberVO findMemberInfo(String user_id);
	public int modifyMemberInfo(MemberVO memberVO);
	public int deleteMember(String user_id);
}
