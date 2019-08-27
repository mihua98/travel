package com.hm.travel.mapper;

import com.hm.travel.pojo.City;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityMapper {
    //根据id删除city
    public void removeCityById(int id);

    //根据city字段模糊查询
    public List<City> searchByWord3(String word);

    //修改城市点击量，每次调用点击量加1，id是城市id
    public int clickCount(int id);

    //得到所有城市信息
    public List<City> getAllCity();

    //根据id查询城市
    public City getCityById(int id);

    //根据城市名字模糊查询城市
    public List<City> searchCityByName(String word);

    //查询最热门的六个城市
    public List<City> searchHotCity();
}
