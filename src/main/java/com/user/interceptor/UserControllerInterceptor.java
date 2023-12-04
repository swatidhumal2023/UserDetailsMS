package com.user.interceptor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.function.ServerRequest.Headers;

import com.user.exception.UserException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.java.Log;

@Log
@Component
public class UserControllerInterceptor implements HandlerInterceptor {

	@Value(value = "${user.token}")
	private String authorizationHeader;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		var headerKeyValue = request.getHeader("Authorization");
		if (headerKeyValue != null && !headerKeyValue.isBlank()) {
			if (headerKeyValue.equals(authorizationHeader)) {
				log.info("Valid Request");
				return true;
			} else {
				throw new UserException("Unauthorized Access");
			}
		} else {
			throw new UserException("Unauthorized Access");
		}
	}
}