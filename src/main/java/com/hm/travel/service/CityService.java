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

    /**
     * 修改城市点击量,每次调用则点击量+1
     *
     * @param id 城市ID
     * @return
     */
    int clickCount(Integer id);

    /**
     * 得到所有城市信息
     * @return
     */
    List<City> getAllCity();

    /**
     * 根据id查询城市
     * @param id
     * @return
     */
    City getCityById(int id);

    /**
     * 根据名字模糊查询城市信息
     * @param word
     * @return
     */
    List<City> searchCityByName(String word);

    /**
     * 查询最热门的六个城市
     */
    List<City> searchHotCity();

}
