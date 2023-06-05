package com.mysite.project.service;

import java.util.List;

import com.mysite.project.dto.chat.ChatDto;
import com.mysite.project.dto.chat.ChatDto2;
import com.mysite.project.dto.chat.ChatDto3;
import com.mysite.project.dto.chat.ChatDto4;
import com.mysite.project.dto.chat.ChatDto5;

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
	public List<ChatDto3> getworkState(ChatDto2 chatDto2) throws Exception;
	public double getScore(String user_id) throws Exception;
	public double getScore2(String user_id) throws Exception;
	public List<ChatDto4> getnewState(ChatDto chatDto) throws Exception;
	public int updatenewState(ChatDto chatDto) throws Exception;
	public List<ChatDto5> getUserCodes(List<String> userIds) throws Exception;
}
