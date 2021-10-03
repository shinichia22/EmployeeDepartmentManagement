package com.empdep.crud.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("Software")
										.password( passwordEncoder().encode("Test@123") )
										.roles("USER").and()
										.withUser("Abhishek").password( passwordEncoder().encode("Test@123"))
										.roles("USER","ADMIN");
						
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.httpBasic().and().authorizeRequests()
			.antMatchers(HttpMethod.DELETE,"/api/v1/emp/*").hasRole("ADMIN")
			.antMatchers(HttpMethod.PUT,"/api/v1/emp/**").hasRole("ADMIN")
			.antMatchers(HttpMethod.POST,"/api/v1/emp/**").hasRole("ADMIN")
			.antMatchers(HttpMethod.DELETE,"/api/v1/dep/*").hasRole("ADMIN")
			.antMatchers(HttpMethod.PUT,"/api/v1/dep/**").hasRole("ADMIN")
			.antMatchers(HttpMethod.POST,"/api/v1/dep/**").hasRole("ADMIN")

			.antMatchers(HttpMethod.GET ,"/api/v1/emp/*").hasAnyRole("USER","ADMIN")
			.antMatchers(HttpMethod.GET ,"/api/v1/dep/*").hasAnyRole("USER","ADMIN")
			.and().csrf().disable().headers().frameOptions().disable();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    } 
	
}
