package com.mysite.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mysite.project.dto.chat.ChatDto;
import com.mysite.project.dto.chat.ChatDto2;
import com.mysite.project.dto.chat.ChatDto3;
import com.mysite.project.dto.chat.ChatDto4;
import com.mysite.project.dto.chat.ChatDto5;

@Mapper
public interface ChatMapper {
	
	// 보내기 버튼 클릭시 해당 내용을 DB에 저장함
	@Insert("INSERT INTO message_db (message_id, user_id, chatroom_id, message_content, img_code, file_code, message_date) values(null, #{user_id}, #{chatroom_id}, #{message_content}, #{img_code}, #{file_code}, now())")
	public int insertMessage(ChatDto chatDto) throws Exception;
	
	// 로그인 세션 정보를 바탕으로 해당 사용자와 대화하는 사람들과 그 채팅방 번호들을 select, 추가로 해당 채팅방의 마지막 메시지도 select함
	@Select("SELECT u.user_id, u.user_name, mj.chatroom_id, m.message_content FROM chatjoin_db mj LEFT JOIN (SELECT chatroom_id, MAX(message_id) AS max_message_id FROM message_db GROUP BY chatroom_id) last_message ON mj.chatroom_id = last_message.chatroom_id LEFT JOIN message_db m ON last_message.max_message_id = m.message_id INNER JOIN user_db u ON mj.user_id = u.user_id WHERE mj.chatroom_id IN (SELECT chatroom_id FROM chatjoin_db WHERE user_id = #{user_id}) AND mj.user_id != #{user_id}")
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
	
	// 채팅방 나가기 기능 [ user_id와 chatroom_id를 가져와서 해당 user_id를 (알 수 없음) 으로 바꿈 ] [삭제 관련]
	@Update ("UPDATE CHATJOIN_DB SET USER_ID = '(알 수 없음)' WHERE USER_ID = #{user_id} AND CHATROOM_ID = #{chatroom_id}")
	public int quitRoom1(ChatDto chatDto) throws Exception;
	
	//채팅방을 나가면 해당 유저의 이름을 '(알 수 없음)' 으로 만드는 함수 [삭제 관련]
	@Update ("UPDATE MESSAGE_DB SET USER_ID = '(알 수 없음)' WHERE USER_ID = #{user_id} AND CHATROOM_ID = #{chatroom_id}")
	public int quitRoom2(ChatDto chatDto) throws Exception;
	
	// 채팅 상대와 협업중인지 알기 위한 select 문
	@Select ("SELECT pj_status FROM pj_status_db WHERE user_id = #{my_user_id} AND pj_num IN (SELECT pj_num FROM project_db WHERE user_id = #{your_user_id})")
	public List<ChatDto3> getworkState(ChatDto2 chatDto2) throws Exception;
	
	// user_id 주면 리뷰데이터 집계해서 평균 내주는 함수 (프리랜서 용)
	@Select ("SELECT AVG(fre_rv_score) FROM fre_review_db WHERE fre_rv_target = #{user_id}")
	public Double getScore(String user_id) throws Exception;
	
	// user_id 주면 리뷰데이터 집계해서 평균 내주는 함수 (클라이언트 용)
	@Select ("SELECT AVG(pj_rv_score)\r\n"
			+ "FROM pj_review_db\r\n"
			+ "WHERE pj_num IN (SELECT pj_num FROM project_db WHERE user_id = #{user_id})")
	public Double getScore2(String user_id) throws Exception;
	
	// user_id를 주면 알림이 있는지 알려주는 함수 [알림 관련]
	@Select ("SELECT COUNT(*) AS new_messages, cj.chatroom_id\r\n"
			+ "	FROM chatjoin_db cj\r\n"
			+ "	INNER JOIN message_db m ON cj.chatroom_id = m.chatroom_id\r\n"
			+ "	WHERE cj.user_id = #{user_id} AND m.message_date > cj.lastmessage\r\n"
			+ "	GROUP BY cj.chatroom_id")
	public List<ChatDto4> getnewState(ChatDto chatDto) throws Exception;
	
	// user_id 와 chatroom_id를 주면 chatjoin_db의 lastmessage를 업데이트 해주는 함수 [알림 관련]
	@Update ("UPDATE chatjoin_db\r\n"
			+ "SET LASTMESSAGE = (\r\n"
			+ "  SELECT MAX(MESSAGE_DATE)\r\n"
			+ "  FROM message_db\r\n"
			+ "  WHERE CHATROOM_ID = #{chatroom_id}\r\n"
			+ ")\r\n"
			+ "WHERE USER_ID = #{user_id}\r\n"
			+ "  AND CHATROOM_ID = #{chatroom_id}")
	public int updatenewState(ChatDto chatDto) throws Exception;
	
	// userIds라는 배열에 user_id로 구성된 배열을 넣고, 해당 user_id에 대한 user_code 가져오기 
	@Select({
		"<script>",
        "SELECT user_id, user_code",
        "FROM user_db",
        "WHERE user_id IN",
        "<foreach item='userID' collection='userIds' open='(' separator=',' close=')'>",
        "#{userID}",
        "</foreach>",
        "</script>"
    })
	public List<ChatDto5> getUserCodes(@Param("userIds") List<String> userIds) throws Exception;
	
}
