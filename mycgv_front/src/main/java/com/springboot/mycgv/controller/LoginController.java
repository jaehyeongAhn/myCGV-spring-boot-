package com.springboot.mycgv.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.mycgv.dto.MemberDto;
import com.springboot.mycgv.service.MemberService;

@Controller
public class LoginController {
	
	@Autowired
	private MemberService memService;
	
	/**
	 * login 
	 */
	@GetMapping("/login")
	public String login() {
		return "/login/login";
	}
	
	@PostMapping("/login")
	public String loginPost(MemberDto memberDto, Model model, HttpSession session) {
		
		int result = memService.getLogin(memberDto);
		
		if(result == 1) {
			//세션객체에 sid 추가하기 !!
			session.setAttribute("sid", memberDto.getId());
			model.addAttribute("login_result", "ok");
		} else { 
			model.addAttribute("login_result", "fail");
		}
		
		
		return "/index";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session, Model model) {
		String sid = (String)session.getAttribute("sid");
		
		if(sid != null) session.invalidate();
		
		model.addAttribute("logout_result","ok");
		
		return "/index";
	}
	
 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	 
}
