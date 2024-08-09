package com.study.springboot.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity	
public class Board {
	@Id
	@GeneratedValue
	private Long bno;
	private String title;
	private String content;
	
	@ManyToOne
	@JoinColumn(name="writer")
	private Member member;
}
