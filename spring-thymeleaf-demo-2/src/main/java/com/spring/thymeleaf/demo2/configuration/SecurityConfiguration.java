package com.spring.thymeleaf.demo2.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/sbadmin/**", "/vendor/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/login*")
					.anonymous()
				.antMatchers("/sbadmin/**")
					.authenticated()
			.and()
			.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/loginspring")
				.failureUrl("/login?error=true")
				.defaultSuccessUrl("/sbadmin/index", true)
			.and()
			.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login")
				.clearAuthentication(true)
				.permitAll()
			.and()
				.csrf()
					.disable()
				.cors()
					.disable();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
		builder
//			.jdbcAuthentication()
//				.passwordEncoder(passwordEncoder())
//				.dataSource(getApplicationContext().getBean(DataSource.class))
//					.usersByUsernameQuery("SELECT usuario, clave, estado FROM USUARIO where usuario = ?");
			.inMemoryAuthentication()
				.withUser("admin").password("1").authorities("ADMINISTRADOR");
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder;
	}
}
