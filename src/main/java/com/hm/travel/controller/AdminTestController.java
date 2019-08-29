package com.hm.travel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jlz
 * @date 2019/8/26 9:16
 */
@Controller
public class AdminTestController {

    @RequestMapping("/TourMangList")
    public String TourManageList(){
        System.out.println("跟团游列表页");
        return "adminPage/TourListPage";
    }

    /**
     * 跳转至游记列表页
     * @return
     */
    @RequestMapping("/AllTravelLogManageList")
    public String AllTravelLogManageList(){
        System.out.println("游记列表页");
        return "adminPage/all-travellog-manage-list";
    }

    /**
     * 跳转至游记详情页
     * @return
     */
    @RequestMapping("/AllTravelLogData")
    public String AllTravelLogData(){
        System.out.println("游记详情页");
        return "adminPage/all-travellog-data-list";
    }

}
