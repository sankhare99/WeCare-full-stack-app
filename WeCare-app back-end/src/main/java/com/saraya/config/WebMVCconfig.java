package com.saraya.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@Configuration
public class WebMVCconfig extends AcceptHeaderLocaleResolver implements WebMvcConfigurer {
	
	private final long MAX_AGE = 3600;
	
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
		.allowedOrigins("*")
		.allowedHeaders("*")
		.allowedMethods("HEAD", "OPTIONS","GET", "POST", "PUT", "PATCH", "DELETE")
		.maxAge(MAX_AGE);
		          
	}
	

}
