package com.study.springboot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.springboot.domain.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

	Page<Board> findByTitleContaining(String qv, PageRequest of);

	Page<Board> findByWriterContaining(String qv, PageRequest of);

	Page<Board> findByContentContaining(String qv, PageRequest of);

}
