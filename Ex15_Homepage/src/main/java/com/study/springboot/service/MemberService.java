package com.study.springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.domain.Member;
import com.study.springboot.repository.MemberRepository;

@Service
public class MemberService {
	@Autowired
	MemberRepository mr;

	public boolean idCheck(String userId) {
		// ID 존재 여부를 검색하여 true|false 반환
		return mr.existsById(userId);
	}

	public Member memberInsert(Member m) {
		return mr.save(m);
	}

	public Optional<Member> login(Member mem) {
		return mr.findById(mem.getId());
	}
}
