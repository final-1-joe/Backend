package com.mysite.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mysite.project.dto.chat.ChatDto;

@Mapper
public interface ChatMapper {
	
	// 보내기 버튼 클릭시 해당 내용을 DB에 저장함
	@Insert("INSERT INTO message_db (message_id, user_id, chatroom_id, message_content, img_code, file_code, message_date) values(null, #{user_id}, #{chatroom_id}, #{message_content}, #{img_code}, #{file_code}, now())")
	public int insertMessage(ChatDto chatDto) throws Exception;
	
	// 로그인 세션 정보를 바탕으로 해당 사용자와 대화하는 사람들과 그 채팅방 번호들을 select, 추가로 해당 채팅방의 마지막 메시지도 select함
	@Select ("SELECT mj.user_id, mj.chatroom_id, m.message_content FROM chatjoin_db mj INNER JOIN (SELECT chatroom_id, MAX(message_id) AS max_message_id FROM message_db GROUP BY chatroom_id) last_message ON mj.chatroom_id = last_message.chatroom_id INNER JOIN message_db m ON last_message.max_message_id = m.message_id WHERE mj.chatroom_id IN (SELECT chatroom_id FROM message_db WHERE user_id = #{user_id}) AND mj.user_id != #{user_id}")
	public List<ChatDto> getChatRoom_id(ChatDto chatDto) throws Exception;
	
	// 채팅방 누르면 해당 방 번호를 토대로 DB에서 그간 메시지 내역들을 select 
	@Select ("SELECT * from message_db where chatroom_id=#{chatroom_id} ")
	public List<ChatDto> getMessage(ChatDto chatDto) throws Exception;
	
}
