package com.xiaomikasa.springbootdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 陈敏华
        * @date: 2019/8/19
        */
@RestController
public class MyController {

    @RequestMapping("/hello")
    public String Test(){
        return "hello world!";
    }
}
