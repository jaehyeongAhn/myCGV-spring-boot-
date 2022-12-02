package com.springboot.mycgv.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.springboot.mycgv.dto.NoticeDto;
import com.springboot.mycgv.dto.PageDto;

@Mapper
public interface NoticeMapper {
	int getTotalCount();
	List<NoticeDto> getList(PageDto pageDto); 
	NoticeDto getContent(String nid);	
	void getUpdateHits(String nid);     
	int getWriteResult(NoticeDto vo);		
	int getUpdate(NoticeDto vo);		
	int getDelete(NoticeDto vo);
}