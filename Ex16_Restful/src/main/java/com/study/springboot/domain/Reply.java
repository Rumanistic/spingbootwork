package com.study.springboot.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@Entity(name="reply")
@EntityListeners(AuditingEntityListener.class)
public class Reply {
	@Id
	@SequenceGenerator(
				name = "replyNoSeq",
				sequenceName = "replyNoSeq",
				allocationSize = 1
			)
	@GeneratedValue(generator="replyNoSeq")
	private Long rno;
	@NonNull
	private String content;
	@NonNull
	private String writer;
	@NonNull
	@Column(name="ref_bno")
	private Long refBno;
	
	@CreatedDate
	@Column(name="created_date", insertable=false, updatable=false, columnDefinition="DATE DEFAULT SYSDATE")
	private LocalDateTime createdDate;
	
	@LastModifiedDate
	private LocalDateTime updatedDate;
}
