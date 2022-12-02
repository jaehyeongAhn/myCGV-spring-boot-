package com.springboot.mycgv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyCgvController {
	
	@GetMapping("/mycgv")
	public String root() {
		return "/mycgv/mycgv";
	}
}
