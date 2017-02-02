package com.ch8ch8cacheredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

//使用redis做缓存
@SpringBootApplication
@EnableCaching
public class Ch85Application {

    public static void main(String[] args) {
        SpringApplication.run(Ch85Application.class, args);
    }
}
