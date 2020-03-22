package com.example;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "feign-client",
        url = "http://organization-service-myproject.192.168.99.100.nip.io",
        configuration = FeignConfig.class)
public interface MyFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/feign/{id}/msg/{message}", produces = "application/json")
    String runTask(@PathVariable("id") String id, @PathVariable("message") String message);

}
