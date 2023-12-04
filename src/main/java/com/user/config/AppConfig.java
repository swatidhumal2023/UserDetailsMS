package com.user.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.user.interceptor.UserControllerInterceptor;

@Configuration
public class AppConfig implements WebMvcConfigurer {

	@Autowired
	private UserControllerInterceptor userControllerInterceptor;

	/**
	 * Interceptor 
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {		
		registry.addInterceptor(userControllerInterceptor).addPathPatterns("/api/user/**");		
	}

}