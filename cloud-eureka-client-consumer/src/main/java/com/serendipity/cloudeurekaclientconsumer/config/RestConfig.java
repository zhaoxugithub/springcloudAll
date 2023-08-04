package com.serendipity.cloudeurekaclientconsumer.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName RestConfig
 * Description TODO
 * Author 11931
 * Date 2023-08-02:15:00
 * Version 1.0
 **/
@Configuration
public class RestConfig {

    // 启用默认客户端负载策略
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }
}
