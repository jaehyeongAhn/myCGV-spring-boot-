package com.springboot.mycgv.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.springboot.mycgv.dto.BoardDto;
import com.springboot.mycgv.dto.PageDto;

@Mapper
public interface BoardMapper {
	List<BoardDto> getList(PageDto pageDto);
	int getWrite(BoardDto boardDto);
	BoardDto getContent(String bid);
	int getUpdate(BoardDto boardDto);
	int getDelete(BoardDto boardDto);
}
