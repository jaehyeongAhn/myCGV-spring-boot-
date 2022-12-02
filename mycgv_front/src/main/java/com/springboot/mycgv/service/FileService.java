package com.springboot.mycgv.service;

import java.io.File;
import java.net.URL;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.mycgv.dto.BoardDto;


@Service
public class FileService {
	
	@Value("${spring.servlet.multipart.location}")
	private String uploadPath;

	public boolean fileCheck(MultipartFile file) {
		if(file.getOriginalFilename().equals("")) {
			return false;
		}else {
			return true;
		}		
	}
	
	public BoardDto init(BoardDto dto) {
		MultipartFile file = dto.getFile1();
		
		if(file != null) {
			if(!file.getOriginalFilename().equals("")) {
				UUID uuid = UUID.randomUUID();
				dto.setBfile(file.getOriginalFilename());
				dto.setBsfile(uuid+"_"+file.getOriginalFilename());			
			}
		}
		
		return dto;
	}
	
	
	public void saveFile(BoardDto dto) throws Exception {
		File file = new File(uploadPath + dto.getBsfile());
		dto.getFile1().transferTo(file);
	}	
	
	
	public void deleteFile(String bsfile) throws Exception{
		File file = new File(uploadPath + bsfile);
		if(file.exists()) {
			file.delete();
		}
	}
	
}