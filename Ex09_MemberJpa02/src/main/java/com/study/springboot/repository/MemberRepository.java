package com.study.springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.springboot.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{

	Optional<Member> findByUsername(String username);

	Optional<Member> findByEmail(String email);

	List<Member> findByUsernameLike(String username);
	
	List<Member> findByUsernameLikeOrderByUsernameDesc(String username);
}
