package com.mysite.project.service;

import java.util.List;

import com.mysite.project.dto.chat.ChatDto;
import com.mysite.project.dto.chat.ChatDto2;

public interface ChatService {
	public int insertMessage(ChatDto chatDto) throws Exception;
	public List<ChatDto> getChatRoom_id(ChatDto chatDto) throws Exception;
	public List<ChatDto> getMessage(ChatDto chatDto) throws Exception;
	public int searchRoom(ChatDto2 chatDto2) throws Exception;
	public int voidRoom() throws Exception;
	public int joinRoom1(ChatDto2 chatDto2) throws Exception;
	public int joinRoom2(ChatDto2 chatDto2) throws Exception;
	public int quitRoom1(ChatDto chatDto) throws Exception;
	public int quitRoom2(ChatDto chatDto) throws Exception;
}
