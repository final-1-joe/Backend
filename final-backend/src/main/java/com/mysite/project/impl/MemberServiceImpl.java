package com.mysite.project.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mysite.project.mapper.MemberMapper;
import com.mysite.project.service.MemberService;
import com.mysite.project.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	MemberMapper mapper;
	
	public MemberServiceImpl (MemberMapper mapper) {
		this.mapper = mapper;
	}
	
	@Override
	public String findCodeInfo(String user_id) {
		return mapper.findCodeInfo(user_id);
	}

	@Override
	public MemberVO findMemberInfo(String user_id) {
		MemberVO memberVO = mapper.findMemberInfo(user_id);
		return memberVO;
	}

	@Override
	public int modifyMemberInfo(MemberVO memberVO) {
		int res = mapper.modifyMemberInfo(memberVO);
		return res;
	}

	@Override
	public int deleteMember(String user_id) {
		int res = mapper.deleteMember(user_id);
		return res;
	}
	
	@Override
	public List<MemberVO> SearchByCodeMember(String user_code) {
		List<MemberVO> memberVO = mapper.SearchByCodeMember(user_code);
		return memberVO;
	}

}
