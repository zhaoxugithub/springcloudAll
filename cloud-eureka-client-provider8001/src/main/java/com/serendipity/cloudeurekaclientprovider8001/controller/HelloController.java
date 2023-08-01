package com.serendipity.cloudeurekaclientprovider8001.controller;

import com.serendipity.cloudeurekaclientprovider8001.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName HelloController
 * Description TODO
 * Author 11931
 * Date 2023-08-01:5:24
 * Version 1.0
 **/
@RestController
public class HelloController {
    @Autowired
    private HelloService helloService;

    @GetMapping("/getHello")
    public String hello() {
        return helloService.hello();
    }
}
