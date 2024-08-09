package com.study.springboot.auth;

import java.io.IOException;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class CustomFailureHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		String loginId = request.getParameter("username");
		String errormsg = "";
		
		if(exception instanceof BadCredentialsException) {
			errormsg = "입력하신 정보와 일치하는 계정이 없습니다.";
		} else if(exception instanceof InternalAuthenticationServiceException) {
			errormsg = "입력하신 정보와 일치하는 계정이 없습니다.";
		} else if(exception instanceof DisabledException) {
			errormsg = "입력하신 계정은 비활성화된 계정입니다.";
		} else if(exception instanceof CredentialsExpiredException) {
			errormsg = "입력하신 계정의 비밀번호 유효기간이 만료되었습니다.";
		}
		
		request.setAttribute("username", loginId);
		request.setAttribute("errormsg", errormsg);
		
		request.getRequestDispatcher("/loginForm?error").forward(request, response);
	}

}
