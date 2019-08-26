package com.hm.travel.service.impl;

import com.hm.travel.mapper.TravelLogMapper;
import com.hm.travel.pojo.TravelLog;
import com.hm.travel.service.TravelLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jlz
 * @date 2019/8/24 13:53
 */
@Service("travellogService")
public class TravelLogServiceImpl implements TravelLogService {
    @Autowired
    private TravelLogMapper travelLogMapper;

    /**
     * 首页展示,查询4条数据
     *
     * @return 游记集合
     */
    @Override
    public List<TravelLog> getIndexTravelLog() {
        return travelLogMapper.getIndexTravelLog();
    }

    /**
     * 查询游记总数
     *
     * @return
     */
    @Override
    public int getTravelLogNum() {
        return travelLogMapper.getTravelLogNum();
    }

    /**
     * 根据ID查询游记,即用户查看该游记详情
     *
     * @param id
     * @return
     */
    @Override
    public TravelLog selectTravellogById(Integer id) {
        return travelLogMapper.selectTravellogById(id);
    }

    /**
     * 管理员更新游记状态
     *
     * @param id
     * @param tlStatus
     * @return
     */
    @Override
    public int updateTravellogStatus(Integer id, Integer tlStatus) {
        return travelLogMapper.updateTravellogStatus(id, tlStatus);
    }

    /**
     * 根据ID删除游记
     *
     * @param id
     * @return
     */
    @Override
    public int deleteTravellogById(Integer id) {
        return travelLogMapper.deleteTravellogById(id);
    }

    /**
     * 根据标题模糊查询游记
     *
     * @param tlTitle 标题
     * @return
     */
    @Override
    public List<TravelLog> selectTravelLogLikeTitle(String tlTitle) {
        return travelLogMapper.selectTravelLogLikeTitle(tlTitle);
    }

    /**
     * 查询所有游记
     *
     * @return 游记集合
     */
    @Override
    public List<TravelLog> getAllTravelLog() {
        return travelLogMapper.getAllTravelLog();
    }

    /**
     * 用户新增游记
     *
     * @param travelLog 游记
     * @return
     */
    @Override
    public int addTravelLog(TravelLog travelLog) {
        return travelLogMapper.addTravelLog(travelLog);
    }

    /**
     * 增加收藏数,每次掉用+1
     *
     * @param id 游记ID
     * @return
     */
    @Override
    public int addFavoriteCountNum(Integer id) {
        return travelLogMapper.addFavoriteCountNum(id);
    }

    /**
     * 减少收藏数,每次掉用-1
     *
     * @param id 游记ID
     * @return
     */
    @Override
    public int lowerFavoriteCountNum(Integer id) {
        return travelLogMapper.lowerFavoriteCountNum(id);
    }

    /**
     * 修改游记点击量,每次调用则点击量+1
     *
     * @param id 游记ID
     * @return
     */
    @Override
    public int clickCount(Integer id) {
        return travelLogMapper.clickCount(id);
    }

    /**
     * 增加点赞数,每次掉用+1
     *
     * @param id 游记ID
     * @return
     */
    @Override
    public int addLikeCountNum(Integer id) {
        return travelLogMapper.addLikeCountNum(id);
    }

    /**
     * 减少点赞数,每次掉用-1
     *
     * @param id 游记ID
     * @return
     */
    @Override
    public int lowerLikeCountNum(Integer id) {
        return travelLogMapper.lowerLikeCountNum(id);
    }
}
