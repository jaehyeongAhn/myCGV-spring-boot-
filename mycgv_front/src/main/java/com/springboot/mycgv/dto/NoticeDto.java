package com.springboot.mycgv.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class NoticeDto {
	
	private int rno;
	private int nhits;
	private String nid;
	private String ntitle;
	private String ncontent;
	private String nfile;
	private String nsfile;
	private String ndate;
	private MultipartFile file1;
	
}
