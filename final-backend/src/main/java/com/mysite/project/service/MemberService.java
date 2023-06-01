package com.mysite.project.service;


import java.util.List;

import com.mysite.project.vo.MemberVO;

public interface MemberService {

	public String findCodeInfo (String user_id);
	public MemberVO findMemberInfo(String user_id);
	public int modifyMemberInfo(MemberVO memberVO);
	public int deleteMember(String user_id);
	public List<MemberVO> SearchByCodeMember(String user_code);
}
