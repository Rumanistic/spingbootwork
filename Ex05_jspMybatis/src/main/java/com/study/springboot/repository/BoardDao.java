package com.study.springboot.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.study.springboot.dto.Board;

@Mapper
public interface BoardDao {
	public int totalRecord();
	public List<Board> list();
	public Board detail(String bno);
	public int delete(String bno);
	public int insert(Map<String, String> bMap);
}


