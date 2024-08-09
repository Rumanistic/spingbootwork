package com.study.springboot.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.springboot.domain.Member;
import com.study.springboot.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService ms;
	
	@RequestMapping("/")
	public String root() {
		return "menu";
	}
	
	@RequestMapping("/insert")
	public String insert(@RequestParam("username") String username, Model model) {
		Member m = Member.builder()
						 .username(username)
						 .createDate(LocalDate.now())
						 .build();
		Member rm = ms.insert(m);
		model.addAttribute("member", rm);
		return "insert";
	}
	
	@RequestMapping("/select")
	public String select(@RequestParam("id") Long id, Model m) {
		Optional<Member> om = ms.select(id);
		if(om.isPresent()) {
			m.addAttribute("member", om.get());
		} else {
			m.addAttribute("member", null);
		}
		return "select";
	}
	
	@RequestMapping("/selectAll")
	public String selectAll(Model m) {
		List<Member> mList = ms.selectAll();
		m.addAttribute("mList", mList);
		
		return "selectAll";
	}
	
	@RequestMapping("/update")
	public String update(Member m, Model model) {
		ms.update(m);
		return "update";
	}
	
	@RequestMapping("/delete")
	public String update(@RequestParam("id") Long id, Model model) {
		ms.delete(id);
		return "update";
	}
}
