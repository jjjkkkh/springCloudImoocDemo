package com.example.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {

    //@Autowired
    //private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getProductMsg")
    public String getProductMsg(){

        //第一种方式：直接使用restTemplate（url写死）
        //RestTemplate restTemplate = new RestTemplate();
        //String response = restTemplate.getForObject("http://localhost:8763/msg",String.class);

        //第二种方式：利用loadBalancerClient通过应用名获取url，再使用restTemplate
        //RestTemplate restTemplate = new RestTemplate();
        //ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
        //String url = String.format("http://%s:%s/msg",serviceInstance.getHost(),serviceInstance.getPort());


        //第三种方式（使用@LoadBalanced，可在restTemplate中使用应用的名字）

        String response = restTemplate.getForObject("http://PRODUCT/msg",String.class);
        return response;
    }
}
