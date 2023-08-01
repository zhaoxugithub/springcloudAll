package com.serendipity.cloudeurekaclientconsumer9001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CloudEurekaClientConsumer9001Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaClientConsumer9001Application.class, args);
    }

}
