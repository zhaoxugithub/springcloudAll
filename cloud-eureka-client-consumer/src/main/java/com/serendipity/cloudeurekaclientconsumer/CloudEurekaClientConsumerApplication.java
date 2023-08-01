package com.serendipity.cloudeurekaclientconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CloudEurekaClientConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaClientConsumerApplication.class, args);
    }

}
