package com.text.SecurityConfig;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.text.service.UserDetailsServicesImpl;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthoticateFilters extends OncePerRequestFilter{

	@Autowired 
	UserDetailsServicesImpl userDetailsServicesImpl;
	
	@Autowired 
     private JwtUtil jwtUtil;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
	
	final String requestTokenHeader = request.getHeader("Authorization");
	System.out.println(requestTokenHeader);
	String username=null;
	String jwtToken=null;
	
	if (requestTokenHeader!=null) {
		jwtToken=requestTokenHeader;
		
		try {
			username = this.jwtUtil.extractUsername(jwtToken);
		} catch (ExpiredJwtException e) {
			System.out.println("jwt token expired");
		}catch (Exception e) {
			System.out.println("error");
		}
	}else {
		System.out.println("invalid token, start with bearer");
	}
	
	if (username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
		
	final UserDetails userDetails = this.userDetailsServicesImpl.loadUserByUsername(username);
		
	if (this.jwtUtil.validateToken(jwtToken, userDetails)) {
		
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
		usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
	}
	
	}else {
		System.out.println("token is not valid");
	}
	
       filterChain.doFilter(request, response);
		
	}

}
