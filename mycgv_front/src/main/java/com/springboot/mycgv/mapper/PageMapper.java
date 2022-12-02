package com.springboot.mycgv.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PageMapper {
	
	int totalCount(String tableName);
	

}
