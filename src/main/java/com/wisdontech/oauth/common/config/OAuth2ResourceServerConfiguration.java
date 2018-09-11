/**
 * 
 */
package com.wisdontech.oauth.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @author tangqh
 *
 */
@Configuration
@EnableResourceServer
public class OAuth2ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	private static final String RESOURCE_ID = "api";

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.resourceId(RESOURCE_ID).stateless(true);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http// 设置不需要鉴权的目录
				.authorizeRequests()
				// 允许访问
				.antMatchers("/", "/oauth/**").permitAll()
				// swagger
				.antMatchers("/swagger-ui.html", "/swagger-resources", "/swagger-resources/**", "/v2/api-docs",
						"/webjars/**")
				.permitAll()
				// 允许静态资源
				.antMatchers("/assets/").permitAll()
				// 这里添加需要完整认证才能访问
				// .antMatchers("").fullyAuthenticated()
				// 除了上述路径，其余均需要鉴权后才能访问
				.and().authorizeRequests().anyRequest().authenticated()
				// 设置登录页和默认的跳转路径
				.and().formLogin()
				// 开启基本鉴权
				.and().httpBasic()
				// 记住登陆
				.and().rememberMe();
	}
}
