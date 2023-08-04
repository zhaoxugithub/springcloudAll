package com.serendipity.cloudeurekaclientconsumer.service;

import com.serendipity.cloudeurekaclientapi.api.ClientAPI;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

/**
 * ClassName TestService
 * Description TODO
 * Author 11931
 * Date 2023-08-04:11:21
 * Version 1.0
 **/

@FeignClient(name = "eureka-client-provider", contextId = "1")
@Service
public interface TestService extends ClientAPI {
}
