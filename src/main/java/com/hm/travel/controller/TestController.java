package com.hm.travel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: xiaomikasa
 * @date: 2019/8/24
 */
@Controller
public class TestController {

    @RequestMapping("index")
    public String index(){
        System.out.println("跳转到首页");
        return "userPage/index";
    }

    @RequestMapping("list")
    public String list(){
        System.out.println("跳转到景点列表页面");
        return "userPage/View-list";
    }

    @RequestMapping("detail")
    public String detail(){
        System.out.println("跳转到景点详情页面");
        return "userPage/View-detail";
    }

}
