package com.eprogrammerz.examples.cloud.config;

import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Yogen on 10/9/2017.
 */
@Configuration
public class BeanConfig {
    @Bean
    public Sampler defaultSampler() {
        return new AlwaysSampler();
    }
}
