package com.study.springboot.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="jpapaging")
public class Member {
	@Id
	@SequenceGenerator(
				name = "pagingseq",
				sequenceName = "jpapaging_seq",
				initialValue = 1,
				allocationSize = 1
			)
	@GeneratedValue
	private Long id;
	private String email;
	private String name;
}
