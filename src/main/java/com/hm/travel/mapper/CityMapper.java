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
}
