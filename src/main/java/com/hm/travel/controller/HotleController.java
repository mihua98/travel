package com.hm.travel.controller;

import com.hm.travel.pojo.Hotle;
import com.hm.travel.service.HotleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author jlz
 * @date 2019/8/23 12:01
 */
@Controller
@RequestMapping("/hotle")
public class HotleController {
    @Autowired
    private HotleService hotleService;

    //面向用户:查所有,根据酒店名模糊查询,
    //面向管理员:查所有,根据酒店名模糊查询,根据ID查询(编辑时),编辑酒店信息,新增酒店,删除酒店

    /**
     * 根据ID删除酒店
     * @param id
     * @return 删除结果
     */
    @RequestMapping("/deleteHotleById")
    @ResponseBody
    public String deleteHotleById(@RequestParam("id") Integer id){
        int i = hotleService.delectHotleById(id);
        if (i>0){
            return "删除成功";
        }else{
            return "删除失败";
        }
    }


    /**
     * 更新酒店信息
     * @param hotle
     * @return 更新结果
     */
    @RequestMapping("/updateHotle")
    @ResponseBody
    public String updateHotle(Hotle hotle){
        int i = hotleService.updateHotle(hotle);
        if (i>0){
            return "更新成功";
        }else{
            return "更新失败";
        }
    }

    /**
     * 根据ID查询酒店
     * @param id
     * @return 酒店
     */
    @RequestMapping("/selectHotleById")
    @ResponseBody
    public Hotle selectHotleById(@RequestParam("id") Integer id){
        Hotle hotle = hotleService.selectHotleById(id);
        return hotle;
    }

    /**
     * 根据酒店名模糊查询
     * @param hotleName
     * @return 酒店集合
     */
    @RequestMapping("/selectHotleLikeName")
    @ResponseBody
    public List<Hotle> selectHotleLikeName(String hotleName){
        List<Hotle> hotles = hotleService.selectHotleByLikeName(hotleName);
        return hotles;
    }


    /**
     * 查询酒店集合
     * @return 酒店集合
     */
    @RequestMapping("/getAllHotle")
    @ResponseBody
    public List<Hotle> getAllHotle(){
        List<Hotle> hotles = hotleService.getAllHotle();
        return hotles;
    }

    /**
     * 添加酒店
     * @param hotle
     * @return
     */
   @RequestMapping("/addHotle")
   @ResponseBody
    public String addHotle(Hotle hotle){
       int i = hotleService.addHotle(hotle);
       System.out.println(i);
       if (i>0){
           return "成功";
       }
       return "失败";
   }



}
