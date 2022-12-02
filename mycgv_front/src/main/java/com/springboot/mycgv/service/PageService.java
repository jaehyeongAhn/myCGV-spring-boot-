package com.springboot.mycgv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.mycgv.dto.PageDto;
import com.springboot.mycgv.mapper.PageMapper;
 

@Service
public class PageService {
	
	@Autowired
	private PageMapper pagemapper;
	
	public PageDto getPageCount(String rpage) {

		int startCount = 0;
		int endCount = 0;
		int pageSize = 5;	
		int reqPage = 1;		
		int pageCount = 1;	
		int dbCount = pagemapper.totalCount("cgv_board");	

		if(dbCount % pageSize == 0){
			pageCount = dbCount/pageSize;
		}else{
			pageCount = dbCount/pageSize+1;
		}
		
		if(rpage != null){
			reqPage = Integer.parseInt(rpage);			
			startCount = (reqPage-1) * pageSize+1;
			endCount = reqPage *pageSize;
		}else{
			startCount = 1;
			endCount = pageSize;
		}
		
		PageDto pageDto = new PageDto();
		pageDto.setStartCount(startCount);
		pageDto.setEndCount(endCount);
		pageDto.setDbCount(dbCount);
		pageDto.setPageSize(pageSize);
		pageDto.setReqPage(reqPage);
		pageDto.setPageCount(pageCount);
		
		return pageDto;
	}
}
