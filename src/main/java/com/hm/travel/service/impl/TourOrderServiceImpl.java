package com.hm.travel.service.impl;

import com.hm.travel.mapper.TourOrderMapper;
import com.hm.travel.pojo.TourOrder;
import com.hm.travel.service.TourOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TourOrderServiceImpl implements TourOrderService {
    @Autowired
    TourOrderMapper tourOrderMapper;

    /**
     * 查询所有跟团游
     *
     * @return所有跟团游集合
     */
    @Override
    public List<TourOrder> findAll() {
        return tourOrderMapper.findAll();
    }

    /**
     * 添加TourOrder
     *
     * @param TourOrder
     * @return
     */
    @Override
    public int addTourOrder(TourOrder TourOrder) {
        return tourOrderMapper.addTourOrder(TourOrder);
    }

    /**
     * 修改TourOrder
     *
     * @param id
     * @return
     */
    @Override
    public int updateTourOrder(Integer id) {
        return tourOrderMapper.updateTourOrder(id);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Override
    public int deleteTourOrder(Integer id) {
        return tourOrderMapper.deleteTourOrder(id);
    }

    /**
     * 按条件查询
     *
     * @param district
     * @return
     */
    @Override
    public List<TourOrder> findTourOrderByCondition(String district) {
        return tourOrderMapper.findTourOrderByCondition(district);
    }

    /**
     * 通过id获得TourOrder
     *
     * @param id
     * @return
     */
    @Override
    public TourOrder selectTourOrderById(Integer id) {
        return tourOrderMapper.selectTourOrderById(id);
    }


}
