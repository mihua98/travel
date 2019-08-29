package com.hm.travel.controller;

import com.hm.travel.pojo.City;
import com.hm.travel.pojo.Tour;
import com.hm.travel.pojo.TravelLog;
import com.hm.travel.pojo.View;
import com.hm.travel.service.CityService;
import com.hm.travel.service.TourService;
import com.hm.travel.service.TravelLogService;
import com.hm.travel.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * 跳转页面
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
        model.addAttribute("tours",tours);
        System.out.println("跟团游---"+tours);

        //加载四个城市
        List<City> cities = cityService.searchHotCity();
        model.addAttribute("cities",cities);
        System.out.println("4城市---"+cities);

        List<City> sixCity = cityService.searchHotSixCity();
        model.addAttribute("sixCity",sixCity);
        System.out.println("6城市---"+sixCity);

        //加载景点
        List<View> views = viewService.searchHotView();
        model.addAttribute("views",views);
        System.out.println("景点---"+views);

        //加载游记
        List<TravelLog> travelLogs = travelLogService.getIndexTravelLog();
        model.addAttribute("travelLogs",travelLogs);
        System.out.println("游记---"+travelLogs);

        System.out.println("跳转到首页");
        return "userPage/index";
    }

    @RequestMapping("tourList")
    public String tourList(Model model, @RequestParam(value = "search", required = false) String search) {
        model.addAttribute("search", search == null ? "" : search);
        System.out.println("跳转到跟团游列表页面");
        return "userPage/tour-list";
    }

    @RequestMapping("tourDetail")
    public String tourDetail() {
        System.out.println("跳转到跟团游详情页面");
        return "userPage/tour-detail";
    }

    @RequestMapping("viewList")
    public String viewList(Model model, @RequestParam(value = "search", required = false) String search) {
        model.addAttribute("search", search == null ? "" : search);
        System.out.println("跳转到景点列表页面");
        return "userPage/view-list";
    }

    @RequestMapping("viewDetail")
    public String viewDetail() {
        System.out.println("跳转到景点详情页面");
        return "userPage/view-detail";
    }

    @RequestMapping("travelLogList")
    public String travelLogList(Model model, @RequestParam(value = "search", required = false) String search) {
        model.addAttribute("search", search == null ? "" : search);
        System.out.println("跳转到游记列表页面");
        return "userPage/travel-log";
    }

    @RequestMapping("travelLogDetail")
    public String travelLogDetail() {
        System.out.println("跳转到游记详情页面");
        return "userPage/travel-log-detail";
    }

    @RequestMapping("cityList")
    public String cityList(Model model, @RequestParam(value = "search", required = false) String search) {
        model.addAttribute("search", search == null ? "" : search);
        System.out.println("跳转到城市列表页面");
        return "userPage/city-list";
    }

    @RequestMapping("cityDetail")
    public String cityDetail() {
        System.out.println("跳转到城市详情页面");
        return "userPage/city-detail";
    }

    @RequestMapping("travelLogEdit")
    public String travelLogEdit() {
        System.out.println("跳转到写游记页面");
        return "userPage/travel-log-edit";
    }

    @RequestMapping("wishlist")
    public String wishlistPage(){
        System.out.println("跳转到收藏页面");
        return "userPage/wishlist";
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
     * springMVC文件上传
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/fileUpLoad")
    public String fileUpLoad2(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("springMVC文件上传...");

        //使用fileupload组件完成文件上传
        //上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断该路径是否存在
        File file = new File(path);
        if (!file.exists()) {
            //创建该文件夹
            file.mkdirs();
        }

        //获取上传文件名称
        String filename = upload.getOriginalFilename();
        //把文件名称设置唯一值,uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;

        //完成文件上传
        upload.transferTo(new File(path, filename));
        //TODO 未完成...
        return null;
    }
}
