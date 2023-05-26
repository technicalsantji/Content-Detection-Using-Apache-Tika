package com.text.SecurityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.text.service.UserDetailsServicesImpl;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
    private	UserDetailsServicesImpl userDetailsServicesImpl;
	
	@Autowired
	JwtAuthenticateEntryPoints jwtAuthenticateEntryPoints;
	
	@Autowired
	JwtAuthoticateFilters jwtAuthoticateFilters;
	
	
	
	
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManager();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		
		auth.userDetailsService(this.userDetailsServicesImpl).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf()
		.disable()
		.cors()
		.disable()
		.authorizeRequests()
		.antMatchers("/user/","/generate-token","/mail/sendmail").permitAll()
		.antMatchers(HttpMethod.OPTIONS).permitAll()
		.anyRequest().authenticated()
		.and()
		.exceptionHandling().authenticationEntryPoint(jwtAuthenticateEntryPoints)
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.addFilterBefore(jwtAuthoticateFilters, UsernamePasswordAuthenticationFilter.class);
		
		
		
		
		
		
	}

	
}
