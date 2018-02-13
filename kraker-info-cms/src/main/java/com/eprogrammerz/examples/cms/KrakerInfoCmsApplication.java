package com.eprogrammerz.examples.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class KrakerInfoCmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(KrakerInfoCmsApplication.class, args);
	}
}
