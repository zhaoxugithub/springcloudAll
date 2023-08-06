package com.serendipity.cloudeurekaclientprovider.controller;

import com.serendipity.cloudeurekaclientapi.api.ClientAPI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * ClassName TestController
 * Description TODO
 * Author 11931
 * Date 2023-08-04:10:54
 * Version 1.0
 **/
@RestController
public class TestController implements ClientAPI {

    @Value("${server.port}")
    private String port;
    private final AtomicInteger count02 = new AtomicInteger(0);
    private final AtomicInteger count03 = new AtomicInteger(0);

    @Override
    public String test01() {
        System.out.println("provider:" + port + ":test01");
        return "provider:" + port + ":test01";
    }

    @Override
    public String test02() {
        try {
            System.out.println(port + "start....");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int i = count02.incrementAndGet();
        System.out.println("provider:" + port + ":test02,第" + i + "次调用..");
        return "provider:" + port + ":test02,第" + i + "次调用..";
    }

    @Override
    public String test03() {
        int i = count03.incrementAndGet();
        System.out.println("provider:" + port + ":test03,第" + i + "次调用..");
        return "provider:" + port + ":test03,第" + i + "次调用..";
    }
}
