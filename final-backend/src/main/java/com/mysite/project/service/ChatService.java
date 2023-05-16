package com.mysite.project.service;

import java.util.List;

public interface ChatService {
	public int insertMessage(ChatDto chatDto) throws Exception;
	public List<ChatDto> getChatRoom_id(ChatDto chatDto) throws Exception;
	public List<ChatDto> getMessage(ChatDto chatDto) throws Exception;
}
