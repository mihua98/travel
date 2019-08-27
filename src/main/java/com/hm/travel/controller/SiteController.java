package com.hm.travel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

/**
 * 跳转页面
 * @author: xiaomikasa
 * @date: 2019/8/24
 */
@Controller
public class SiteController {

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

    @RequestMapping("travelLogEdit")
    public String travelLogEdit() {
        System.out.println("跳转到写游记页面");
        return "userPage/travel-log-edit";
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

        return "welcome";
    }
}
