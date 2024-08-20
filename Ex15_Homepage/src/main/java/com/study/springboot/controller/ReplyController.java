package com.study.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.study.springboot.domain.Reply;
import com.study.springboot.service.ReplyService;

@Controller
@SessionAttributes({"loginUser", "boardPage", "b"})
public class ReplyController {
	@Autowired
	ReplyService rs;

	@PostMapping("/replyList")
	public String replyList(@RequestParam(value="bno") Long bno, Model m) {
		Long refBno = bno;
		List<Reply> rList = rs.getDetailReply(refBno);
		m.addAttribute("rList", rList);
		return "redirect:/detailForm";
	}
}
