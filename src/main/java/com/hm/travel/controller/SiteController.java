package com.hm.travel.controller;

import com.hm.travel.pojo.*;
import com.hm.travel.service.CityService;
import com.hm.travel.service.TourService;
import com.hm.travel.service.TravelLogService;
import com.hm.travel.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 跳转控制
 *
 * @author: xiaomikasa
 * @date: 2019/8/24
 */
@Controller
public class SiteController {
    @Autowired
    private TravelLogService travelLogService;

    @Autowired
    private ViewService viewService;

    @Autowired
    private CityService cityService;

    @Autowired
    private TourService tourService;

    /**
     * 跳转到首页,加并载首页数据
     *
     * @param model
     * @return
     */
    @RequestMapping("index")
    public String index(Model model) {
        //加载跟团游
        List<Tour> tours = tourService.selectTourByHead();
        model.addAttribute("tours", tours);

        //加载四个城市
        List<City> cities = cityService.searchHotCity();
        model.addAttribute("cities", cities);

        //加载六个城市
        List<City> sixCity = cityService.searchHotSixCity();
        model.addAttribute("sixCity", sixCity);

        //加载景点
        List<View> views = viewService.searchHotView();
        model.addAttribute("views", views);

        //加载游记
        List<TravelLog> travelLogs = travelLogService.getIndexTravelLog();
        model.addAttribute("travelLogs", travelLogs);
        return "userPage/index";
    }

    /**
     * 首页搜索跳转
     *
     * @param search     搜索内容
     * @param searchType 搜索类型
     * @return
     */
    @RequestMapping("search")
    public String search(@RequestParam("search") String search, @RequestParam("searchType") String searchType, Model model) {
        model.addAttribute("search", search == null ? "" : search);
        switch (searchType) {
            case "tour":
                return "userPage/tour-list";
            case "city":
                return "userPage/city-list";
            case "view":
                return "userPage/view-list";
            case "travelLog":
                return "userPage/travel-log";
            default:
                break;
        }
        return null;
    }

    /**
     * 跳转到跟团游列表页面
     * 并将搜索内容放在该列表页
     *
     * @param model
     * @param search
     * @return
     */
    @RequestMapping("tourList")
    public String tourList(Model model, @RequestParam(value = "search", required = false) String search) {
        model.addAttribute("search", search == null ? "" : search);
        return "userPage/tour-list";
    }

    /**
     * 跳转到景点列表页面
     * 并将搜索内容放在该列表页
     *
     * @param model
     * @param search
     * @return
     */
    @RequestMapping("viewList")
    public String viewList(Model model, @RequestParam(value = "search", required = false) String search) {
        model.addAttribute("search", search == null ? "" : search);
        return "userPage/view-list";
    }

    /**
     * 跳转到游记列表页面
     * 并将搜索内容放在该列表页
     *
     * @param model
     * @param search
     * @return
     */
    @RequestMapping("travelLogList")
    public String travelLogList(Model model, @RequestParam(value = "search", required = false) String search) {
        model.addAttribute("search", search == null ? "" : search);
        return "userPage/travel-log";
    }

    /**
     * 跳转到城市列表页面
     * 并将搜索内容放在该列表页
     *
     * @param model
     * @param search
     * @return
     */
    @RequestMapping("cityList")
    public String cityList(Model model, @RequestParam(value = "search", required = false) String search) {
        model.addAttribute("search", search == null ? "" : search);
        return "userPage/city-list";
    }

    @RequestMapping("travelLogEdit")
    public String travelLogEdit() {
        System.out.println("跳转到写游记页面");
        return "userPage/travel-log-edit";
    }

    @RequestMapping("wishlist")
    public String wishlistPage() {
        System.out.println("跳转到收藏页面");
        return "userPage/wishlist";
    }

    @RequestMapping("orderComplete")
    public String orderComplete() {
        System.out.println("跳转到订单完成页面");
        return "userPage/order-complete";
    }
}
