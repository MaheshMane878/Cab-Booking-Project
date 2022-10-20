package com.example.demo.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRepository;


@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http)throws Exception{
		
			http
			
					.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
					.and()
					.authorizeRequests()
					.antMatchers("/signin").permitAll()
					.antMatchers("/driverControlldata/**").hasAnyRole("NORMAL")
					.antMatchers("/user/**").hasAnyRole("ADMIN")
					.antMatchers("/register/**").permitAll()
					.antMatchers("/trip/**").permitAll()
					.anyRequest()
					.authenticated()
					.and()
					.formLogin()
					.loginPage("/signin")
					.loginProcessingUrl("/dologin");
					
		
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication().withUser("mahesh").password(this.passwordEncoder().encode("abc")).roles("ADMIN");
		
		auth.inMemoryAuthentication().withUser("xyz").password(this.passwordEncoder().encode("xyz@123")).roles("NORMAL");
	}
	
	
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder(10);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
