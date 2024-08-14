package com.study.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.study.springboot.domain.Member;
import com.study.springboot.repository.MemberRepository;

@Service
public class MemberService {
	@Autowired
	MemberRepository mr;

	public List<Member> selectByNameLike1(String search) {
		return mr.findByNameLike1(search);
	}

	public List<Member> selectMembers2(String search, Sort sort) {
		return mr.selectMembers2(search, sort);
	}

	public Page<Member> selectMembers3(String search, Pageable pa) {
		return mr.selectMembers2(search, pa);
	}

	public List<Member> selectByNameLike4(String search) {
		return mr.selectByNameLike4(search);
	}

}
