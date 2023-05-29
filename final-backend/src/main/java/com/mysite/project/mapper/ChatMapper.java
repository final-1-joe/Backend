package com.mysite.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mysite.project.dto.chat.ChatDto;
import com.mysite.project.dto.chat.ChatDto2;
import com.mysite.project.dto.chat.ChatDto3;
import com.mysite.project.vo.ProjectVO;

@Mapper
public interface ChatMapper {
	
	// 보내기 버튼 클릭시 해당 내용을 DB에 저장함
	@Insert("INSERT INTO message_db (message_id, user_id, chatroom_id, message_content, img_code, file_code, message_date) values(null, #{user_id}, #{chatroom_id}, #{message_content}, #{img_code}, #{file_code}, now())")
	public int insertMessage(ChatDto chatDto) throws Exception;
	
	// 로그인 세션 정보를 바탕으로 해당 사용자와 대화하는 사람들과 그 채팅방 번호들을 select, 추가로 해당 채팅방의 마지막 메시지도 select함
	@Select ("SELECT mj.user_id, mj.chatroom_id, m.message_content FROM chatjoin_db mj LEFT JOIN (SELECT chatroom_id, MAX(message_id) AS max_message_id FROM message_db GROUP BY chatroom_id) last_message ON mj.chatroom_id = last_message.chatroom_id LEFT JOIN message_db m ON last_message.max_message_id = m.message_id WHERE mj.chatroom_id IN (SELECT chatroom_id FROM chatjoin_db WHERE user_id = #{user_id}) AND mj.user_id != #{user_id}")
	public List<ChatDto> getChatRoom_id(ChatDto chatDto) throws Exception;
	
	// 채팅방 누르면 해당 방 번호를 토대로 DB에서 그간 메시지 내역들을 select 
	@Select ("SELECT * from message_db where chatroom_id=#{chatroom_id} ")
	public List<ChatDto> getMessage(ChatDto chatDto) throws Exception;
	
	// user_id 두개를 넣으면 해당 아이디가 있는 채팅방의 번호를 리턴해줍니다. [create 채팅방 관련]
	@Select ("SELECT cj1.CHATROOM_ID FROM CHATJOIN_DB cj1 INNER JOIN CHATJOIN_DB cj2 ON cj1.CHATROOM_ID = cj2.CHATROOM_ID WHERE cj1.USER_ID = #{my_user_id} AND cj2.USER_ID = #{your_user_id}")
	public Integer searchRoom(ChatDto2 chatDto2) throws Exception;
	
	// 빈 채팅방을 하나 만듭니다. [create 채팅방 관련]
	@Insert ("INSERT INTO CHATROOM_DB (CHATROOM_ID) VALUES (null)")
	public int voidRoom() throws Exception;
	
	/* 빈 채팅방에 해당 유저들을 join 시킵니다. [create 채팅방 관련] */
	@Insert ("INSERT INTO CHATJOIN_DB (CHATJOIN_ID, USER_ID, CHATROOM_ID) SELECT null, #{my_user_id} , chatroom_id FROM CHATROOM_DB WHERE chatroom_id = (SELECT MAX(chatroom_id) FROM CHATROOM_DB)")
	public int joinRoom1(ChatDto2 chatDto2) throws Exception;
	
	@Insert ("INSERT INTO CHATJOIN_DB (CHATJOIN_ID, USER_ID, CHATROOM_ID) SELECT null, #{your_user_id} , chatroom_id FROM CHATROOM_DB WHERE chatroom_id = (SELECT MAX(chatroom_id) FROM CHATROOM_DB)")
	public int joinRoom2(ChatDto2 chatDto2) throws Exception;
	/* 빈 채팅방에 해당 유저들을 join 시킵니다. [create 채팅방 관련] */
	
	// 채팅방 나가기 기능 [ user_id와 chatroom_id를 가져와서 해당 user_id를 (알 수 없음) 으로 바꿈 ]
	@Update ("UPDATE CHATJOIN_DB SET USER_ID = '(알 수 없음)' WHERE USER_ID = #{user_id} AND CHATROOM_ID = #{chatroom_id}")
	public int quitRoom1(ChatDto chatDto) throws Exception;
	
	@Update ("UPDATE MESSAGE_DB SET USER_ID = '(알 수 없음)' WHERE USER_ID = #{user_id} AND CHATROOM_ID = #{chatroom_id}")
	public int quitRoom2(ChatDto chatDto) throws Exception;
	
	// 채팅 상대와 협업중인지 알기 위한 select 문
	@Select ("SELECT pj_status FROM pj_status_db WHERE user_id = #{my_user_id} AND pj_num IN (SELECT pj_num FROM project_db WHERE user_id = #{your_user_id})")
	public List<ChatDto3> getworkState(ChatDto2 chatDto2) throws Exception;
	
}
