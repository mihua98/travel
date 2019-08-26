package com.hm.travel.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hm.travel.pojo.View;
import com.hm.travel.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ViewController {
       @Autowired
    ViewService viewService;

       @ResponseBody
       @RequestMapping("/getView/{id}")
       public  View sesrchById(@PathVariable("id") int id){
           View view=viewService.searchById(id);
           return view;
       }

    /**
     * 删除view
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteView/{ids}")
    public String removeViewById(@PathVariable("ids") int id){
        System.out.println(id);
        viewService.removeViewById(id);
        return  "success";
    }

    /**
     *  通过名字查找view,用来校验
     * @param name
     * @return
     */
    @ResponseBody
    @RequestMapping("/checkView")
    public  String checkViewByName(@RequestParam("check") String name){
        boolean b=viewService.findViewByName(name);
        if(b==true){
            System.out.println(b);
            return "可以";
        }else{
            System.out.println(b);
            return "不可以";
        }

    }

    /**
     * 获得所有view
     * @return
     */
    @ResponseBody
    @RequestMapping("/getAllView")
    public Map getAllView(){
        List<View> views =viewService.getAllView();
        System.out.println(views);
        Map<String,Object> map=new HashMap<>();
        map.put("views",views);
        return map;
    }

    /**
     * 添加view
     * @return
     */
    @ResponseBody
    @RequestMapping("/addView")
    public String addView(View view){
        System.out.println(view);
        viewService.addView(view);
        return "成功";
    }

    /**
     * 修改view
     * @return
     */
    @ResponseBody
    @RequestMapping("/update/{Id}")
    public  String updateView(View view){
        viewService.updateView(view);
        return "成功";
    }

    /**
     * 模糊查询
     */
    @ResponseBody
    @RequestMapping("/searchByWord")
    public Map searchByWord(@RequestParam("search") String word){
        List<View> views=viewService.searchByWord(word);
        Map<String,Object> map=new HashMap<>();
        map.put("search",views);
        return  map;
    }

    /**
     * 模糊查询2
     */
    @ResponseBody
    @RequestMapping("/searchByWord2")
    public Map searchByWord2(@RequestParam("search") String word){

        List<View> o=viewService.searchByWord2(word);
        Map<String,Object> map=new HashMap<>();
        map.put("search",o);
        return  map;
    }


    /**
     * views分页
     * @param pn
     * @return
     */
    @ResponseBody
    @RequestMapping("/pageInfoViews")
    public PageInfo getpageInfoViews(
            @RequestParam(value="pn",defaultValue="1") Integer pn) {

        PageHelper.startPage(pn, 2);

        List<View> views = viewService.getAllView();

        PageInfo page = new PageInfo(views, 2);
        System.out.println(page.getList());

        return page;
    }
}
