package com.wba.leap.lastmile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.wba.leap.lastmile.interceptors.HeaderInterceptor;

@SpringBootApplication
public class LastMileApplication {
	public static void main(String[] args) {
		SpringApplication.run(LastMileApplication.class, args);
	}

	@Bean
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public FilterRegistrationBean leapAPIFilter() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new HeaderInterceptor());
		return registration;
	}
}
