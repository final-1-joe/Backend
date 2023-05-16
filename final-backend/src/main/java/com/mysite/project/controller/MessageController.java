package com.mysite.project.controller;



import java.util.List;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class MessageController {
	
		private final ChatService chatService;
		private final SimpMessagingTemplate template;

		// send 했을때 불러오는 메서드
		@MessageMapping("/message") 
		public void sendMessage(@Payload ChatDto chatDto) throws Exception{
			System.out.println("메시지" + chatDto);
			chatService.insertMessage(chatDto); //db 저장
			template.convertAndSend("/sub/1"/* + chatDto.getChatroom_id()*/, chatDto);
		}
		
		// 사용자 로그인 아이디를 기반으로 참여중인 채팅방 조회 
		@PostMapping("/chatroom")
		public List<ChatDto> getchatroom(@RequestBody ChatDto chatDto) throws Exception{
			return chatService.getChatRoom_id(chatDto);
		}
		
		// 특정 채팅방의 모든 메시지 조회 
		@PostMapping("/lookupmsg")
		public List<ChatDto> getchatmessage(@RequestBody ChatDto chatDto) throws Exception{
			return chatService.getMessage(chatDto);
		}

}
