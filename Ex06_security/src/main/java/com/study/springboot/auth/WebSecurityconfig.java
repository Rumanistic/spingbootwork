package com.study.springboot.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import jakarta.servlet.DispatcherType;

@Configuration
public class WebSecurityconfig {
	
	@Autowired
	AuthenticationFailureHandler authenticationFailureHandler;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf((csrf) -> csrf.disable())
			.cors((cors) -> cors.disable())
			.authorizeHttpRequests(request -> request
				.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
				.requestMatchers("/").permitAll()
				.requestMatchers("/css/**", "/js/**", "/img/**").permitAll()
				.requestMatchers("/guest/**").permitAll()
				.requestMatchers("/member/**").hasAnyRole("member", "admin")
				.requestMatchers("/admin/**").hasRole("admin")
				.anyRequest().authenticated()
			);
			
//			.formLogin((formLogin) -> formLogin.permitAll())
//			.logout((logout) -> logout.permitAll());	이렇게 코드 체인 형태로 사용해도 됨
		
		http.formLogin((formLogin) -> formLogin
				.loginPage("/loginForm")					// 로그인 페이지 지정: form 이름 | default: /login
				.loginProcessingUrl("/loginCheck")			// 로그인 프로세싱 url: form 에 지정한 action
				.failureUrl("/loginForm?error")					// 로그인 실패 시 url: 이동할 페이지 지정
				.failureHandler(authenticationFailureHandler)
				.usernameParameter("username")				// username default: j_username
				.passwordParameter("pwd")					// passoword default: j_username
				.permitAll());
		
		http.logout((logout) -> logout.permitAll());
		
		return http.build();
	}
	
	// db에 저장하지 않고 메모리에 저장
	
	@Bean
	public UserDetailsService users() {
		UserDetails user = User.builder()
				.username("user")
				.password(pwdEncoder().encode("1234"))
				.roles("member")
				.build();
		
		UserDetails admin = User.builder()
				.username("admin")
				.password(pwdEncoder().encode("1234"))
				.roles("member", "admin")
				.build();
		
		return new InMemoryUserDetailsManager(user, admin);
	}
	
	// 패스워드 암호화를 위해 사용하는 메서드
	public PasswordEncoder pwdEncoder() {
		// Static Class: 객체로 만들지 않아도 바로 사용 가능
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
}
