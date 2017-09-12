package com.chris;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangchaohui on 2017/9/12.
 */
@SpringBootApplication
@RestController
public class ApplicationController {

    @RequestMapping("/")
    public String home() {
        return "welcome to docker world";
    }

    public static void main(String[] args) {
        SpringApplication.run(ApplicationController.class,args);
    }
}
