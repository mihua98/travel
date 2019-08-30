package com.hm.travel.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hm.travel.pojo.View;
import com.hm.travel.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ViewController {
    @Autowired
    ViewService viewService;

    @ResponseBody
    @RequestMapping("/getView/{id}")
    public View sesrchById(@PathVariable("id") int id) {
        View view = viewService.searchById(id);
        return view;
    }

    /**
     * 删除view
     *
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteView/{ids}")
    public String removeViewById(@PathVariable("ids") int id) {
        System.out.println(id);
        viewService.removeViewById(id);
        return "success";
    }

    /**
     * 通过名字查找view,用来校验
     *
     * @param name
     * @return
     */
    @ResponseBody
    @RequestMapping("/checkView")
    public String checkViewByName(@RequestParam("check") String name) {
        boolean b = viewService.findViewByName(name);
        if (b == true) {
            System.out.println(b);
            return "可以";
        } else {
            System.out.println(b);
            return "不可以";
        }

    }

    /**
     * 获得所有view
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/getAllView")
    public Map getAllView() {
        List<View> views = viewService.getAllView();
        System.out.println(views);
        Map<String, Object> map = new HashMap<>();
        map.put("views", views);
        return map;
    }

    /**
     * 添加view
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/addView")
    public String addView(View view) {
        System.out.println(view);
        viewService.addView(view);
        return "成功";
    }

    /**
     * 修改view
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/update/{Id}")
    public String updateView(View view) {
        viewService.updateView(view);
        return "成功";
    }


    /**
     * 模糊查询2
     */
    @ResponseBody
    @RequestMapping("/searchByWord2")
    public Map searchByWord2(@RequestParam("search") String word) {

        List<View> o = viewService.searchByWord2(word);
        Map<String, Object> map = new HashMap<>();
        map.put("search", o);
        return map;
    }


    /**
     * views分页
     *
     * @param pn
     * @return view集合
     */
    @ResponseBody
    @RequestMapping("/pageInfoViews")
    public PageInfo getpageInfoViews(
            @RequestParam(value = "pn", defaultValue = "1") Integer pn) {

        PageHelper.startPage(pn, 5);

        List<View> views = viewService.getAllView();

        PageInfo page = new PageInfo(views, 4);
        System.out.println(page.getList());

        return page;
    }

    /**
     * 用户查看景点,该游记点击量+1,转发至景点详情页
     *
     * @param id    景点id
     * @param model 将查询到的景点存于model中
     * @return 景点详情页
     */
    @RequestMapping("/selectViewById")
    public String selectViewById(@RequestParam("id") Integer id, Model model) {
        viewService.clickCount(id);
        View view = viewService.searchById(id);
        model.addAttribute("view", view);
        return "userPage/view-detail";
    }

    /**
     * 根据景点名模糊查询
     * 用PageHelper封装
     */
    @ResponseBody
    @RequestMapping("/searchByWord")
    public PageInfo<View> searchByWord(@RequestParam(value = "start", defaultValue = "1") int start,
                                       @RequestParam(value = "size", defaultValue = "4") int size,
                                       @RequestParam("search") String search) {
        PageHelper.startPage(start, size);
        List<View> list = viewService.searchByWord(search);
        PageInfo<View> page = new PageInfo<>(list);
        return page;
    }

    /**
     * 查询4个热门景点
     */

    @ResponseBody
    @RequestMapping("/searchHotView")
    public Map searchHotView() {
        List<View> views = viewService.searchHotView();
        Map<String, Object> map = new HashMap<>();
        map.put("search", views);
        return map;
    }

    /**
     * 根据城市id找出3个景点
     */
    @ResponseBody
    @RequestMapping("/searchHotViewByCityId")
    public List<View> searchHotViewByCityId(Integer id) {
        List<View> list = viewService.searchHotViewByCityId(id);
        return list;
    }

    /**
     * 跳转到景点列表页面
     *
     * @return
     */
    @RequestMapping("/viewListPage")
    public String viewListPage() {
        System.out.println("跳转页面");
        return "adminPage/viewListPage";
    }


}
