package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	/*
		WebSecurityConfigurerAdapter
		This is the Java configuration class for writing the web based security configurations.
		
		1. Enforce the user to be authenticated prior to accessing any URL in your application
		2. Create a user with the username “user”, password “password”, and role of “ROLE_USER”
		3. Enables HTTP Basic and Form based authentication
		4. Spring Security will automatically render a login page and logout success page for you
	 */
	
//	@Autowired
//	private UserDetailsService userDetailsService;

	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsService);
		auth.inMemoryAuthentication().withUser("test").password("1111").roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers("/user/**")
			.access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPER')")
			.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPER')")
			.antMatchers("/super/**").access("hasRole('ROLE_SUPER')")
			.and()
			.formLogin().permitAll()
//			.formLogin().loginPage("/login").permitAll()
			.and()
			.logout().permitAll().logoutSuccessUrl("/");
	}
}