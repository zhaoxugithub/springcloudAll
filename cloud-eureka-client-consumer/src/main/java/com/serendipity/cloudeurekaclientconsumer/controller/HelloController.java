package com.serendipity.cloudeurekaclientconsumer.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.serendipity.cloudeurekaclientconsumer.service.HelloService;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName HelloController
 * Description TODO
 * Author 11931
 * Date 2023-08-01:5:08
 * Version 1.0
 **/

/**
 * todo
 * 1. 搞清楚SpringCloud loadBalance 和ribbon
 * 2. 分文件夹写完RestTemplate
 * 3. 分文件夹写完Feign
 * <p>
 * <p>
 * 有一个不错的方法用来解耦消费者和生产者:
 * 1.提炼出一个接口聚合的项目,在这个接口里面可以集成swagger
 * 2.生产者和消费者服务,导入这个API接口聚合的项目依赖,这样子就可以继承实现这个接口API
 * 3.消费者通过feignclient 定义生产者的微服务名称
 * 4.这样的好处是可以解耦,并且,生产者和消费者并行开发,并且不用关心消费者是什么语言实现的
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    // spring cloud 定义的一套接口
    @Autowired
    private EurekaDiscoveryClient discoveryClient;

    @Autowired
    private EurekaClient eurekaClient;


    @Autowired
    private LoadBalancerClient lb;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/result")
    public String getHello() {
        return helloService.getProduct();
    }

    /*
    [
        "eurekaservice",
        "eureka-client-provider8001"
     ]
     */
    @RequestMapping("/getAllService")
    public List<String> getAllService() {
        return discoveryClient.getServices();
    }

    @RequestMapping("/getAllInstance")
    public List<ServiceInstance> getAllInstance() {
        return discoveryClient.getInstances("EUREKASERVICE");
    }


    @RequestMapping("/port")
    public String getPort() {
        return helloService.getPort();
    }


    /**
     * 通过eurekaClient获取所有instance
     *
     * @return
     */
    @RequestMapping("/getResByRest")
    public String getResByRest() {
        List<InstanceInfo> instanceInfos = eurekaClient.getInstancesByVipAddress("eureka-client-provider", false);
        for (InstanceInfo instanceInfo : instanceInfos) {
            System.out.println(ToStringBuilder.reflectionToString(instanceInfo));
        }
        if (!instanceInfos.isEmpty()) {
            InstanceInfo instanceInfo = instanceInfos.get(0);
            if (instanceInfo.getStatus() == InstanceInfo.InstanceStatus.UP) {
                String url = "http://" + instanceInfo.getHostName() + ":" + instanceInfo.getPort() + "/getHello";
                System.out.println(url);

                RestTemplate restTemplate = new RestTemplate();
                String forObject = restTemplate.getForObject(url, String.class);
                System.out.println(forObject);
                return forObject;
            }
        }
        return null;
    }


    /**
     * 通过Lb负载均衡客户端里面随机选择一个可用的服务
     *
     * @return
     */
    @RequestMapping("/getResByLB")
    public String getResByLB() {
        // 从application所属的sever里面随机选择一个UP状态的instance(服务)
        // 负载均衡算法可以自定义
        // 默认是轮训算法
        // restTemplate上面不需要加注解@LoadBalanced
        ServiceInstance serviceInstance = lb.choose("eureka-client-provider");
        System.out.println(serviceInstance);
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/getHello";
        return restTemplate.getForObject(url, String.class) + ":" + serviceInstance.getPort();
    }

    /**
     * 把负载均衡的算法策略集中到restTemplate里面,只需要在创建restTemplate的方法上加上一个注解
     *
     * @return
     */
    @RequestMapping("/getResByRestOverLB")
    public String getResByRestOverLB() {
        /**
         *restTemplate上面需要加注解@LoadBalanced
         */
        String url = "http://eureka-client-provider/getPort";
        System.out.println("aaaaabbbbcccc");
        return restTemplate.getForObject(url, String.class);
    }

    @RequestMapping("/map01")
    public Map test01RestTemplate() {
        String url = "http://eureka-client-provider/getMap";
        Map<String, String> params = new HashMap<>();
        params.put("params1", "1");
        Map forObject = restTemplate.postForObject(url, params, Map.class);
        System.out.println(forObject);
        return forObject;
    }

    @RequestMapping("/map02")
    public Map test01RestTemplate2() {
        String url = "http://eureka-client-provider/getMap";
        Map<String, Object> params = new HashMap<>();
        params.put("params1", "2");
        Map forObject = restTemplate.postForObject(url, params, Map.class);
        System.out.println(forObject);
        return forObject;
    }
}
