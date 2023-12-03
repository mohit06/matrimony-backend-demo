package com.gateway.filters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.gateway.RouteValidator;
import com.gateway.services.UserInfoService;
import com.gateway.util.JwtUtil;
import com.google.common.net.HttpHeaders;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {
	
	@Autowired
	private UserInfoService userDetailsService;
	
	@Autowired
	private RouteValidator rv;

	@Autowired
	private JwtUtil util;
	
	public AuthenticationFilter() {
		super(Config.class);
	}
	
	public static class Config{
		
	}

	@Override
	public GatewayFilter apply(Config config) {
		// TODO Auto-generated method stub
		System.out.println("METHOD CALLED");
		return (exchange,chain)->{
			
			ServerHttpRequest request = exchange.getRequest();
			String username = null;
			if(rv.isSecured.test(request)) {
				
				if(!request.getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
					throw new RuntimeException("Missing Authorization Header");
				}
				String authHeader =request.getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
				if(authHeader != null && authHeader.startsWith("Bearer ")) {
					authHeader=authHeader.substring(7);
					username = util.extractUsername(authHeader);
				}
				
				if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
					UserDetails userDetails = userDetailsService.loadUserByUsername(username);
					
					if (util.validateToken(authHeader, userDetails)) {
						UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,
								null, userDetails.getAuthorities());
						//authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request.));
						authToken.setDetails(userDetails);
						SecurityContextHolder.getContext().setAuthentication(authToken);
						
						
					}
				}
			}else {
				throw new RuntimeException("Something wrong with header");
			}
			
			return chain.filter(exchange);
		};
	}
}
