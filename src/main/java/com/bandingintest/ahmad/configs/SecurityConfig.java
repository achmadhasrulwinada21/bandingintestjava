package com.bandingintest.ahmad.configs;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().
        	antMatchers(HttpMethod.GET, "/**").permitAll().
        	antMatchers(HttpMethod.POST, "/api/**").permitAll().
        	antMatchers(HttpMethod.GET, "/api/**").permitAll().
        	antMatchers(HttpMethod.GET, "/api/**/**").permitAll().
        	antMatchers(HttpMethod.PUT, "/api/**").permitAll().
        	antMatchers(HttpMethod.DELETE, "/api/**").permitAll().
        	antMatchers(HttpMethod.OPTIONS, "/api/**").permitAll().
        	anyRequest().authenticated();
    }

}
