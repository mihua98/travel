package com.hm.travel.service;

import com.hm.travel.pojo.TravelLog;
import org.apache.ibatis.annotations.Select;


import java.util.List;

/**
 * @author jlz
 * @date 2019/8/24 13:51
 */
public interface TravelLogService {
    //面向用户:新增游记,点击,点赞,收藏,查询所有游记,根据标题模糊查询
    //面向管理员:更改游记状态,查询所有游记,删除游记,根据标题模糊查询

    /**
     * 游记推荐调用,根据点击量查询前三条游记
     * @return
     */
    List<TravelLog> getHotTravelLog();

    /**
     * 查询所有游记(包含不可读游记,管理员调用)
     * @return
     */
    List<TravelLog> getAnyTravelLog();


    /**
     * 首页展示,查询4条数据
     * @return 游记集合
     */
    List<TravelLog> getIndexTravelLog();

    /**
     * 查询游记总数
     * @return
     */
    int getTravelLogNum();

    /**
     * 根据ID查询游记,即用户查看该游记详情
     * @param id
     * @return
     */
    TravelLog selectTravellogById(Integer id);

    /**
     * 管理员更新游记状态
     * @param id
     * @param tlStatus
     * @return
     */
    int updateTravellogStatus(TravelLog travelLog);


    /**
     * 根据ID删除游记
     * @param id
     * @return
     */
    int deleteTravellogById(Integer id);


    /**
     * 根据标题模糊查询游记
     * @param tlTitle 标题
     * @return
     */
    List<TravelLog> selectTravelLogLikeTitle(String tlTitle);

    /**
     * 查询所有可读游记
     * @return 游记集合
     */
    List<TravelLog> getAllTravelLog();

    /**
     * 用户新增游记
     *@param travelLog 游记
     * @return
     */
    int addTravelLog(TravelLog travelLog);


    /**
     * 增加收藏数,每次掉用+1
     *
     * @param id 游记ID
     * @return
     */
    int addFavoriteCountNum(Integer id);

    /**
     * 减少收藏数,每次掉用-1
     *
     * @param id 游记ID
     * @return
     */
    int lowerFavoriteCountNum(Integer id);


    /**
     * 修改游记点击量,每次调用则点击量+1
     *
     * @param id 游记ID
     * @return
     */
    int clickCount(Integer id);

    /**
     * 增加点赞数,每次掉用+1
     *
     * @param id 游记ID
     * @return
     */
    int addLikeCountNum(Integer id);

    /**
     * 减少点赞数,每次掉用-1
     *
     * @param id 游记ID
     * @return
     */
    int lowerLikeCountNum(Integer id);
}
