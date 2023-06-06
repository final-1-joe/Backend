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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriUtils;

import com.mysite.project.service.USResumeService;
import com.mysite.project.vo.FileVO;
import com.mysite.project.vo.USResumeVO;

@RequestMapping("/resume")
@RestController
public class USResumeController {
	
	private USResumeService usresumeService;
	
	public USResumeController(USResumeService usresumeService) {
		this.usresumeService = usresumeService;
	}
	
	@RequestMapping("/list")
	public List<USResumeVO> USRList(@RequestBody USResumeVO usresume) {
	    List<USResumeVO> userList = usresumeService.USRList(usresume);
	    return userList;
	}
	
	@RequestMapping("/tag")
	public List<USResumeVO> USRTag(@RequestBody USResumeVO usresume) {
	    List<USResumeVO> userList = usresumeService.USRTag(usresume);
	    return userList;
	}
	
	@RequestMapping("/select")
    public USResumeVO getFAQ(@RequestBody USResumeVO usresume) {
       return  this.usresumeService.getUSR(usresume);
    }

	@RequestMapping("/insert")
    public void questionCreate(@RequestBody USResumeVO usresume) {
        this.usresumeService.insert(usresume);
    }
	
	@RequestMapping("/update")
	public void update(@RequestBody USResumeVO usresume) {
	    this.usresumeService.update(usresume);
	}
	
	@RequestMapping("/delete")
	public void delete(@RequestBody USResumeVO usresume) {
	    this.usresumeService.delete(usresume);
	}
	
	@PostMapping("/usjgcount")
	public int usjgCount(@RequestBody USResumeVO usresume) {
	    return this.usresumeService.usjgCount(usresume);
	}
	
	@Value("${spring.servlet.multipart.location}")
    String uploadDir;
	
	@RequestMapping("/upload")
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
//				file.transferTo(new File(file.getOriginalFilename().toString()));
			}
		}
		return list;
	}	
	
	@RequestMapping("/download")
	public ResponseEntity<UrlResource> download(String originfilename, String storedfilename) throws IOException {
        // UrlResource는 Resource 인터페이스의 구현체로 new UrlResource("file:" + "파일이 저장된 경로") 로 사용하면된다
		UrlResource resource = new UrlResource("file:" + uploadDir + "/" + storedfilename);
        String encodedFileName = UriUtils.encode(originfilename, StandardCharsets.UTF_8);
        // 파일 다운로드 대화상자가 뜨도록 하는 헤더를 설정해주는 것
        // Content-Disposition 헤더에 attachment; filename="업로드 파일명" 값을 준다.
        // contentDisposition 값에 든 이름으로 파일이 실질적으로 저장된다.
        String contentDisposition = "attachment; filename=\"" + encodedFileName + "\"";
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,contentDisposition).body(resource);
	}
}
