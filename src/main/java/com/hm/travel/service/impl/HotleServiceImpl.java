package com.hm.travel.service.impl;

import com.hm.travel.mapper.HotleMapper;
import com.hm.travel.pojo.Hotle;
import com.hm.travel.service.HotleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jlz
 * @date 2019/8/23 12:06
 */
@Service("hotleService")
public class HotleServiceImpl implements HotleService {
   @Autowired
   private HotleMapper hotleMapper;

    @Override
    public int addHotle(Hotle hotle) {
        return hotleMapper.addHotle(hotle);
    }
}
