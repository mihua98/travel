package com.hm.travel.controller;

import com.hm.travel.pojo.City;
import com.hm.travel.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CityController {

    @Autowired
    private CityService cityService;

    /**
     * 根据id查询城市
     *
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/getCity/{id}")
    public City sesrchById(@PathVariable("id") int id) {
        City city = cityService.searchById(id);
        return city;
    }

    @ResponseBody
    @RequestMapping("/delete")
    public String removeCityById(@RequestParam("delete") int id) {
        cityService.removeCityById(id);
        return "成功";
    }

    /**
     * 模糊查询2
     */
    @ResponseBody
    @RequestMapping("/searchByCity")
    public Map searchByWord2(@RequestParam("search") String word) {

        List<City> city = cityService.SearchByWord(word);
        Map<String, Object> map = new HashMap<>();
        map.put("search", city);
        return map;
    }

    /**
     * city分页
     *
     * @param pn
     * @return city集合
     */
    @ResponseBody
    @RequestMapping("/pageInfoCitys")
    public PageInfo getpageInfoViews(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {

        PageHelper.startPage(pn, 5);

        List<City> citys = cityService.getAllCity();

        PageInfo page = new PageInfo(citys, 2);
        System.out.println(page.getList());

        return page;
    }

    /**
     * 用户查看城市,该城市点击量+1,转发至城市详情页
     *
     * @param id    城市id
     * @param model 将查询到的城市存于model中
     * @return 城市详情页
     */

    @RequestMapping("/selectCityById")
    public String selectCityById(@RequestParam("id") Integer id, Model model) {
        cityService.clickCount(id);
        City city = cityService.getCityById(id);
        model.addAttribute("city", city);
        return "userPage/city-detail";
    }

    /**
     * 用户查询城市,转发至城市详情页
     * 用PageHelper封装
     *
     * @param search 城市名字模糊
     * @return
     */
    @ResponseBody
    @RequestMapping("/searchCityByName")
    public PageInfo<City> searchCityByName(@RequestParam(value = "start", defaultValue = "1") int start,
                                           @RequestParam(value = "size", defaultValue = "4") int size,
                                           @RequestParam("search") String search) {
        PageHelper.startPage(start, size);
        List<City> list = cityService.searchCityByName(search);
        PageInfo<City> page = new PageInfo<>(list);
        return page;
    }

    /**
     * 查询最热门6个城市
     */
    @ResponseBody
    @RequestMapping("/searchHotCity")
    public Map searchHotCity() {
        List<City> citys = cityService.searchHotCity();
        Map<String, Object> map = new HashMap<>();
        map.put("search", citys);
        return map;
    }


    /**
     * 跳转到城市列表页面
     *
     * @return
     */
    @RequestMapping("/cityListPage")
    public String cityListPage() {
        System.out.println("跳转页面");
        return "adminPage/cityListPage";
    }

    /**
     * 添加city
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/addCity")
    public String addCity(City city) {
        System.out.println(city);
        cityService.addCity(city);
        return "成功";
    }

    /**
     * 修改city
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateCity/{Id}")
    public String updateCity(City city) {
        cityService.updateCity(city);
        return "成功";
    }

}
