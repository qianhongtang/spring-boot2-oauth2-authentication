package com.wisdontech.oauth;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan(basePackages = "com.wisdontech.oauth.*", annotationClass = Mapper.class)
@EnableCaching
public class OauthAuthorizeServerApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(OauthAuthorizeServerApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(OauthAuthorizeServerApplication.class);
	}

}
