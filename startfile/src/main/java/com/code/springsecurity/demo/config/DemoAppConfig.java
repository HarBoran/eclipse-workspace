package com.code.springsecurity.demo.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration //설정파일을 만들기 위한 애노테이션 or Bean을 등록하기 위한 애노테이션이다.
@EnableWebMvc //이부분 MVC
@ComponentScan(basePackages="com.code.springsecurity.demo") //구성요소를 스캔하겠다
@PropertySource("classpath:persistence-mysql.properties")  //디비설정과 연결하곘다
public class DemoAppConfig  implements WebMvcConfigurer{
	
	@Autowired
	private Environment env;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Bean //@Configuration과 함께 사용하며, 자바클래스 내에 그 종속성을 매스드화(인스턴스화)하는데 사용한다
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
		
	}
		
	
	@Bean
	public DataSource securityDataSource() {
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
		
		//jdbc 커넥션 풀설정
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		
		logger.info(">>>>>jdbc.url===" + env.getProperty("jdbc.driver"));
		logger.info(">>>>>jdbc.url===" + env.getProperty("jdbc.url"));
		
		
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));
		
		securityDataSource.setInitialPoolSize(getInt("connection.pool.initialPoolSize"));
		securityDataSource.setMinPoolSize(getInt("connection.pool.minPoolSize"));
		securityDataSource.setMaxPoolSize(getInt("connection.pool.maxPoolSize"));
		securityDataSource.setMaxIdleTime(getInt("connection.pool.maxIdleTime"));
		
		return securityDataSource;
	
	}
	
	private int getInt(String st) {
		int in = Integer.parseInt(env.getProperty(st));
		return in; 		
	}
	
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("/css/");
	}
}
