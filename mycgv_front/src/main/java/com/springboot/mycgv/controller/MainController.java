package com.springboot.mycgv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	
	@GetMapping("/")
	public String root() {
		return "/index";
	}
	/**
	 * footer 
	 */
	@GetMapping("/footer")
	public String footer() {
		return "/footer";
	}
	
	/**
	 * header 
	 */
	@GetMapping("/header")
	public String header() {
		return "/header";
	}
	
	
	/**
	 * index 
	 */
	@GetMapping("/index")
	public String index() {
		return "/index";
	}
	
}
