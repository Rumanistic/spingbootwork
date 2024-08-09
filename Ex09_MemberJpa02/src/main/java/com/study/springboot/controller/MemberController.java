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
	
	@RequestMapping("/selectAll")
	public String selectAll(Model m) {
		List<Member> mList = ms.selectAll();
		m.addAttribute("mList", mList);
		m.addAttribute("title", "All");
		return "selectAll";
	}
	
	@RequestMapping("/selectById")
	public String selectById(@RequestParam("id") Long id, Model m) {
		Optional<Member> mem = ms.select(id);
		if(mem.isPresent()) {
			m.addAttribute("m", mem.get());
		} else {
			m.addAttribute("m", null);
		}
		m.addAttribute("title", "Id");
		return "selectBy";
	}
	
	@RequestMapping("/selectByName")
	public String selectById(@RequestParam("username") String username, Model m) {
		Optional<Member> mem = ms.selectByName(username);
		if(mem.isPresent()) {
			m.addAttribute("m", mem.get());
		} else {
			m.addAttribute("m", null);
		}
		m.addAttribute("title", "Name");
		return "selectBy";
	}
	
	@RequestMapping("/selectByEmail")
	public String selectByEmail(@RequestParam("email") String email, Model m) {
		Optional<Member> mem = ms.selectByEmail(email);
		if(mem.isPresent()) {
			m.addAttribute("m", mem.get());
		} else {
			m.addAttribute("m", null);
		}
		m.addAttribute("title", "Email");
		return "selectBy";
	}
	
	@RequestMapping("/selectByNameLike")
	public String selectByNameLike(@RequestParam("name") String name, Model m) {
		String username = "%" + name + "%";
		List<Member> mList = ms.selectByNameLike(username);
		m.addAttribute("mList", mList);
		m.addAttribute("title", "AllNameLike");
		return "selectAll";
	}
	
	@RequestMapping("/selectByNameLikeDesc")
	public String selectByNameLikeDesc(@RequestParam("name") String name, Model m) {
		String username = "%" + name + "%";
		List<Member> mList = ms.selectByNameLikeDesc(username);
		m.addAttribute("mList", mList);
		m.addAttribute("title", "AllNameLikeDesc");
		return "selectAll";
	}
}
