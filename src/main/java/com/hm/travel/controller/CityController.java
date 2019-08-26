package com.hm.travel.controller;

import com.hm.travel.pojo.City;
import com.hm.travel.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CityController {

          @Autowired
      private CityService cityService;

     @ResponseBody
    @RequestMapping("/delete")
    public  String removeCityById(@RequestParam("delete") int id){
        cityService.removeCityById(id);
        return "成功";
    }

    /**
     * 模糊查询2
     */
    @ResponseBody
    @RequestMapping("/searchByCity")
    public Map searchByWord2(@RequestParam("search") String word){

        List<City> city=cityService.SearchByWord(word);
        Map<String,Object> map=new HashMap<>();
        map.put("search",city);
        return  map;
    }
}
