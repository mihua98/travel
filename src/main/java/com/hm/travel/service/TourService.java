package com.hm.travel.service;

import com.hm.travel.pojo.Tour;

import java.util.List;

public interface TourService {
    // 实现对跟团游表的crud操作

    /**
     * 查询所有跟团游
     *
     * @return所有跟团游集合
     */
    List<Tour> findAll();

    /**
     * 添加tour
     *
     * @param tour
     * @return
     */
    int addTour(Tour tour);

    /**
     * 修改tour
     *
     * @return
     */
    int updateTour(Tour tour);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int deleteTour(Integer id);

    /**
     * 按条件查询
     *
     * @param district
     * @return
     */
    List<Tour> findTourByCondition(String district);

    /**
     * 通过id获得Tour
     *
     * @param id
     * @return
     */
    Tour selectTourById(Integer id);

    /**
     * 通过tourHead获得Tour
     *
     * @param
     * @return 前6
     */
    List<Tour> selectTourByHead();

    /**
     * 通过tourHead获得Tour
     *
     * @param
     * @return 前1
     */
    Tour selectTourByHeadOne();

    /**
     * 根据名字模糊查询
     *
     * @param search
     * @return
     */
    List<Tour> selectTourLikeTitle(String search);
}
