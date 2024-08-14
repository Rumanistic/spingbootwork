package com.study.springboot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.study.springboot.domain.Member;
import com.study.springboot.service.MemberService;

@Controller
@SessionAttributes({"loginUser"})
public class MemberController {
	@Autowired
	MemberService ms;
	
	@Autowired
	PasswordEncoder pwdEncoder;
	
	@RequestMapping("/")
	public String root() {
		return "index";
	}
	
	@GetMapping("/enrollForm")
	public String enrollForm() {
		return "member/enrollForm";
	}
	
	@GetMapping("/idCheck")
	public @ResponseBody boolean idCheck(@RequestParam("userId") String userId) {
		return ms.idCheck(userId); 
	}
	
	@PostMapping("memberInsert")
	public String memberInsert(Member mem) {
		mem.setPassword(pwdEncoder.encode(mem.getPassword()));
		ms.memberInsert(mem);
		
		return "redirect:/";
	}
	
	@PostMapping("login")
	public String login(Member mem, Model m) {
		Optional<Member> loginUser = ms.login(mem);
		
		if(loginUser.isPresent()) {
			Member loginMember = loginUser.get();
			if(pwdEncoder.matches(mem.getPassword(), loginMember.getPassword())) {
				System.out.println("Password is correct!");
				loginMember.setId(mem.getId());
				m.addAttribute("loginUser", loginMember);
				return "redirect:/"; 
			}
		}
		return "redirect:/"; 
	}
	
	@GetMapping("logout")
	public String logout(SessionStatus ss) {
		if(!ss.isComplete())
			ss.setComplete();
		return "redirect:/";
	}
	
	@GetMapping("home")
	public String home() {
		return "redirect:/";
	}
}
