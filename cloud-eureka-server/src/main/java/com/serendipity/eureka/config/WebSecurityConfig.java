package com.serendipity.eureka.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

/**
 * ClassName WebSecurityConfig
 * Description TODO
 * Author 11931
 * Date 2023-08-02:14:06
 * Version 1.0
 **/
// 这是因为加入了安全认证模块后，默认会开启 CSRF 跨站脚本攻击，需要禁用它，添加以下配置即可。
@Configuration
// @EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(AbstractHttpConfigurer::disable);
        return httpSecurity.build();
    }
}
