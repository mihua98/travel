package com.hm.travel.service;

import com.hm.travel.pojo.City;

import java.util.List;

public interface CityService {
    /**
     * 根据id删除city
     * @param id
     */
    void  removeCityById(int id);

    /**
     *  根据city中的字模糊查询出城市与相关景点的信息
     * @param word
     * @return
     */
    List<City> SearchByWord(String word);
}
