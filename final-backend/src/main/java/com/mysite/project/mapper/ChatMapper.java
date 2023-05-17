package com.mysite.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mysite.project.dto.chat.ChatDto;

@Mapper
public interface ChatMapper {
	
	// 보내기 버튼 클릭시 해당 내용을 DB에 저장함
	@Insert("INSERT INTO message_db (message_id, user_id, chatroom_id, message_content, message_date) values(null, #{user_id}, #{chatroom_id}, #{message_content}, now())")
	public int insertMessage(ChatDto chatDto) throws Exception;
	
	// 로그인 세션 정보를 바탕으로 해당 사용자와 대화하는 사람들과 그 채팅방 번호들을 select
	@Select ("SELECT distinct user_id, chatroom_id from message_db where chatroom_id in (select chatroom_id from message_db where user_id = #{user_id})and user_id != #{user_id}")
	public List<ChatDto> getChatRoom_id(ChatDto chatDto) throws Exception;
	
	// 채팅방 누르면 해당 방 번호를 토대로 DB에서 그간 메시지 내역들을 select 
	@Select ("SELECT * from message_db where chatroom_id=#{chatroom_id} ")
	public List<ChatDto> getMessage(ChatDto chatDto) throws Exception;
}
