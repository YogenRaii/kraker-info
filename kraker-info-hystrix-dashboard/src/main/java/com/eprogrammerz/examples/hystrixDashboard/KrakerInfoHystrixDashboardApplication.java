package com.eprogrammerz.examples.hystrixDashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@EnableHystrixDashboard
@EnableTurbine
@EnableEurekaClient
@SpringBootApplication
public class KrakerInfoHystrixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(KrakerInfoHystrixDashboardApplication.class, args);
	}
}
