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
    public String index() {
        System.out.println("跳转到首页");
        return "userPage/index";
    }

    @RequestMapping("tourList")
    public String tourList() {
        System.out.println("跳转到跟团游列表页面");
        return "userPage/tour-list";
    }

    @RequestMapping("tourDetail")
    public String tourDetail() {
        System.out.println("跳转到跟团游详情页面");
        return "userPage/tour-detail";
    }

    @RequestMapping("viewList")
    public String viewList() {
        System.out.println("跳转到景点列表页面");
        return "userPage/view-list";
    }

    @RequestMapping("viewDetail")
    public String viewDetail() {
        System.out.println("跳转到景点详情页面");
        return "userPage/view-detail";
    }

    @RequestMapping("travelLogList")
    public String travelLogList() {
        System.out.println("跳转到游记列表页面");
        return "userPage/travel-log";
    }

    @RequestMapping("travelLogDetail")
    public String travelLogDetail() {
        System.out.println("跳转到游记详情页面");
        return "userPage/travel-log-detail";
    }

    @RequestMapping("cityList")
    public String cityList() {
        System.out.println("跳转到城市列表页面");
        return "userPage/city-list";
    }

    @RequestMapping("cityDetail")
    public String cityDetail() {
        System.out.println("跳转到城市详情页面");
        return "userPage/city-detail";
    }

}
