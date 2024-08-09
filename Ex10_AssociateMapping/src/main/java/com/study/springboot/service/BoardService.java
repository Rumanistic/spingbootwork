package com.study.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.domain.Board;
import com.study.springboot.repository.BoardRepository;

@Service
public class BoardService {
	
	@Autowired
	BoardRepository br;

	public Board bInsert(Board board) {
		return br.save(board);
	}
}
