package com.serendipity.cloudeurekaclientconsumer.config;

import com.serendipity.cloudeurekaclientconsumer.interceptor.MyBasicAuthRequestInterceptor;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName FeignConfig
 * Description TODO
 * Author 11931
 * Date 2023-08-04:14:09
 * Version 1.0
 **/
@Configuration
public class FeignConfig {
    @Bean
    public RequestInterceptor requestInterceptor() {
        return new MyBasicAuthRequestInterceptor();
    }
}
