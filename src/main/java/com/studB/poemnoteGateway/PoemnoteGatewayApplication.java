package com.studB.poemnoteGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PoemnoteGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(PoemnoteGatewayApplication.class, args);
	}

	// @Bean
	// public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
	// 	return build.routes().route( res -> res.path("/poemnote/**")
	// 			.filters(f -> f.addRequestHeader("filter-check", "yeah"))
	// 			.uri("http://localhost:9000"))
	// 			.build();
	// }

}
