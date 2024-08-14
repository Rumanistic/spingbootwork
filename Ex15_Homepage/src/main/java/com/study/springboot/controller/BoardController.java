package com.study.springboot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.study.springboot.domain.Board;
import com.study.springboot.service.BoardService;

@Controller
@SessionAttributes({"loginUser", "boardPage"})
public class BoardController {
	@Autowired
	BoardService bs;
	
	@GetMapping("/list")
	public String list(@RequestParam(value="nowPage", defaultValue="0") int nowPage, Model model) {
		Page<Board> pageList = bs.list(PageRequest.of(nowPage, 5, Sort.by(Sort.Direction.DESC, "bno")));
		int pagePerBlock = 5;
		int endPage = Math.min(pageList.getTotalPages(), nowPage + pagePerBlock);
		model.addAttribute("boardPage", pageList);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("endPage", endPage);
		return "board/list";
	}
	
	@GetMapping("/insertForm")
	public String insertForm() {
		return "board/insertForm";
	}
	
	@PostMapping("/insertBoard")
	public String insertBoard(Board b) {
		bs.insertBoard(b);
		return "redirect:/list";
	}
	
	@GetMapping("/detailForm")
	public String detailForm(@RequestParam(value="bno") Long bno, Model m) {
		Optional<Board> ob = bs.getBoardDetail(bno);
		if(ob.isPresent()) {
			Board b = ob.get();
			m.addAttribute("b", b);
		}
		return "board/detailForm";
	}
}
