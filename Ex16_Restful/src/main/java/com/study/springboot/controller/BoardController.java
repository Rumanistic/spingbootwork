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

import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes({"loginUser", "boardPage", "b"})
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
	
	@GetMapping("/queryBoard")
	public String queryBoard(
			@RequestParam(value="nowPage", defaultValue="0") int nowPage,
			@RequestParam(value="querySelector") String qs, 
			@RequestParam(value="queryValue") String qv, 
			Model m) {
		Page<Board> pageList = null;
		
		if(qv == null) {
			return "redirect:/list";
		}
		
		switch(qs) {
		case "title":
			pageList = bs.queryTitleList(qv, PageRequest.of(nowPage, 5, Sort.by(Sort.Direction.DESC, "bno")));
			break;
		case "writer":
			pageList = bs.queryWriterList(qv, PageRequest.of(nowPage, 5, Sort.by(Sort.Direction.DESC, "bno")));
			break;
		case "content":
			pageList = bs.queryContentList(qv, PageRequest.of(nowPage, 5, Sort.by(Sort.Direction.DESC, "bno")));
			break;
		}
		
		int pagePerBlock = 5;
		int endPage = Math.min(pageList.getTotalPages(), nowPage + pagePerBlock);
		
		m.addAttribute("boardPage", pageList);
		m.addAttribute("nowPage", nowPage);
		m.addAttribute("endPage", endPage);
		
		return "board/list";
	}
	
	@PostMapping("/insertBoard")
	public String insertBoard(Board b) {
		bs.insertBoard(b);
		return "redirect:/list";
	}
	
	@GetMapping("/detailForm")
	public String detailForm(@RequestParam(value="bno") Long bno,
			HttpSession hs,
			Model m) {
		hs.setAttribute("boardDetailUrl", "/detailForm?bno="+bno);
		Optional<Board> ob = bs.getBoardDetail(bno);
		if(ob.isPresent()) {
			Board b = ob.get();
			m.addAttribute("b", b);
		}
		return "board/detailForm";
	}
	
	@GetMapping("/editForm")
	public String editForm(@RequestParam(value="bno") Long bno, Model m) {
		Optional<Board> ob = bs.getBoardDetail(bno);
		if(ob.isPresent()) {
			Board b = ob.get();
			m.addAttribute("b", b);
		}
		return "board/editForm";
	}
	
	@PostMapping("/editBoardDetail")
	public String editBoardDetail(@RequestParam(value="bno") Long bno,
			@RequestParam(value="title") String title,
			@RequestParam(value="content") String content,
			Model m) {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n title : " + title + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
//		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n bno : " + bno);
		
		Optional<Board> ob = bs.getBoardDetail(bno);
		
		if(ob.isPresent()) {
			Board b = ob.get();
			b.setTitle(title);
			b.setContent(content);
			System.out.println(b);
			bs.editBoardDetail(b);
			
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n board : " + b + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			m.addAttribute("b", b);
		}
		return "board/detailForm";
	}
}
