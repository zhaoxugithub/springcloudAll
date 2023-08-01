package com.serendipity.cloudeurekaclientconsumer9001.controller;

import com.serendipity.cloudeurekaclientconsumer9001.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName HelloController
 * Description TODO
 * Author 11931
 * Date 2023-08-01:5:08
 * Version 1.0
 **/

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/result")
    public String getHello() {
        return helloService.getProduct();
    }
}
