package com.study.springboot.multi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//  이름을 명시하지 않으면 빈의 이름은 소민자로 등록
@Component
public class Person {
	@Value("홍길동")
	private String name;
	@Value("홍가네")
	private String nickname;
	@Autowired // Print 객체 찾아서 자동으로 등록
	@Qualifier("printerA")
	private Printer printer;
	
	public Person() {
		
	}
	public Person(String name, String nickname, Printer printer) {
		super();
		this.name = name;
		this.nickname = nickname;
		this.printer = printer;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
	public void print() {
		printer.print("Hello " + name + " : " + nickname);
	}
	
}
