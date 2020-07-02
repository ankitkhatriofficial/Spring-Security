package com.Demo.SpringSecurity.configuration;

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
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	private DataSource securityDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
		// HARD CODED DATA BY ADDING SOME USER'S ID, PASSWORD, ROLE
		
	/*	UserBuilder users = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication()
		.withUser(users.username("bobby").password("test123").roles("EMPLOYEE"))
		.withUser(users.username("ankit").password("test123").roles("EMPLOYEE","MANAGER"))
		.withUser(users.username("khatri").password("test123").roles("EMPLOYEE","MANAGER","ADMIN"));
	*/
		
		// Dynamic Performance Using JDBC
		auth.jdbcAuthentication().dataSource(securityDataSource);
	} 

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/").hasAnyRole("EMPLOYEE","MANAGER","ADMIN")
			.antMatchers("/leaders/**").hasRole("MANAGER")
			.antMatchers("/systems/**").hasRole("ADMIN")
		.and()
			.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/auth").permitAll()
		.and()
			.logout().permitAll()
		.and()
			.exceptionHandling().accessDeniedPage("/access-denied");
	}

}
