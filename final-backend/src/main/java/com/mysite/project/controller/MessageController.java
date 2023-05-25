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
		
}
