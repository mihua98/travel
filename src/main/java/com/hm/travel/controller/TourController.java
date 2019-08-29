package com.hm.travel.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hm.travel.pojo.Tour;
import com.hm.travel.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TourController {
    @Autowired
    TourService tourService;

    /**
     * 管理员修改跟团游,  根据ID修改
     * @param tour
     * @return
     */
    @RequestMapping("/updateTourById")
    @ResponseBody
    public String updateTourById(@RequestBody Tour tour){
        System.out.println("状态--------"+tour.getTourStatus());
        int i = tourService.updateTour(tour);
        if (i > 0) {
            return "修改成功";
        } else {
            return "修改失败";
        }
    }



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

    /**
     * 后台分页查询
     * @param start
     * @param size
     * @return TourListPage
     */
    @RequestMapping("/TourListPage")
    @ResponseBody
    public PageInfo<Tour>  TourListPage(@RequestParam(value = "start",defaultValue = "0")int start,
                                        @RequestParam(value = "size",defaultValue = "5")int size) {
        List<Tour> list = tourService.findAll();
        // 将查询的数据以分页的形式展示
        PageHelper.startPage(start, size);
        PageInfo<Tour> page = new PageInfo<>(list);

        return page;
    }
    /**
     * page更新   根据ID查询
     * @param id
     * @return
     */
    @RequestMapping("updateTourpage")
    @ResponseBody
    public Tour updateTourpage(Integer id){
        Tour tour = tourService.selectTourById(id);

        return tour;
    }

    /**
     * page删除
     * @param id
     * @return
     */
    @RequestMapping("deleteTourpage")
    public String deleteTour(Integer id){
        tourService.deleteTour(id);
        return "redirect:TourPage";
    }

    /**
     * page添加
     * @param tour
     * @return
     */

    @RequestMapping("insetTourpage")
    public String insetTourpage(Tour tour) {
        tourService.addTour(tour);
        return "redirect:TourPage";
    }
}
