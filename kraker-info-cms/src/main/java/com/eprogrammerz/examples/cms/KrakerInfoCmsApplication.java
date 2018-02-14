package com.eprogrammerz.examples.cms;

import com.eprogrammerz.examples.cms.models.StorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableConfigurationProperties(StorageProperties.class)
public class KrakerInfoCmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(KrakerInfoCmsApplication.class, args);
	}
}
