package com.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gateway.filters.AuthenticationFilter;

@Configuration
public class Route {
	
	
	 @Bean
	   public RouteLocator routeLocator(RouteLocatorBuilder rlb, AuthenticationFilter 
	   authorizationHeaderFilter) {

	       return rlb
	               .routes()
	               .route(p -> p
	                   .path("/pm/**")
	                   .filters(f -> f//.removeRequestHeader("Cookie")
	                           .rewritePath("/pm/(?<segment>.*)", "/$\\{segment}")
	                           .filter(authorizationHeaderFilter.apply(new 
	                            AuthenticationFilter.Config())))
	                .uri("lb://profile-manager")
	            )
	              
	               .route(p-> p.path("/auth/**").uri("lb://identity-service"))
	            .build();
	     }

}
