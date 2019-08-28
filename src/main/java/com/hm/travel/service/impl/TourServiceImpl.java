package com.hm.travel.service.impl;

import com.hm.travel.mapper.TourMapper;
import com.hm.travel.pojo.Tour;
import com.hm.travel.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TourServiceImpl implements TourService {
    @Autowired
    TourMapper tourMapper;

    /**
     * 查询所有跟团游
     *
     * @return所有跟团游集合
     */
    @Override
    public List<Tour> findAll() {
        return tourMapper.findAll();
    }

    /**
     * 添加tour
     *
     * @param tour
     * @return
     */
    @Override
    public int addTour(Tour tour) {
        return tourMapper.addTour(tour);
    }

    /**
     * 修改tour
     *
     * @param id
     * @return
     */
    @Override
    public int updateTour(Integer id) {
        return tourMapper.updateTour(id);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Override
    public int deleteTour(Integer id) {
        return tourMapper.deleteTour(id);
    }

    /**
     * 按条件查询
     *
     * @param district
     * @return
     */
    @Override
    public List<Tour> findTourByCondition(String district) {
        return tourMapper.findTourByCondition(district);
    }

    /**
     * 通过id获得Tour
     *
     * @param id
     * @return
     */
    @Override
    public Tour selectTourById(Integer id) {
        return tourMapper.selectTourById(id);
    }

    /**
     * 通过tourHead获得Tour
     *
     * @return 前6
     */
    @Override
    public List<Tour> selectTourByHead() {
        return tourMapper.selectTourByHead();
    }

    /**
     * 通过tourHead获得Tour
     *
     * @return 前1
     */
    @Override
    public Tour selectTourByHeadOne() {
        return tourMapper.selectTourByHeadOne();
    }

    @Override
    public List<Tour> selectTourLikeTitle(String search) {
        return tourMapper.selectTourLikeTitle(search);
    }
}
