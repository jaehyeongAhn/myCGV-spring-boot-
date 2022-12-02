package com.springboot.mycgv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.springboot.mycgv.dto.NoticeDto;
import com.springboot.mycgv.dto.PageDto;
import com.springboot.mycgv.service.NoticeService;
import com.springboot.mycgv.service.PageService;


@Controller
public class NoticeController{
	
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private PageService pageService;
	
	@ResponseBody
	@RequestMapping(value="/notice_content_json", method=RequestMethod.GET
	 					, produces="text/plain;charset=UTF-8")
	public String notice_content_json(String nid) {

		NoticeDto vo = noticeService.getContent(nid);
		
		if(vo != null){
			noticeService.getUpdateHits(nid);
		}
		
		Gson gson = new Gson();
		JsonObject jobject = new JsonObject();
		jobject.addProperty("nid", vo.getNid());
		jobject.addProperty("ntitle", vo.getNtitle());
		jobject.addProperty("ncontent", vo.getNcontent());
		jobject.addProperty("nhits", vo.getNhits());
		jobject.addProperty("ndate", vo.getNdate());
		
		return gson.toJson(jobject); 
		
	}
	
	@ResponseBody
	@RequestMapping(value="/notice_list_json", method=RequestMethod.GET
	 					, produces="text/plain;charset=UTF-8")
	public String notice_list_json(String rpage) {
		
		PageDto param = pageService.getPageCount(rpage);
		List<NoticeDto> list = noticeService.getList(param);
		
		
		JsonObject jobject = new JsonObject(); //CgvNoticeVO
		JsonArray jarray = new JsonArray();  //ArrayList
		Gson gson = new Gson();
		
		for(NoticeDto vo : list){
			JsonObject jo = new JsonObject();
			jo.addProperty("rno", vo.getRno());
			jo.addProperty("nid", vo.getNid());
			jo.addProperty("ntitle", vo.getNtitle());
			jo.addProperty("ndate", vo.getNdate());
			jo.addProperty("nhits", vo.getNhits());
			
			jarray.add(jo);
		}
		
		jobject.add("list", jarray); 
		jobject.addProperty("dbCount", param.getDbCount());
		jobject.addProperty("pageSize", param.getPageSize());
		jobject.addProperty("rpage", param.getReqPage());
		jobject.addProperty("pageCount", param.getPageCount());
		
		
		return gson.toJson(jobject);
	}
	
	@GetMapping("/notice_list")
	public String notice_list() {
		return "/notice/notice_list";
	}
}
