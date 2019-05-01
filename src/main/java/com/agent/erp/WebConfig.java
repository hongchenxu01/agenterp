package com.agent.erp;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
	        .antMatchers("/", "/static/**").permitAll()
	        .antMatchers("/admin/**","/upload/**").hasAnyRole("ADMIN")
	        .antMatchers("/order/**").hasAnyRole("USER","ADMIN")
	        .anyRequest().authenticated()
	        .and()
	        .formLogin()
	        .loginPage("/login").permitAll()
	        .and()
	        .logout().permitAll();
//	        .and()
//	        .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
	}

	
	
}
