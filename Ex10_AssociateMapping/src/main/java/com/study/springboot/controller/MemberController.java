package com.study.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.domain.Member;
import com.study.springboot.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService ms;
	
	@RequestMapping("/")
	public String root() {
		return "index";
	}
	
	@RequestMapping("/mEnroll")
	public String mEnroll(Member member, Model model) {
		Member m = ms.mEnroll(member);
		model.addAttribute("m", m);
		return "mEnroll";
	}
}
