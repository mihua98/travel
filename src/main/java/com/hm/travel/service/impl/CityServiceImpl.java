package com.hm.travel.service.impl;

import com.hm.travel.mapper.CityMapper;
import com.hm.travel.pojo.City;
import com.hm.travel.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
     @Autowired
    private CityMapper cityMapper;


    @Override
    public void removeCityById(int id) {
        cityMapper.removeCityById(id);
    }

    @Override
    public List<City> SearchByWord(String word) {
        return cityMapper.searchByWord3(word);
    }

    /**
     * 修改城市点击量,每次调用则点击量+1
     *
     * @param id 城市ID
     * @return
     */
    @Override
    public int clickCount(Integer id) {
        return cityMapper.clickCount(id);
    }

    /**
     * 得到所有城市信息
     * @return
     */
    @Override
    public List<City> getAllCity() {
        return cityMapper.getAllCity();
    }

    /**
     * 通过id查询城市信息
     * @param id
     * @return
     */
    @Override
    public City getCityById(int id) {
        return cityMapper.getCityById(id);
    }

    /**
     * 根据名字模糊查询城市信息
     * @param word
     * @return
     */
    @Override
    public List<City> searchCityByName(String word) {
        return cityMapper.searchCityByName(word);
    }

    @Override
    public List<City> searchHotCity() {
        return cityMapper.searchHotCity();
    }


}
