package exam3;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

/*
	@Entity: 해당 클래스가 JPA의엔티티임을 의미 (테이블과 매핑되는 JPA)
	@Id: primary key - 식별자
	@GeneratedValue: sequence - 자동 생성
*/
@Entity
@Table(name="JpaMember3")
public class Member3 {
	@Id
	@SequenceGenerator(
			name="mySequence01",
			sequenceName="seq_JpaMem3",
			initialValue=1,
			allocationSize=5
			)
	@GeneratedValue(generator="mySequence01")
	private Long id;
	
	@Access(AccessType.FIELD)
	private String username;
	
	@Access(AccessType.PROPERTY)
	private String password;
	
	@Transient
	private long timestamp1;
	transient private long timestamp2;
	
	public Member3() {
		
	}
	
	public Member3(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
