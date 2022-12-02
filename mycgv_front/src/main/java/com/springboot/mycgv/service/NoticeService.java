package com.springboot.mycgv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.mycgv.dto.NoticeDto;
import com.springboot.mycgv.dto.PageDto;
import com.springboot.mycgv.mapper.NoticeMapper;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeMapper noticedao;
	
	public int getTotalCount() {
		return noticedao.getTotalCount();
	}
	public int getWriteResult(NoticeDto vo) {
		return noticedao.getWriteResult(vo);
	}
	public int getUpdate(NoticeDto vo) {
		return noticedao.getUpdate(vo);
	}
	public int getDelete(NoticeDto vo) {
		return noticedao.getDelete(vo);
	}
	public void getUpdateHits(String nid) {
		noticedao.getUpdateHits(nid);
	}
	public NoticeDto getContent(String nid) {
		return noticedao.getContent(nid);
	}
	public List<NoticeDto> getList(PageDto pageDto){
		return noticedao.getList(pageDto);
	}
}
