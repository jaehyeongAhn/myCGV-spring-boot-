package com.springboot.mycgv.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.springboot.mycgv.dto.MemberDto;

@Mapper
public interface MemberMapper {
	int getJoin(MemberDto memberDto);
	int getLogin(MemberDto memberDto);

}
