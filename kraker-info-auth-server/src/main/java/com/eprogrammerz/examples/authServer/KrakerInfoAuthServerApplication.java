package com.eprogrammerz.examples.authServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableAuthorizationServer
@EnableEurekaClient
@EnableResourceServer
public class KrakerInfoAuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KrakerInfoAuthServerApplication.class, args);
	}
}
