package com.mysite.project.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class FileVO {
	
	private String originfilename;
	private String storedfilename;
	private String contenttype;
    
    
}