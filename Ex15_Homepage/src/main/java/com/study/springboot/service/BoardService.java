package com.study.springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.study.springboot.domain.Board;
import com.study.springboot.repository.BoardRepository;

@Service
public class BoardService {
	@Autowired
	BoardRepository br;

	public Board insertBoard(Board b) {
		return br.save(b);
	}

	public Page<Board> list(PageRequest of) {
		return br.findAll(of);
	}

	public Optional<Board> getBoardDetail(Long bno) {
		return br.findById(bno);
	}

}
