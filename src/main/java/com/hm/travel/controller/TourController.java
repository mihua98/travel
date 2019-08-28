package com.hm.travel.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hm.travel.pojo.Tour;
import com.hm.travel.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TourController {
    @Autowired
    TourService tourService;

    @GetMapping("getAllTour")
    public String Tourlist(Model model) {
        model.addAttribute("tours", tourService.findAll());
        return "/adminPage/tourlist";
    }

    /**
     * 用户查看城市,该城市点击量+1,转发至城市详情页
     *
     * @param id    城市id
     * @param model 将查询到的城市存于model中
     * @return 城市详情页
     */

    @RequestMapping("/selectTourById")
    public String selectTourById(@RequestParam("id") Integer id, Model model) {
        Tour tour = tourService.selectTourById(id);
        model.addAttribute("tour", tour);
        return "userPage/tour-detail";
    }

    /**
     * 根据跟团游名字模糊查询
     *
     * @param search
     * @return 游记集合
     */
    @RequestMapping("/selectTourLikeTitle")
    @ResponseBody
    public PageInfo<Tour> selectTourLikeTitle(@RequestParam(value = "start", defaultValue = "1") int start,
                                              @RequestParam(value = "size", defaultValue = "4") int size,
                                              @RequestParam("search") String search) {
        PageHelper.startPage(start, size);
        List<Tour> list = tourService.selectTourLikeTitle(search);
        PageInfo<Tour> page = new PageInfo<>(list);
        return page;
    }

}
