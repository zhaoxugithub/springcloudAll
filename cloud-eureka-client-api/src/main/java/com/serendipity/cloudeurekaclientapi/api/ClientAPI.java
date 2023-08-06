package com.serendipity.cloudeurekaclientapi.api;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * ClassName ClientAPI
 * Description TODO
 * Author 11931
 * Date 2023-08-04:10:51
 * Version 1.0
 **/
public interface ClientAPI {
    @GetMapping("/test01")
    String test01();

    @GetMapping("/test02")
    String test02();

    @GetMapping("/test03")
    String test03();
}
