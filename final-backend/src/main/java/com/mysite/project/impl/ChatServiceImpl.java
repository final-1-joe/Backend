package com.mysite.project.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysite.project.dto.chat.ChatDto;
import com.mysite.project.mapper.ChatMapper;
import com.mysite.project.service.ChatService;


@Service
public class ChatServiceImpl implements ChatService {
	
	@Autowired
	private ChatMapper chatMapper;

	@Override 
	public int insertMessage(ChatDto chatDto) throws Exception { // 보내기 버튼 클릭 시 DB에 해당 메시지 내용 저장 
		return chatMapper.insertMessage(chatDto);
	}

	@Override
	public List<ChatDto> getChatRoom_id(ChatDto chatDto) throws Exception {
		return chatMapper.getChatRoom_id(chatDto);
		
	}
	
	@Override
	public List<ChatDto> getMessage(ChatDto chatDto) throws Exception {
		return chatMapper.getMessage(chatDto);
	}
}
