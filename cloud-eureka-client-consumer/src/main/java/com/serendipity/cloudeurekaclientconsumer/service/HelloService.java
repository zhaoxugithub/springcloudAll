package com.serendipity.cloudeurekaclientconsumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName HelloService
 * Description TODO
 * Author 11931
 * Date 2023-08-01:5:21
 * Version 1.0
 **/
// name 为product项目中application.yml配置文件中的application.name;
// path 为product项目中application.yml配置文件中的context.path;
@FeignClient(name = "eureka-client-provider8001")
//@Componet注解最好加上，不加idea会显示有错误，但是不影响系统运行；
@Service
public interface HelloService {
    @RequestMapping(value = "/getHello")
    String getProduct();

    @RequestMapping(value = "/getTest01")
    String getTest01();
}
