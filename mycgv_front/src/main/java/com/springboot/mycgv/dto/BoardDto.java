package com.springboot.mycgv.dto;


import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BoardDto {
	private int rno;
	private int bhits;
	private String bid;
	private String btitle;
	private String bcontent;
	private String bfile;
	private String bsfile;
	private String bdate;
	private MultipartFile file1;
}

