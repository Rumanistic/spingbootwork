package exam2;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*
	@Entity: 해당 클래스가 JPA의엔티티임을 의미 (테이블과 매핑되는 JPA)
	@Id: primary key - 식별자
	@GeneratedValue: sequence - 자동 생성
*/
@Entity
public class Member2 {
	@Id
	@GeneratedValue
	private Long id;
	
	private String username;
	
	@Column(name="create_date")
	private LocalDate createDate;
	
	public Member2() {
		
	}
	
	public Member2(String username, LocalDate createDate) {
		this.username = username;
		this.createDate = createDate;
	}
}
