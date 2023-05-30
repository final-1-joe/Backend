package com.mysite.project.service;

import com.mysite.project.vo.MemberVO;

public interface MemberService {

	public int insertMember(MemberVO memberVO);
	public String findCodeInfo (String user_id);
	public MemberVO findMemberInfo(String user_id);
	public int modifyMemberInfo(MemberVO memberVO);
	public int deleteMember(String user_id);
}
