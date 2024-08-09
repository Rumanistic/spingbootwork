package exam4;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

/*
	@Entity: 해당 클래스가 JPA의엔티티임을 의미 (테이블과 매핑되는 JPA)
	@Id: primary key - 식별자
	@GeneratedValue: sequence - 자동 생성
*/
@Entity
public class Member4 {
	@Id
	private String email;
	private String name;
	@Column(name="create_date")
	private LocalDate createDate;
	
	public Member4() {
		
	}
	
	public Member4(String email, String name, LocalDate createDate) {
		this.email = email;
		this.name = name;
		this.createDate = createDate;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getName() {
		return name;
	}
	
	public LocalDate getCreateDate() {
		return createDate;
	}

	@Override
	public String toString() {
		return "Member4 [email=" + email + ", name=" + name + ", createDate=" + createDate + "]";
	}

	public void changeName(String tobeName) {
		this.name = tobeName;
	}
	
}
