package com.mysite.project.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysite.project.dto.chat.ChatDto;
import com.mysite.project.dto.chat.ChatDto2;
import com.mysite.project.dto.chat.ChatDto3;
import com.mysite.project.dto.chat.ChatDto4;
import com.mysite.project.dto.chat.ChatDto5;
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
	
	@Override
	public int searchRoom(ChatDto2 chatDto2) throws Exception {
		if (chatMapper.searchRoom(chatDto2) == null) {
			return -1;
		}
		return chatMapper.searchRoom(chatDto2);
	}
	
	@Override
	public int voidRoom() throws Exception {
		return chatMapper.voidRoom();
	}
	
	@Override
	public int joinRoom1(ChatDto2 chatDto2) throws Exception {
		return chatMapper.joinRoom1(chatDto2);
	}
	
	@Override
	public int joinRoom2(ChatDto2 chatDto2) throws Exception {
		return chatMapper.joinRoom2(chatDto2);
	}
	
	@Override
	public int quitRoom1(ChatDto chatDto) throws Exception {
		return chatMapper.quitRoom1(chatDto);
	}
	
	@Override
	public int quitRoom2(ChatDto chatDto) throws Exception {
		return chatMapper.quitRoom2(chatDto);
	}
	
	@Override
	public List<ChatDto3> getworkState(ChatDto2 chatDto2) throws Exception {
		return chatMapper.getworkState(chatDto2);
	}
	
	@Override
	public double getScore(String user_id) throws Exception {
		if (chatMapper.getScore(user_id)==null) {
			return 0;
		}
		return chatMapper.getScore(user_id);
	}
	
	@Override
	public double getScore2(String user_id) throws Exception {
		if (chatMapper.getScore2(user_id)==null) {
			return 0;
		}
		return chatMapper.getScore2(user_id);
	}
	
	@Override
	public List<ChatDto4> getnewState(ChatDto chatDto) throws Exception {
		return chatMapper.getnewState(chatDto);
	}
	
	@Override
	public int updatenewState(ChatDto chatDto) throws Exception {
		return chatMapper.updatenewState(chatDto);
	}
	
	@Override
	public List<ChatDto5> getUserCodes(List<String> userIds) throws Exception {
		return chatMapper.getUserCodes(userIds);
	}
	
}
