package com.hm.travel.controller;

import com.hm.travel.pojo.Hotle;
import com.hm.travel.service.HotleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jlz
 * @date 2019/8/23 12:01
 */
@Controller
@RequestMapping("/hotle")
public class HotleController {
    @Autowired
    private HotleService hotleService;

   @RequestMapping("/addHotle")
   @ResponseBody
    public String aa(Hotle hotle){
       int i = hotleService.addHotle(hotle);
       System.out.println(i);
       if (i>0){
           return "成功";
       }
       return "失败";
   }
}
