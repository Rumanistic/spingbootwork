package com.study.springboot.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

// @CreatedDate와 @LastModifiedDate를 사용할 때 반드시 추가
@EntityListeners(AuditingEntityListener.class)
@Entity(name="member03")
public class Member {
	@Id
	private String id;
	private String name;
	private String password;
	
	@CreatedDate
	@Column(name="created_at")
	private LocalDateTime createdDate;
	
	@LastModifiedDate
	@Column(name="modified_at")
	private LocalDateTime lastModifiedDate; 
}
