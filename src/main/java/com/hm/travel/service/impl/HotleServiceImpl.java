package com.hm.travel.service.impl;

import com.hm.travel.mapper.HotleMapper;
import com.hm.travel.pojo.Hotle;
import com.hm.travel.service.HotleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jlz
 * @date 2019/8/23 12:06
 */
@Service("hotleService")
public class HotleServiceImpl implements HotleService {
   @Autowired
   private HotleMapper hotleMapper;

    @Override
    public List<Hotle> getAllHotle() {
        return hotleMapper.getAllHotle();
    }

    @Override
    public List<Hotle> selectHotleByLikeName(String hotleName) {
        return hotleMapper.selectHotleByLikeName(hotleName);
    }

    @Override
    public Hotle selectHotleById(Integer id) {
        return hotleMapper.selectHotleById(id);
    }

    @Override
    public int updateHotle(Hotle hotle) {
        return hotleMapper.updateHotle(hotle);
    }

    @Override
    public int addHotle(Hotle hotle) {
        return hotleMapper.addHotle(hotle);
    }

    @Override
    public int delectHotleById(Integer id) {
        return hotleMapper.delectHotleById(id);
    }
}
