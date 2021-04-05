package com.bccoer.provider.controller;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    EurekaClient eurekaClient;

    @RequestMapping("test")
    public void testDiscoveryClient(){
        System.out.println(eurekaClient.getApplications());
    }
}
