package com.serendipity.cloudeurekaclientconsumer.controller;

import com.serendipity.cloudeurekaclientconsumer.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName TestController
 * Description TODO
 * Author 11931
 * Date 2023-08-04:11:14
 * Version 1.0
 **/
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/test01")
    public String test01() {
        return testService.test01();
    }

    @GetMapping("/test02")
    public String test02() {
        return testService.test02();
    }

    @GetMapping("/test03")
    public String test03() {
        return testService.test03();
    }
}
