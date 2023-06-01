package com.mysite.project.controller;


import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriUtils;

import com.mysite.project.impl.MemberServiceImpl;
import com.mysite.project.vo.FileVO;
import com.mysite.project.vo.MemberVO;

@RestController
public class MemberController {

	MemberServiceImpl memberServiceImpl;
	
	public MemberController (MemberServiceImpl memberServiceImpl) {
		this.memberServiceImpl = memberServiceImpl;
	}
	
	@GetMapping("/auth/user_code")
	public String findCodeInfo(String user_id) {
		return memberServiceImpl.findCodeInfo(user_id);
	}
	
	@GetMapping("/auth/userinfo")
	public MemberVO findMemberInfo(@RequestParam String user_id) {
		MemberVO memberVO = memberServiceImpl.findMemberInfo(user_id);
		return memberVO;
	}
	
	@PostMapping("/auth/updateuser")
	public int modifyMemberInfo(@RequestBody MemberVO memberVO) {
		int res = memberServiceImpl.modifyMemberInfo(memberVO);
		return res;
	}
	
	@PostMapping("/auth/delete")
	public int deleteMember(@RequestParam("user_id") String user_id) {
		int res = memberServiceImpl.deleteMember(user_id);
		return res;
	}
	
	@Value("${spring.servlet.multipart.location}")
    String uploadDir;
	
	@RequestMapping("/auth/upload")
	public List<FileVO> upload(MultipartFile[] uploadfiles) throws IllegalStateException, IOException {
		List<FileVO> list = new ArrayList<>();
		for (MultipartFile file : uploadfiles) {
			if (!file.isEmpty()) {
				File storedFilename = new File(UUID.randomUUID().toString() + "_" + file.getOriginalFilename());
				FileVO entity = new FileVO(file.getOriginalFilename(),
						storedFilename.toString(),
						file.getContentType());
				list.add(entity);
				file.transferTo(storedFilename);
			}
		}
		return list;
	}	
	
	@RequestMapping("/auth/download")
	public ResponseEntity<UrlResource> download(String originfilename, String storedfilename) throws IOException {
		UrlResource resource = new UrlResource("file:" + uploadDir + "/" + storedfilename);
        String encodedFileName = UriUtils.encode(originfilename, StandardCharsets.UTF_8);
        String contentDisposition = "attachment; filename=\"" + encodedFileName + "\"";
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,contentDisposition).body(resource);
	}
	
	@GetMapping("/auth/searchbycode")
	public List<MemberVO> SearchByCodeMember(@RequestParam("user_code")String user_code) {
		List<MemberVO> memberVO = memberServiceImpl.SearchByCodeMember(user_code);
		return memberVO;
	}
}
