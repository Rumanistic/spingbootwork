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
	
	public Member insert(Member m) {
		// save(): insert 할 때의 method; << JPA 에 있는 API
		Member rm = mr.save(m);
		return rm;
	}

	public Optional<Member> select(Long id) {
		Optional<Member> om = mr.findById(id);
		return om;
	}
	
	public List<Member> selectAll() {
		return mr.findAll();
	}

	public Member update(Member m) {
		return mr.save(m);
	}

	public void delete(Long id) {
		mr.deleteById(id);
		
	}

}
