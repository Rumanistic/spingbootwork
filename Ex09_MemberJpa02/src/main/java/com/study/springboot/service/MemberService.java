package com.study.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.domain.Member;
import com.study.springboot.repository.MemberRepository;

@Service
public class MemberService {
	@Autowired
	MemberRepository mr;
	
	public List<Member> selectAll() {
		return mr.findAll();
	}

	public Optional<Member> select(Long id) {
		Optional<Member> m = mr.findById(id); 
		return m;
	}
	
	public Optional<Member> selectByName(String username) {
		Optional<Member> m = mr.findByUsername(username); 
		return m;
	}

	public Optional<Member> selectByEmail(String email) {
		Optional<Member> m = mr.findByEmail(email); 
		return m;
	}

	public List<Member> selectByNameLike(String username) {
		return mr.findByUsernameLike(username); 
	}

	public List<Member> selectByNameLikeDesc(String username) {
		return mr.findByUsernameLikeOrderByUsernameDesc(username); 
	}

}
