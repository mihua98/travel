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
}
