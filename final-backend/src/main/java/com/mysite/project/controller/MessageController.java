package com.mysite.project.controller;



import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriUtils;

import com.mysite.project.dto.chat.ChatDto;
import com.mysite.project.dto.chat.ChatDto2;
import com.mysite.project.dto.chat.ChatDto3;
import com.mysite.project.dto.chat.ChatDto4;
import com.mysite.project.dto.chat.ChatDto5;
import com.mysite.project.service.ChatService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class MessageController {
	
		private final ChatService chatService;
		private final SimpMessagingTemplate template;

		// send 했을때 불러오는 메서드
		@MessageMapping("/message") 
		public void sendMessage(@Payload ChatDto chatDto) throws Exception{
			if (chatDto.getImg_code() != null) {
				System.out.println("이미지" + chatDto);
				chatService.insertMessage(chatDto); //db 저장
				template.convertAndSend("/sub/"+ chatDto.getChatroom_id(), chatDto);
			}
			
			else if (chatDto.getFile_code() != null) {
				System.out.println("파일" + chatDto);
				chatService.insertMessage(chatDto); //db 저장
				template.convertAndSend("/sub/"+ chatDto.getChatroom_id(), chatDto);
			}
			
			else if (chatDto.getMessage_content() == "") {
				System.out.println("공백" + chatDto);
				template.convertAndSend("/sub/"+ chatDto.getChatroom_id(), chatDto);
			}
			else {
				System.out.println("메시지" + chatDto);
				chatService.insertMessage(chatDto); //db 저장
				template.convertAndSend("/sub/"+ chatDto.getChatroom_id(), chatDto);
			}
			
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
		
		//파일 업로드
		@PostMapping("/file-upload")
		public String handleFileUpload(@RequestParam(value="file", required=false) MultipartFile file) throws Exception {
	        // 파일 업로드 처리
	        if (!file.isEmpty()) {
	            try {
	                // 파일 저장 로직 작성
	                // 예시: 파일을 서버의 지정된 경로에 저장
	                String fileName = file.getOriginalFilename();
	                String filePath = "C:\\Project\\upload\\" + fileName;
	                file.transferTo(new File(filePath));
	                
	                return "파일 업로드 성공: " + fileName;
	            } catch (IOException e) {
	                return "파일 업로드 실패: " + e.getMessage();
	            }
	        } else {
	            return "업로드할 파일이 없습니다.";
	        }
	    } 
		
		// 파일 다운로드
		@PostMapping("/file-download") 
		public ResponseEntity<UrlResource> download(@RequestParam("fileName") String filename) throws MalformedURLException {
		    // 파일 경로
		    String filePath = "C:\\Project\\upload\\" + filename;

		    // UrlResource 생성
		    UrlResource resource = new UrlResource("file:" + filePath);

		    // 파일 이름 인코딩
		    String encodedFileName = UriUtils.encode(filename, StandardCharsets.UTF_8);

		    // Content-Disposition 설정
		    String contentDisposition = "attachment; filename=\"" + encodedFileName + "\"";

		    // ResponseEntity 생성하여 파일 데이터와 Header를 포함하여 반환
		    return ResponseEntity.ok()
		            .header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
		            .body(resource);
		}
		
		// 채팅방 만들기 + 해당 채팅방 번호 반환
		@PostMapping("/createChatroom") 
		public int createChatroom(@RequestBody ChatDto2 chatDto2) throws Exception{
			if (chatService.searchRoom(chatDto2)== -1) { // 채팅방이 없다면 
				chatService.voidRoom(); // 빈 채팅방을 하나 만들고
				chatService.joinRoom1(chatDto2);//그 채팅방 번호에 join 시킴
				chatService.joinRoom2(chatDto2);//그 채팅방 번호에 join 시킴
			}
			return chatService.searchRoom(chatDto2); // 채팅방 번호 반환 
		}
		
		// 채팅방 나가기
		@PostMapping("/quitChatroom")
		public int quitRoom(@RequestBody ChatDto chatDto) throws Exception {
			chatService.quitRoom1(chatDto); //chat_join 의 아이디 값 변경
			return chatService.quitRoom2(chatDto); //message_db 의 아이디 값 변경
		}
		
		//협업중인지 확인하기
		@PostMapping("/getworkstate")
		public List<ChatDto3> getworkState(@RequestBody ChatDto2 chatDto2) throws Exception {
			if(chatService.getworkState(chatDto2).isEmpty()) {
				String tmp = chatDto2.getMy_user_id();
				chatDto2.setMy_user_id(chatDto2.getYour_user_id());
				chatDto2.setYour_user_id(tmp);
			}
			
			return chatService.getworkState(chatDto2);
		}
		
		// 평점 확인하기
		@GetMapping("/score")
		public double getScore(@RequestParam("user_id") String user_id) throws Exception {
			return chatService.getScore(user_id);
		}
		
		@GetMapping("/score2")
		public double getScore2(@RequestParam("user_id") String user_id) throws Exception {
			return chatService.getScore2(user_id);
		}
		
		@PostMapping("/alarm")
		public List<ChatDto4> getnewState(@RequestBody ChatDto chatDto) throws Exception {
			return chatService.getnewState(chatDto);
		}
		
		@PostMapping("/updatealarm")
		public int updatenewState(@RequestBody ChatDto chatDto) throws Exception {
			return chatService.updatenewState(chatDto);
		}
		
		@PostMapping("/getcodes")
		public List<ChatDto5> getUserCodes(@RequestBody List<String> userIds) throws Exception {
			return chatService.getUserCodes(userIds);
		}
		
}
