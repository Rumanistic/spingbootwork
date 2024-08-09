package com.study.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.domain.Board;
import com.study.springboot.domain.Member;
import com.study.springboot.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	BoardService bs;
	
	@RequestMapping("/bInsert")
	public String bInsert(Board board, Model model) {
		Member m = new Member();
		m.setId("root");
		
		board.setMember(m);
		
		Board b = bs.bInsert(board);
		model.addAttribute("b", b);
		
		return "bInsert";
	}
}
