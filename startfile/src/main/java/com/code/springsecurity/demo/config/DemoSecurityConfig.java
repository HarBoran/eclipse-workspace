package com.code.springsecurity.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity //스프링 시큐리티 필터가 스프링 필터체인에 등록, 웹보안을 활성화함
public class DemoSecurityConfig  extends WebSecurityConfigurerAdapter{

	//로그인 정보를 작성하면 WebSecurityConfigurerAdapter에서 알아서 처리함
	
	@Autowired
	private DataSource securityDataSource;
	
	
	@Override //세부 설정을 위한 오버라이딩
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		
//		UserBuilder users = User.withDefaultPasswordEncoder();
//		auth.inMemoryAuthentication()
//			.withUser(users.username("test").password("123").roles("EMPLOYEE", "MANAGER", "ADMIN"))
//			.withUser(users.username("john").password("test123").roles("EMPLOYEE"))
//			.withUser(users.username("mary").password("test123").roles("EMPLOYEE", "MANAGER"))
//			.withUser(users.username("susan").password("test123").roles("EMPLOYEE", "ADMIN")); 
		auth.jdbcAuthentication().dataSource(securityDataSource);
	}
	
	/*
	roles 
	1. 접근성 Access Restrict
	2. 가시성 Visibility */
	
	
	
	@Override
   protected void configure(HttpSecurity http) throws Exception {
       http.authorizeRequests() //권환이 있는 요청
           		.antMatchers("/css/**").permitAll() //css 리소스 폴더에 접근 가능하게 만듬
           											//한줄 위에 있어야 로그인 전에 전적용할수 있음
           		//.anyRequest().authenticated()	 //모든사람이 접근했을때
           		.antMatchers("/").hasRole("EMPLOYEE")
           		.antMatchers("/leaders/**").hasRole("MANAGER")
           		.antMatchers("/systems/**").hasRole("ADMIN")
           	.and()
           		.formLogin()
           		.loginPage("/showMyLoginPage")
           		.loginProcessingUrl("/authenticateTheUser") //파라미터값을 받아옴/이곳으로 넘여야함
           		.permitAll();
       http.logout().logoutUrl("/customlogout").permitAll();
       //커트에러 페이지 생성하기
       http.exceptionHandling().accessDeniedPage("/access-denied");
        
	}
}
