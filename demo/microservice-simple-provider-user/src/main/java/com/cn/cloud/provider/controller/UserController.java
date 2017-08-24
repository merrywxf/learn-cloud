package com.cn.cloud.provider.controller;

import com.cn.cloud.provider.model.User;
import com.cn.cloud.provider.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017-08-24.
 */
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        System.out.println(userRepository.getClass().getName());
        User user = this.userRepository.findOne(id);
//        this.userRepository.findAll().sort(new Comparator<User>() {
//            @Override
//            public int compare(User o1, User o2) {
//                return o2.getId().compareTo(o1.getId());
//            }
//        });
        return user;
    }
}
