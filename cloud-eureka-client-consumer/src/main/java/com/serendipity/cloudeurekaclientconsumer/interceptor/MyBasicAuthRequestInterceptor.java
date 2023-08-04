package com.serendipity.cloudeurekaclientconsumer.interceptor;

import feign.Request;
import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * ClassName MyBasicAuthRequestInterceptor
 * Description TODO
 * Author 11931
 * Date 2023-08-04:13:04
 * Version 1.0
 **/
public class MyBasicAuthRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        Request request = requestTemplate.request();
        System.out.println("myBasicAuthRequestInterceptor:" + request);
    }
}
