package com.study.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * 	로그 활용
 * 	- 애플리케이션의 흐름을 모니터링할 수 있음
 * 	- 프로그램 코드의 예기치 못한 오류를 포착하는데 도움을 줌
 *  - 스프링부트 스타터 패키지에는 "별도의 구성 없이" 로깅에 쓸 수 있는 로그백이 있음
 *  
 *  > 로깅 수준
 *  	: 7가지 수준이 있고, 설정하면 해당 로깅 수준 이상이 출력됨
 *  		- off: 출력 없음
 *  		- FATAL: 애플리케이션 실행 시 심각한 오류 발생 시
 *  		- ERROR: 애플리케이션 실행 시 꽤 심각한 오류 발생 시
 *  		- WARN: 애플리케이션의 실행에는 큰 지장이 없으나 오류가 발생할 수 있는 상황 발생 시
 *  		- INFO: 애플리케이션의 중요한 실행 정보
 *  		- DEBUG: 애플리케이션의 내부 실행에 대한 정보
 *  		- TRACE: 실행하는 모든 정보를 로깅, 실행 트래킹
 *  		- ALL: 모든 로깅 정보
 */

@SpringBootApplication
public class Ex03LoggerApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(Ex03LoggerApplication.class, args);
	}

}
