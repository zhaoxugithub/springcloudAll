package com.serendipity.cloudeurekaclientprovider.controller;

import com.netflix.discovery.DiscoveryManager;
import com.serendipity.cloudeurekaclientprovider.service.HealthStatusService;
import com.serendipity.cloudeurekaclientprovider.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

/**
 * ClassName HelloController
 * Description TODO
 * Author 11931
 * Date 2023-08-01:5:24
 * Version 1.0
 **/
@RestController
public class HelloController {

    @Value("${server.port}")
    private String port;


    @Autowired
    private HelloService helloService;

    @Autowired
    private HealthStatusService healthStatusService;

    @GetMapping("/getHello")
    public String hello() {
        return helloService.hello();
    }

    @GetMapping("/getTest01")
    public String test01() {
        return helloService.test01();
    }

    @GetMapping("/heath")
    public String health(@RequestParam("status") Boolean status) {
        healthStatusService.setStatus(status);
        return healthStatusService.getHealth(true).toString();
    }

    @GetMapping("/getHealth")
    public String getHealth() {
        return healthStatusService.getHealth(true).toString();
    }

    @GetMapping("/getPort")
    public String getPort() {
        return "myport is =====" + port;
    }

    @GetMapping("/down")
    public String down() {
        DiscoveryManager.getInstance().shutdownComponent();
        return "下线成功";
    }

    @PostMapping("/getMap")
    public Map<String, Object> testRestTemplate(@RequestBody Map<String, String> map) {
        if (map.get("param").equals("1")) {
            return Collections.singletonMap("result", "hehe");
        } else {
            return Collections.singletonMap("resultObject", new int[]{1, 2, 3});
        }
    }
}
