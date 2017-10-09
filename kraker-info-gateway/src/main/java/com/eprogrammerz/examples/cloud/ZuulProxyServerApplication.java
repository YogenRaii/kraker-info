package com.eprogrammerz.examples.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuulProxyServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulProxyServerApplication.class, args);
    }
}
