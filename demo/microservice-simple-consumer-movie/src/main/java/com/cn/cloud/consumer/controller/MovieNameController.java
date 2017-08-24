package com.cn.cloud.consumer.controller;

import com.cn.cloud.consumer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2017/8/24 0024.
 */
@RestController
public class MovieNameController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("userName/{id}")
    public User findById(@PathVariable Long id) {
        return this.restTemplate.getForObject("http://MICROSERVICE-SIMPLE-PROVIDER-USER/" + id, User.class);
    }

}
