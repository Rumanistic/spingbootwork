package com.study.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	@RequestMapping("/")
	public @ResponseBody String root() throws Exception {
		return "Welcome!!!";
	}
	
	@RequestMapping("/guest/home")
	public String guestHome() {
		return "guest/guestWelcome";
	}
	
	@RequestMapping("/member/home")
	public String memberHome() {
		return "member/memberWelcome";
	}
	
	@RequestMapping("/admin/home")
	public String adminHome() {
		return "admin/adminWelcome";
	}
	
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "security/loginForm";
	}
	
	@RequestMapping("/loginError")
	public String loginError() {
		return "security/loginError";
	}
}
