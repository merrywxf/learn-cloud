package com.cn.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.stream.Stream;

/**
 * Created by Administrator on 2017-08-24.
 */
@SpringBootApplication
public class ProviderApplication implements CommandLineRunner {
    @Autowired
    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String[] names = applicationContext.getBeanDefinitionNames();
        Stream.of(names).forEach(m -> {
            System.out.println(m + "==========================");
        });
    }
}
