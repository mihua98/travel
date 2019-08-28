package com.hm.travel.service;

import com.hm.travel.pojo.TourOrder;

import java.util.List;

public interface TourOrderService {
    // 实现对跟团游表订单的crud操作

    /**
     * 查询所有跟团游
     * @return所有跟团游集合
     */
    List<TourOrder> findAll();

    /**
     * 添加TourOrder
     * @param TourOrder
     * @return
     */
    int addTourOrder(TourOrder TourOrder);

    /**
     * 修改TourOrder
     * @param id
     * @return
     */
    int updateTourOrder(Integer id);
    /**
     * 删除
     * @param id
     * @return
     */
    int deleteTourOrder(Integer id);
    /**
     * 按条件查询
     * @param district
     * @return
     */
    List<TourOrder> findTourOrderByCondition(String district);

    /**
     *通过id获得TourOrder
     * @param id
     * @return
     */
    TourOrder selectTourOrderById(Integer id);


}

