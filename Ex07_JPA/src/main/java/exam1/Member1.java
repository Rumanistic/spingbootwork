package exam1;

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
@Table(name="Member1")
public class Member1 {
	@Id
	@GeneratedValue
	private Long id;	// 기본 자료형은 별도의 초기과정이 없으면 0으로 초기화를 해줌	
						// wrapper 클래스를 사용하는 이유는 초기값이 NULL, id가 없다는 것을 보장해줄 수 있기 때문 
	
	private String username;
	
	@Column(name="create_Date")
	private LocalDate createDate; 
	
	
	public Member1(String username, LocalDate createDate) {
		this.username = username;
		this.createDate = createDate;
	}
}
