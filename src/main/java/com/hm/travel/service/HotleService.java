package com.hm.travel.service;

import com.hm.travel.pojo.Hotle;


import java.util.List;

/**
 * @author jlz
 * @date 2019/8/23 12:06
 */
public interface HotleService {

    /**
     * 查询所有酒店集合
     * @return
     */
    List<Hotle> getAllHotle();

    /**
     * 根据酒店名模糊查询酒店
     * @param hotleName
     * @return 酒店
     */
    List<Hotle> selectHotleByLikeName(String hotleName);

    /**
     * 根据ID查询酒店
     * @param id
     * @return
     */
    Hotle selectHotleById(Integer id);

    /**
     * 修改酒店信息,评分除外
     * @return
     */
    int updateHotle(Hotle hotle);


    /**
     * 添加酒店
     * @param hotle
     * @return
     */
    int addHotle(Hotle hotle);

    /**
     * 根据ID删除酒店
     * @return
     */
    int delectHotleById(Integer id);
}
